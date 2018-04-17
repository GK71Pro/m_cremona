package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class PentatonicScale extends Scale {

  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    PENTATONIC_MAJOR_PATTERN = iPF.createIntervalPattern("Pentatonic Major", "P1,M2,M3,P5,M6,P8");
    PENTATONIC_MINOR_PATTERN = iPF.createIntervalPattern("Pentatonic Minor", "P1,m3,P4,P5,m7,P8");
  }

  public PentatonicScale(String name, ToneCollection toneCollection, ScaleNomenclature scaleNomenclature,
      IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleNomenclature, intervalPattern);
  }

  public static IntervalPattern PENTATONIC_MAJOR_PATTERN;
  public static IntervalPattern PENTATONIC_MINOR_PATTERN;
}
