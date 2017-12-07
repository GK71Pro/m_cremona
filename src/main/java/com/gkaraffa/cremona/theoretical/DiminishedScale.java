package com.gkaraffa.cremona.theoretical;

public class DiminishedScale extends SymmetricScale {

  public DiminishedScale(String name, Tone[] tones, ScaleQuality scaleQuality) {
    super(name, tones, scaleQuality);
    // TODO Auto-generated constructor stub
  }

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
    return getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

}
