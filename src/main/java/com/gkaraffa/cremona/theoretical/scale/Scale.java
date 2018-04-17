package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.TheoreticalObject;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class Scale extends TheoreticalObject {
  private Tone key;
  private ScaleNomenclature scaleNomenclature;
  private IntervalPattern intervalPattern;
  private ToneCollection toneCollection;

  public Scale(String name, ToneCollection toneCollection, ScaleNomenclature scaleNomenclature,
      IntervalPattern intervalPattern) {
    super(name);
    this.toneCollection = toneCollection;
    this.scaleNomenclature = scaleNomenclature;
    this.key = toneCollection.getTone(0);
    this.intervalPattern = intervalPattern;
  }

  public Tone getKey() {
    return this.key;
  }

  public ScaleNomenclature getScaleNomenclature() {
    return scaleNomenclature;
  }

  public IntervalPattern getIntervalPattern() {
    return this.intervalPattern;
  }

  public ToneCollection getToneCollection() {
    return this.toneCollection;
  }
}
