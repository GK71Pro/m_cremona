package com.gkaraffa.cremona.theoretical.chord;

public enum ChordNomenclature {
  DIMINISHED("Diminished", "d"),
  MINOR("Minor", "m"),
  MAJOR("Major", "M"),
  AUGMENTED("Augmented", "A"),
  SUSPENDED_FOURTH("Suspended Fourth", "sus4"),
  MAJOR_SEVENTH("Major Seventh", "MA7"),
  DOMINANT_SEVENTH("Dominant Seventh", "7"),
  MINOR_SEVENTH("Minor Seventh", "-7"),
  MINOR_MAJOR_SEVENTH("Minor-Major Seventh", "-MA7"),
  HALF_DIMINISHED_SEVENTH("Half-Diminished Seventh", "-7b5"),
  DIMINISHED_SEVENTH("Diminished Seventh", "o7"),
  AUGMENTED_MAJOR_SEVENTH("Augmented Major 7th", "AM7");

  private final String text;
  private final String abbrev;

  ChordNomenclature(String text, String abbrev) {
    this.text = text;
    this.abbrev = abbrev;
  }

  public String getText() {
    return this.text;
  }

  public String getAbbrev() {
    return this.abbrev;
  }

  @Override
  public final String toString() {
    return this.text;
  }

}
