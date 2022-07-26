package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.ToneCollection;

@ScaleType
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
    LYDIAN_DOMINANT_PATTERN = iPF.createIntervalPattern("Lydian Dominant", "P1,M2,M3,A4,P5,M6,m7");
  }

  public DiatonicScale(String name, ToneCollection toneCollection,
      ScaleNomenclature scaleNomenclature, IntervalPattern intervalPattern) {
    super(name, toneCollection, scaleNomenclature, intervalPattern);
  }

  @Override
  public Modal getModeByNumber(int modalOffset) {
    throw new java.lang.UnsupportedOperationException();
  }

  @Override
  public Modal getModeByName(String modeName) {
    throw new java.lang.UnsupportedOperationException();
  }

  @Override
  protected ScaleFactory getScaleFactory() {
    return new DiatonicScaleFactory();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DiatonicScale)) {
      return false;
    }
    Scale dSO = (Scale) o;

    return (dSO.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 23;
    result = 27 * result + getLongName().hashCode();
    return result;
  }


  public static final IntervalPattern IONIAN_PATTERN;
  public static final IntervalPattern DORIAN_PATTERN;
  public static final IntervalPattern PHRYGIAN_PATTERN;
  public static final IntervalPattern LYDIAN_PATTERN;
  public static final IntervalPattern MIXOLYDIAN_PATTERN;
  public static final IntervalPattern AEOLIAN_PATTERN;
  public static final IntervalPattern LOCRIAN_PATTERN;
  public static final IntervalPattern HARMONIC_MINOR_PATTERN;
  public static final IntervalPattern MELODIC_MINOR_PATTERN;
  public static final IntervalPattern LYDIAN_DOMINANT_PATTERN;
}
