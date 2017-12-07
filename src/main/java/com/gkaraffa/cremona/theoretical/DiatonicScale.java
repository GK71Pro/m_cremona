package com.gkaraffa.cremona.theoretical;

public class DiatonicScale extends Scale implements Harmonizable, Modal {

  public DiatonicScale(String name, Tone[] tones, ScaleQuality scaleQuality) {
    super(name, tones, scaleQuality);
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
    return getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

  public Modal getMode(int modalOffset) {
    //unimplemented
    throw new java.lang.UnsupportedOperationException();
  }

}
