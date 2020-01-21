package com.gkaraffa.cremona.theoretical;

public enum Quality {
  DIMINISHED("Diminished", "d"),
  MINOR("Minor", "m"),
  PERFECT("Perfect", "P"),
  MAJOR("Major", "M"),
  AUGMENTED("Augmented", "A");

  private final String text;
  private final String abbrev;

  Quality(String text, String abbrev) {
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
