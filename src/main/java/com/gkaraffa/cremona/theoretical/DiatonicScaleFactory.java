package com.gkaraffa.cremona.theoretical;

public class DiatonicScaleFactory extends ScaleFactory {

  public DiatonicScaleFactory() {}

  @Override
  public Scale createScale(ScalarIntervalPattern scalarIntervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!validateInputPattern(scalarIntervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(scalarIntervalPattern);
    Tone[] tones = this.createToneArray(scalarIntervalPattern, key);

    return new DiatonicScale(key.getText() + " " + scalarIntervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(ScalarIntervalPattern scalarIntervalPattern) {
    Interval thirdInterval = scalarIntervalPattern.getIntervalByLocation(1);
    Interval fifthInterval = scalarIntervalPattern.getIntervalByLocation(3);
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
  protected boolean validateInputPattern(ScalarIntervalPattern scalarIntervalPattern) {
    if (scalarIntervalPattern.getSize() != 7) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.SECOND) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.FOURTH) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.SIXTH) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.SEVENTH) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.EIGHTH) == null) {
      return false;
    }

    return true;
  }
}
