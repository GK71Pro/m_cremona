package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiatonicScale extends Scale implements Harmonizable, Modal {

  public DiatonicScale(String name, ToneCollection toneCollection, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleQuality, intervalPattern);
  }

  private int calculateLocation(int segment, int offset) {
    int location = segment + offset;
    int limit = IntervalNumber.EIGHTH.getPosition();

    if (location > limit) {
      location -= limit;
    }

    return location;
  }

  public Tone getToneAtRelativeIntervalNumber(IntervalNumber rootInterval,
      IntervalNumber offsetInterval) {

    return this.getToneCollection()
        .getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

  public Modal getMode(int modalOffset) {
    throw new java.lang.UnsupportedOperationException();
  }
}
