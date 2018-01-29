package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiatonicScale extends HarmonizableScale implements Modal {

  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    HARMONIC_MINOR_PATTERN = iPF.createIntervalPattern("Harmonic Minor", "P1,M2,m3,P4,P5,m6,M7");
    MELODIC_MINOR_PATTERN = iPF.createIntervalPattern("Melodic Minor", "P1,M2,m3,P4,P5,M6,M7");
    IONIAN_PATTERN = iPF.createIntervalPattern("Ionian", "P1,M2,M3,P4,P5,M6,M7");
    DORIAN_PATTERN = iPF.createIntervalPattern("Dorian", "P1,M2,m3,P4,P5,M6,m7");
    PHRYGIAN_PATTERN = iPF.createIntervalPattern("Phrygian", "P1,m2,m3,P4,P5,m6,m7");
    LYDIAN_PATTERN = iPF.createIntervalPattern("Lydian", "P1,M2,M3,A4,P5,M6,M7");
    MIXOLYDIAN_PATTERN = iPF.createIntervalPattern("Mixolydian", "P1,M2,M3,P4,P5,M6,m7");
    AEOLIAN_PATTERN = iPF.createIntervalPattern("Aeolian", "P1,M2,m3,P4,P5,m6,m7");
    LOCRIAN_PATTERN = iPF.createIntervalPattern("Locrian", "P1,m2,m3,P4,d5,m6,m7");
  }

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

  public static IntervalPattern IONIAN_PATTERN;
  public static IntervalPattern DORIAN_PATTERN;
  public static IntervalPattern PHRYGIAN_PATTERN;
  public static IntervalPattern LYDIAN_PATTERN;
  public static IntervalPattern MIXOLYDIAN_PATTERN;
  public static IntervalPattern AEOLIAN_PATTERN;
  public static IntervalPattern LOCRIAN_PATTERN;
  public static IntervalPattern HARMONIC_MINOR_PATTERN;
  public static IntervalPattern MELODIC_MINOR_PATTERN;
}
