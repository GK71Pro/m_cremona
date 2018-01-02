package com.gkaraffa.cremona.theoretical;

public abstract class SymmetricScale extends Scale implements Harmonizable {

  public SymmetricScale(String name, Tone[] tones, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, tones, scaleQuality, intervalPattern);
  }

}
