package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class WholeToneScaleFactory extends ScaleFactory {
  public WholeToneScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!(validateInputPattern(intervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return new WholeToneScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleQuality, intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    return ScaleQuality.WHOLE_TONE;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (!(intervalPattern.getText().contains("Whole Tone"))) {
      return false;
    }
    return true;
  }
}
