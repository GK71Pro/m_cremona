package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Spellable;
import com.gkaraffa.cremona.theoretical.TheoreticalObject;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class Scale extends TheoreticalObject implements Spellable {
  private Tone key;
  private ScaleQuality scaleQuality;
  private IntervalPattern intervalPattern;
  private ToneCollection toneCollection;

  public Scale(String name, ToneCollection toneCollection, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name);
    this.toneCollection = toneCollection;
    this.scaleQuality = scaleQuality;
    this.key = toneCollection.getTone(0);
    this.intervalPattern = intervalPattern;
  }

  public Tone getKey() {
    return this.key;
  }

  public ScaleQuality getScaleQuality() {
    return scaleQuality;
  }

  public IntervalPattern getIntervalPattern() {
    return this.intervalPattern;
  }

  public ToneCollection getToneCollection() {
    return this.toneCollection;
  }

  public String getSpellingString() {
    String baseString = this.toneCollection.getSpellingString();
    return (baseString + ", (" + this.key + ")");
  }
}
