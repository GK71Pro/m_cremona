package com.gkaraffa.cremona.theoretical.analysis;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;
import com.gkaraffa.cremona.theoretical.chord.ChordNomenclature;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class RomanNumeral {
  private Interval interval;
  private ChordNomenclature chordNomenclature;
  private String text;


  public RomanNumeral(Interval interval, ChordNomenclature chordNomenclature, String text) {
    this.interval = interval;
    this.chordNomenclature = chordNomenclature;
    this.text = text;
  }

  public Interval getInterval() {
    return interval;
  }

  public ChordNomenclature getChordNomenclature() {
    return chordNomenclature;
  }

  public String getText() {
    return text;
  }

  public static RomanNumeral createRomanNumeral(DiatonicScale diatonicScale, int position) {
    // get interval
    Interval interval = diatonicScale.getIntervalPattern().getIntervalByLocation(position);

    // get chordNomenclature
    // create chord
    ChordFactory chordFactory = new ChordFactory();
    Chord chord = chordFactory.createChordFromHarmonizableScale(diatonicScale,
        diatonicScale.getToneCollection().getTone(position), 3);
    ChordNomenclature chordNomenclature = chord.getChordNomenclature();

    String text = evaluate(interval, chordNomenclature);

    return new RomanNumeral(interval, chordNomenclature, text);

  }

  private static String evaluate(Interval interval, ChordNomenclature chordNomenclature)
      throws IllegalArgumentException {
    String raw = null;

    switch (interval.getIntervalNumber()) {
      case FIRST:
        raw = "I";
        break;
      case SECOND:
        raw = "II";
        break;
      case THIRD:
        raw = "III";
        break;
      case FOURTH:
        raw = "IV";
        break;
      case FIFTH:
        raw = "V";
        break;
      case SIXTH:
        raw = "VI";
        break;
      case SEVENTH:
        raw = "VII";
        break;
      default:
        throw new IllegalArgumentException("Inapplicable IntervalNumber");
    }

    switch (chordNomenclature) {
      case MAJOR:
        return raw;
      case MINOR:
        return raw.toLowerCase();
      case DIMINISHED:
        return raw.toLowerCase() + "°";
      case AUGMENTED:
        return raw + "+";
      default:
        throw new IllegalArgumentException("Inapplicable ChordNomenclature");
    }
  }

}
