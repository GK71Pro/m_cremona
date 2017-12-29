package com.gkaraffa.cremona.theoretical;

public enum HarmonicPreference {
  TERTIARY("Tertiary", 2),
  QUARTAL("Quartal", 3),
  QUINTAL("Quintal", 4);

  private final String text;
  private final int offset;

  HarmonicPreference(String text, int offset) {
    this.text = text;
    this.offset = offset;
  }

  public String getText() {
    return this.text;
  }

  public int getOffset() {
    return this.offset;
  }

  public final String toString() {
    return this.text;
  }
}
