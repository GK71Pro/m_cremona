package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiatonicScaleFactory extends ScaleFactory {

  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    HARMONIC_MINOR_PATTERN = iPF.createIntervalPattern("Harmonic Minor", "P1,M2,m3,P4,P5,m6,M7");
    MELODIC_MINOR_PATTERN = iPF.createIntervalPattern("Melodic Minor", "P1,M2,m3,P4,P5,M6,M7");
    IONIAN_PATTERN = iPF.createIntervalPattern("Ionian", "P1,M2,M3,P4,P5,M6,M7");
    DORIAN_PATTERN = iPF.createIntervalPattern("Dorian", "P1,M2,m3,P4,P5,M6,m7");
    PHRYGIAN_PATTERN = iPF.createIntervalPattern("Phrygian", "P1,m2,m3,P4,P5,m6,m7");
    LYDIAN_PATTERN = iPF.createIntervalPattern("Lydian", "P1,M2,M3,A4,P5,M6,M7");
    MIXOLYDIAN_PATTERN = iPF.createIntervalPattern("Mixolydian", "P1,M2,M3,P4,P5,M6,m7");
    AEOLIAN_PATTERN = iPF.createIntervalPattern("Aeolian", "P1,M2,m3,P4,P5,m6,m7");
    LOCRIAN_PATTERN = iPF.createIntervalPattern("Locrian", "P1,m2,m3,P4,d5,m6,m7");
  }

  public DiatonicScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!validateInputPattern(intervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return new DiatonicScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleQuality, intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByLocation(2);
    Interval fifthInterval = intervalPattern.getIntervalByLocation(4);
    ScaleQuality scaleQuality = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        if (fifthInterval == Interval.DIMINISHED_FIFTH) {
          scaleQuality = ScaleQuality.DIMINISHED;
        }
        else {
          scaleQuality = ScaleQuality.MINOR;
        }
        break;

      case MAJOR_THIRD:
        if (fifthInterval == Interval.AUGMENTED_FIFTH) {
          scaleQuality = ScaleQuality.AUGMENTED;
        }
        else {
          scaleQuality = ScaleQuality.MAJOR;
        }
        break;

      default:
        throw new IllegalArgumentException();
    }

    return scaleQuality;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 7) {
      return false;
    }

    IntervalNumber intervalNumbers[] = IntervalNumber.values();
    for (int index = 1; index < 7; index++) {
      if (intervalPattern.getIntervalByIntervalNumber(intervalNumbers[index]) == null) {
        return false;
      }
    }

    return true;
  }

  public static IntervalPattern IONIAN_PATTERN;
  public static IntervalPattern DORIAN_PATTERN;
  public static IntervalPattern PHRYGIAN_PATTERN;
  public static IntervalPattern LYDIAN_PATTERN;
  public static IntervalPattern MIXOLYDIAN_PATTERN;
  public static IntervalPattern AEOLIAN_PATTERN;
  public static IntervalPattern LOCRIAN_PATTERN;
  public static IntervalPattern HARMONIC_MINOR_PATTERN;
  public static IntervalPattern MELODIC_MINOR_PATTERN;
}
