package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class Scale extends ToneCollection {
  private ScaleQuality scaleQuality;
  private Tone key;
  private IntervalPattern intervalPattern;

  public Scale(String name, Tone[] tones, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, tones);
    this.scaleQuality = scaleQuality;
    this.key = tones[0];
    this.intervalPattern = intervalPattern;
  }

  public ScaleQuality getScaleQuality() {
    return scaleQuality;
  }

  public Tone getKey() {
    return this.key;
  }

  public IntervalPattern getIntervalPattern() {
    return intervalPattern;
  }

  @Override
  public String getSpellingString() {
    String baseString = super.getSpellingString();
    return (baseString + ", (" + this.key + ")");
  }

}
