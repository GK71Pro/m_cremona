package com.gkaraffa.cremona.theoretical.chord;

public enum ChordQuality {
  DIMINISHED("Diminished", "d"),
  MINOR("Minor", "m"),
  PERFECT("Perfect", "P"),
  MAJOR("Major", "M"),
  AUGMENTED("Augmented", "A"),
  SUSPENDED_FOURTH("Suspended Fourth", "sus4"),
  MAJOR_SEVENTH("Major Seventh", "M7"),
  DOMINANT_SEVENTH("Dominant Seventh", "7"),
  MINOR_SEVENTH("Minor Seventh", "m7"),
  MINOR_MAJOR_SEVENTH("Minor-Major Seventh", "mM7"),
  HALF_DIMINISHED_SEVENTH("Half-Diminished Seventh", "hd7"),
  DIMINISHED_SEVENTH("Diminished Seventh", "d7"),
  AUGMENTED_MAJOR_SEVENTH("Augmented Major 7th", "AM7");

  private final String text;
  private final String abbrev;

  ChordQuality(String text, String abbrev) {
    this.text = text;
    this.abbrev = abbrev;
  }

  public String getText() {
    return this.text;
  }

  public String getAbbrev() {
    return this.abbrev;
  }

  public final String toString() {
    return this.text;
  }

}
