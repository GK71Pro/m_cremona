package com.gkaraffa.cremona.theoretical.scale;

public enum ScaleNomenclature {
  DIMINISHED("Diminished", "d"),
  MINOR("Minor", "m"),
  PERFECT("Perfect", "P"),
  MAJOR("Major", "M"),
  AUGMENTED("Augmented", "A"),
  WHOLE_TONE("Whole Tone", "W"),
  UNDEFINED("Undefined", "U");

  private final String text;
  private final String abbrev;

  ScaleNomenclature(String text, String abbrev) {
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
