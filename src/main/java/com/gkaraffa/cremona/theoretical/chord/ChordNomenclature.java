package com.gkaraffa.cremona.theoretical.chord;

public enum ChordNomenclature {
  DIMINISHED("Diminished", "d"),
  MINOR("Minor", "m"),
  MAJOR("Major", "M"),
  AUGMENTED("Augmented", "+"),
  SUSPENDED_FOURTH("Suspended Fourth", "sus4"),
  MAJOR_SEVENTH("Major Seventh", "^7"),
  DOMINANT_SEVENTH("Dominant Seventh", "7"),
  MINOR_SEVENTH("Minor Seventh", "-7"),
  MINOR_MAJOR_SEVENTH("Minor-Major Seventh", "-^7"),
  HALF_DIMINISHED_SEVENTH("Half-Diminished Seventh", "-7b5"),
  DIMINISHED_SEVENTH("Diminished Seventh", "o7"),
  AUGMENTED_MAJOR_SEVENTH("Augmented Major 7th", "+^7");

  private final String longName;
  private final String shortName;

  ChordNomenclature(String longName, String shortName) {
    this.longName = longName;
    this.shortName = shortName;
  }

  public String getLongName() {
    return this.longName;
  }

  public String getShortName() {
    return this.shortName;
  }

  @Override
  public final String toString() {
    return this.longName;
  }

}
