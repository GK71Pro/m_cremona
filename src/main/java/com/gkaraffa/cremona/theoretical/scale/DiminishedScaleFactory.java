package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiminishedScaleFactory extends ScaleFactory {
  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    FIRST_DIMINISHED_PATTERN =
        iPF.createIntervalPattern("First Diminished", "P1,M2,m3,P4,d5,m6,d7,M7");
    SECOND_DIMINISHED_PATTERN =
        iPF.createIntervalPattern("Second Diminished", "P1,m2,m3,d4,d5,d6,d7,m7");
  }

  public DiminishedScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!(validateInputPattern(intervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }

    ScaleQuality scaleQuality = ScaleQuality.DIMINISHED;
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return new DiminishedScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleQuality, intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    return null;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (!(intervalPattern.getText().contains("Diminished"))) {
      return false;
    }
    return true;
  }

  public static IntervalPattern FIRST_DIMINISHED_PATTERN;
  public static IntervalPattern SECOND_DIMINISHED_PATTERN;
}
