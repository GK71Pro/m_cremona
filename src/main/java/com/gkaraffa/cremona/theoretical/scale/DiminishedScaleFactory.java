package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiminishedScaleFactory extends ScaleFactory {
  public DiminishedScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!(validateInputPattern(intervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }

    ScaleQuality scaleQuality = this.evaluateScaleQuality(intervalPattern);
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return new DiminishedScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleQuality, intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    return ScaleQuality.DIMINISHED;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (!(intervalPattern.getText().contains("Diminished"))) {
      return false;
    }
    return true;
  }
}
