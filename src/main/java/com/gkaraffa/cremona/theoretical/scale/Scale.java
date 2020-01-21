package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.ToneGroupObject;

public abstract class Scale extends ToneGroupObject {
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

  @Override
  public ToneCollection getToneCollection() {
    return this.toneCollection;
  }

  @Override
  public boolean equals(Object o) {

    if (o == this) {
      return true;
    }
    if (!(o instanceof Scale)) {
      return false;
    }
    Scale sO = (Scale) o;

    return (sO.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 23 * result + getText().hashCode();
    return result;
  }
}
