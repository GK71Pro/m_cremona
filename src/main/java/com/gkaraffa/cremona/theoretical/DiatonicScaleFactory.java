package com.gkaraffa.cremona.theoretical;

public class DiatonicScaleFactory extends ScaleFactory {

  public DiatonicScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!validateInputPattern(intervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    Tone[] tones = this.createToneArray(intervalPattern, key);

    return new DiatonicScale(key.getText() + " " + intervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByLocation(1);
    Interval fifthInterval = intervalPattern.getIntervalByLocation(3);
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

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.SECOND) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FOURTH) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.SIXTH) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.SEVENTH) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.EIGHTH) == null) {
      return false;
    }

    return true;
  }
  
  public static String ionianPatternString = "M2,M3,P4,P5,M6,M7,P8";
  public static String dorianPatternString = "M2,m3,P4,P5,M6,m7,P8";
  public static String phrygianPatternString = "m2,m3,P4,P5,m6,m7,P8";
  public static String lydianPatternString = "M2,M3,A4,P5,M6,M7,P8";
  public static String mixolydianPatternString = "M2,M3,P4,P5,M6,m7,P8";
  public static String aeolianPatternString = "M2,m3,P4,P5,m6,m7,P8";
  public static String locrianPatternString = "m2,m3,P4,d5,m6,m7,P8";
  public static String harmonicMinorPatternString = "M2,m3,P4,P5,m6,M7,P8";
  public static String melodicMinorPatternString = "M2,m3,P4,P5,M6,M7,P8";

}
