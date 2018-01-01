package com.gkaraffa.cremona.theoretical;

public class PentatonicScaleFactory extends ScaleFactory {

  public PentatonicScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!validateInputPattern(intervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    Tone[] tones = this.createToneArray(intervalPattern, key);

    return new PentatonicScale(key.getText() + " " + intervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
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
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 5) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.EIGHTH) == null) {
      return false;
    }

    return true;
  }
}
