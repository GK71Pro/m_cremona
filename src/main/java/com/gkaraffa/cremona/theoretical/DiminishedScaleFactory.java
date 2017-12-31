package com.gkaraffa.cremona.theoretical;

public class DiminishedScaleFactory extends SymmetricScaleFactory {

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
    if ( !(intervalPattern.getText().contains("Diminished") ) ) {
      return false;
    }
    return true;
  }

  public static String firstDiminishedPatternString = "M2,m3,P4,d5,m6,d7,M7,P8";
  public static String secondDiminishedPatternString = "m2,m3,d4,d5,d6,d7,m7,P8";

}
