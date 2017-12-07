package com.gkaraffa.cremona.theoretical;

public class PentatonicScaleFactory extends ScaleFactory {

  public PentatonicScaleFactory() {}

  @Override
  public Scale createScale(ScalarIntervalPattern scalarIntervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!validateInputPattern(scalarIntervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(scalarIntervalPattern);
    Tone[] tones = this.createToneArray(scalarIntervalPattern, key);

    return new PentatonicScale(key.getText() + " " + scalarIntervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(ScalarIntervalPattern scalarIntervalPattern) {
    Interval thirdInterval =
        scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
    ScaleQuality scaleQuality = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        scaleQuality = ScaleQuality.MINOR;
        break;

      case MAJOR_THIRD:
        scaleQuality = ScaleQuality.MAJOR;
        break;

      default:
        throw new IllegalArgumentException();
    }

    return scaleQuality;
  }

  @Override
  protected boolean validateInputPattern(ScalarIntervalPattern scalarIntervalPattern) {
    if (scalarIntervalPattern.getSize() != 5) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH) == null) {
      return false;
    }

    if (scalarIntervalPattern.getIntervalByIntervalNumber(IntervalNumber.EIGHTH) == null) {
      return false;
    }

    return true;
  }
}
