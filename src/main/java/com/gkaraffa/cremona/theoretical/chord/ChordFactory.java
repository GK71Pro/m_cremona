package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternBuilder;
import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.ToneCollectionBuilder;
import com.gkaraffa.cremona.theoretical.scale.HarmonizableScale;

public class ChordFactory {
  public ChordFactory() {}

  public Chord createChordFromIntervalPattern(IntervalPattern intervalPattern, Tone tonic) {
    ToneCollection toneCollection = intervalPattern.toToneCollection(tonic);
    ChordNomenclature chordNomenclature = evaluatechordNomenclatureFromIntervalPattern(intervalPattern);

    Chord chord = new Chord(toneCollection.getTone(0).toString() + " " + chordNomenclature.getText(),
        toneCollection, chordNomenclature, intervalPattern, null);

    return chord;
  }

  public Chord createChordFromHarmonizableScale(HarmonizableScale harmonizableScale, Tone tonic,
      int toneCount) {
    ToneCollection toneCollection =
        buildToneCollectionFromHarmonizableScaleAndTonic(harmonizableScale, tonic, toneCount);
    IntervalPattern intervalPattern = convertScaleToneCollectionToChordIntervalPattern(toneCollection);
    ChordNomenclature chordNomenclature = evaluatechordNomenclatureFromIntervalPattern(intervalPattern);

    Chord chord = new Chord(toneCollection.getTone(0).toString() + " " + chordNomenclature.getText(),
        toneCollection, chordNomenclature, intervalPattern, null);

    return chord;
  }

  private ToneCollection buildToneCollectionFromHarmonizableScaleAndTonic(
      HarmonizableScale harmonizableScale, Tone tonic, int toneCount) {
    ToneCollectionBuilder tCB = new ToneCollectionBuilder();
    ToneCollection toneCollection = harmonizableScale.getToneCollection();
    int position = toneCollection.getPosition(tonic);

    for (int i = 0, offset = 0; i < toneCount; i++, offset += 2) {
      tCB.append(toneCollection.getTone(position + offset));
    }

    return tCB.toToneCollection();
  }

  private IntervalPattern convertScaleToneCollectionToChordIntervalPattern(ToneCollection toneCollection) {
    int toneCount = toneCollection.getSize();
    IntervalPatternBuilder intervalPatternBuilder = new IntervalPatternBuilder();

    intervalPatternBuilder.append(Interval.UNISON);

    for (int index = 0, offset = 2; index < toneCount - 1; index++, offset += 2) {
      int distance = TonalSpectrum.measureDistance(toneCollection.getTone(0),
          toneCollection.getTone(index + 1));
      IntervalNumber intervalNumber = IntervalNumber.integerToIntervalNumber(offset);
      Interval interval = Interval.halfStepsAndIntervalNumberToInterval(distance, intervalNumber);
      intervalPatternBuilder.append(interval);
    }

    return intervalPatternBuilder.toIntervalPattern();
  }

  private ChordNomenclature evaluatechordNomenclatureFromIntervalPattern(IntervalPattern intervalPattern) {
    NomenclatureEvaluationRule qualityRule =
        chooseQualityEvaluationRuleForIntervalPattern(intervalPattern);
    ChordNomenclature chordNomenclature = qualityRule.applyRuleForIntervalPattern(intervalPattern);

    return chordNomenclature;
  }

  private NomenclatureEvaluationRule chooseQualityEvaluationRuleForIntervalPattern(
      IntervalPattern intervalPattern) {
    if (isTriad(intervalPattern)) {
      return new TriadNomenclatureEvaluationRule();
    }
    else if (isSeventhChord(intervalPattern)) {
      return new SeventhChordNomenclatureEvaluationRule();
    }

    throw new IllegalArgumentException();
  }

  private boolean isTriad(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 3) {
      return false;
    }

    int count = 0;
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.FIRST);
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.THIRD);
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.FIFTH);

    if (count != 3) {
      return false;
    }

    return true;
  }

  private boolean isSeventhChord(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 4) {
      return false;
    }

    int count = 0;
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.FIRST);
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.THIRD);
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.FIFTH);
    count += intervalPattern.getCountByIntervalNumber(IntervalNumber.SEVENTH);

    if (count != 4) {
      return false;
    }

    return true;
  }
}
