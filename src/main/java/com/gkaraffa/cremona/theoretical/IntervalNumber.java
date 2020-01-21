package com.gkaraffa.cremona.theoretical;

import java.util.HashMap;

public enum IntervalNumber {
  FIRST(0, "First", "1st", "Tonic"),
  SECOND(1, "Second", "2nd", "Supertonic"),
  THIRD(2, "Third", "3rd", "Mediant"),
  FOURTH(3, "Fourth", "4th", "Subdominant"),
  FIFTH(4, "Fifth", "5th", "Dominant"),
  SIXTH(5, "Sixth", "6th", "Submediant"),
  SEVENTH(6, "Seventh", "7th", "Subtonic"),
  EIGHTH(7, "Eighth", "8th", "Tonic"),
  NINTH(8, "Ninth", "9th", ""),
  TENTH(9, "Tenth", "10th", ""),
  ELEVENTH(10, "Eleventh", "11th", ""),
  TWELFTH(11, "Twelfth", "12th", ""),
  THIRTEENTH(12, "Thirteenth", "13th", ""),
  FOURTEENTH(13, "Fourteenth", "14th", ""),
  FIFTEENTH(14, "Fifteenth", "15th", "");

  private int position;
  private String text;
  private String abbrev;
  private String diatonicFunction;
  private final static HashMap<Integer, IntervalNumber> integerToIntervalLookupMap =
      new HashMap<Integer, IntervalNumber>();

  static {
    for (IntervalNumber intervalNumber : IntervalNumber.values()) {
      integerToIntervalLookupMap.put(intervalNumber.position, intervalNumber);
    }
  }

  IntervalNumber(int position, String text, String abbrev, String diatonicFunction) {
    this.position = position;
    this.text = text;
    this.abbrev = abbrev;
    this.diatonicFunction = diatonicFunction;
  }

  public final int getPosition() {
    return this.position;
  }

  public final String getText() {
    return this.text;
  }

  public final String getAbbrev() {
    return this.abbrev;
  }

  public final String getDiatonicFunction() {
    return this.diatonicFunction;
  }

  @Override
  public final String toString() {
    return this.text;
  }

  public static final IntervalNumber integerToIntervalNumber(int inputInteger) {
    return integerToIntervalLookupMap.get(inputInteger);
  }

}
