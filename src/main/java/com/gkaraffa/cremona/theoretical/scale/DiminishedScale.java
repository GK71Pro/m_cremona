package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiminishedScale extends SymmetricScale {

  public DiminishedScale(String name, ToneCollection toneCollection, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleQuality, intervalPattern);
  }

  /*
  public DiminishedScale(String name, Tone[] tones, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, tones, scaleQuality, intervalPattern);
  }
  */

  private int calculateLocation(int segment, int offset) {
    int location = segment + offset;
    int limit = IntervalNumber.NINTH.getPosition();

    if (location > limit) {
      location -= limit;
    }

    return location;
  }

  public Tone getToneAtRelativeIntervalNumber(IntervalNumber rootInterval,
      IntervalNumber offsetInterval) {
    // return getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
    return this.getToneCollection()
        .getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

}
