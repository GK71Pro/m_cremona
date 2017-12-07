package com.gkaraffa.cremona.theoretical;

public enum ScaleQuality {
  DIMINISHED("diminished", "d"),
  MINOR("minor", "m"),
  PERFECT("perfect", "P"),
  MAJOR("major", "M"),
  AUGMENTED("augmented", "A"),
  WHOLE_TONE("whole tone", "W"),
  UNDEFINED("undefined", "U");

  private final String text;
  private final String abbrev;

  ScaleQuality(String text, String abbrev) {
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
