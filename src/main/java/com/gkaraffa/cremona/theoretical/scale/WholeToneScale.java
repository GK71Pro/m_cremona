package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

@ScaleType
public class WholeToneScale extends SymmetricScale {
  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    WHOLE_TONE_PATTERN = iPF.createIntervalPattern("Whole Tone", "P1,M2,M3,A4,A5,A6");
  }

  public WholeToneScale(String name, ToneCollection toneCollection,
      ScaleNomenclature scaleNomenclature, IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleNomenclature, intervalPattern);
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
    return this.getToneCollection()
        .getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof WholeToneScale)) {
      return false;
    }
    WholeToneScale wTSO = (WholeToneScale) o;

    return (wTSO.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 41;
    result = 43 * result + getLongName().hashCode();
    return result;
  }

  public static IntervalPattern WHOLE_TONE_PATTERN;
}
