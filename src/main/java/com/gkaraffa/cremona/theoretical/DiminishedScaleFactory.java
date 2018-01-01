package com.gkaraffa.cremona.theoretical;

public class DiminishedScaleFactory extends ScaleFactory {

  public DiminishedScaleFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!(validateInputPattern(intervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }

    ScaleQuality scaleQuality = ScaleQuality.DIMINISHED;
    Tone tones[] = this.createToneArray(intervalPattern, key);

    return new DiminishedScale(key.getText() + " " + intervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    // TODO Auto-generated method stub
    if (!(intervalPattern.getText().contains("Diminished"))) {
      return false;
    }
    return true;
  }

}
