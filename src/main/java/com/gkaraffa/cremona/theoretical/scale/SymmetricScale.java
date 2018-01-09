package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class SymmetricScale extends Scale implements Harmonizable {

  public SymmetricScale(String name, ToneCollection toneCollection, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleQuality, intervalPattern);
  }
}
