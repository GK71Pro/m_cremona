package com.gkaraffa.cremona.theoretical;

public class DiminishedScaleFactory extends SymmetricScaleFactory {

  public DiminishedScaleFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Scale createScale(ScalarIntervalPattern scalarIntervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!(validateInputPattern(scalarIntervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }
    
    ScaleQuality scaleQuality = ScaleQuality.DIMINISHED;
    Tone tones[] = this.createToneArray(scalarIntervalPattern, key);

    return new DiminishedScale(key.getText() + " " + scalarIntervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(ScalarIntervalPattern scaleIntervalPattern) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected boolean validateInputPattern(ScalarIntervalPattern scaleIntervalPattern) {
    // TODO Auto-generated method stub
    if ( !(scaleIntervalPattern.getText().contains("Diminished") ) ) {
      return false;
    }
    return true;
  }

}
