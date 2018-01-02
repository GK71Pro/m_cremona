package com.gkaraffa.cremona.theoretical;

public class WholeToneScaleFactory extends ScaleFactory {

  public WholeToneScaleFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!(validateInputPattern(intervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    Tone tones[] = this.createToneArray(intervalPattern, key);

    return new WholeToneScale(key.getText() + " " + intervalPattern.getText(), tones, scaleQuality,
        intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    return ScaleQuality.WHOLE_TONE;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    // TODO Auto-generated method stub
    if (!(intervalPattern.getText().contains("Whole Tone"))) {
      return false;
    }
    return true;
  }

}
