package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class HarmonizableScale extends Scale {

  protected HarmonizableScale(String name, ToneCollection toneCollection,
      ScaleNomenclature scaleNomenclature, IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleNomenclature, intervalPattern);
  }
}
