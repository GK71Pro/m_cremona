package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

@ScaleType
public class DiminishedScale extends SymmetricScale {
  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    FIRST_DIMINISHED_PATTERN =
        iPF.createIntervalPattern("First Diminished", "P1,M2,m3,P4,d5,m6,d7,M7");
    SECOND_DIMINISHED_PATTERN =
        iPF.createIntervalPattern("Second Diminished", "P1,m2,m3,d4,d5,d6,d7,m7");
  }

  public DiminishedScale(String name, ToneCollection toneCollection,
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
    if (!(o instanceof DiminishedScale)) {
      return false;
    }
    DiminishedScale dSO = (DiminishedScale) o;

    return (dSO.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 31;
    result = 37 * result + getLongName().hashCode();
    return result;
  }

  public static IntervalPattern FIRST_DIMINISHED_PATTERN;
  public static IntervalPattern SECOND_DIMINISHED_PATTERN;
}
