package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.HashMap;

public enum Interval {
  UNISON(0, IntervalNumber.FIRST, IntervalQuality.PERFECT, "Perfect Unison", "P1"),
  DIMINISHED_SECOND(
      0,
      IntervalNumber.SECOND,
      IntervalQuality.DIMINISHED,
      "Diminished Second",
      "d2"),
  MINOR_SECOND(1, IntervalNumber.SECOND, IntervalQuality.MINOR, "Minor Second", "m2"),
  MAJOR_SECOND(2, IntervalNumber.SECOND, IntervalQuality.MAJOR, "Major Second", "M2"),
  AUGMENTED_SECOND(3, IntervalNumber.SECOND, IntervalQuality.AUGMENTED, "Augmented Second", "A2"),
  DIMINISHED_THIRD(2, IntervalNumber.THIRD, IntervalQuality.DIMINISHED, "Diminished Third", "d3"),
  MINOR_THIRD(3, IntervalNumber.THIRD, IntervalQuality.MINOR, "Minor Third", "m3"),
  MAJOR_THIRD(4, IntervalNumber.THIRD, IntervalQuality.MAJOR, "Major Third", "M3"),
  AUGMENTED_THIRD(5, IntervalNumber.THIRD, IntervalQuality.AUGMENTED, "Augmented Third", "A3"),
  DIMINISHED_FOURTH(
      4,
      IntervalNumber.FOURTH,
      IntervalQuality.DIMINISHED,
      "Diminished Fourth",
      "d4"),
  PERFECT_FOURTH(5, IntervalNumber.FOURTH, IntervalQuality.PERFECT, "Perfect Fourth", "P4"),
  AUGMENTED_FOURTH(6, IntervalNumber.FOURTH, IntervalQuality.AUGMENTED, "Augmented Fourth", "A4"),
  DIMINISHED_FIFTH(6, IntervalNumber.FIFTH, IntervalQuality.DIMINISHED, "Diminished Fifth", "d5"),
  PERFECT_FIFTH(7, IntervalNumber.FIFTH, IntervalQuality.PERFECT, "Perfect Fifth", "P5"),
  AUGMENTED_FIFTH(8, IntervalNumber.FIFTH, IntervalQuality.AUGMENTED, "Augmented Fifth", "A5"),
  DIMINISHED_SIXTH(7, IntervalNumber.SIXTH, IntervalQuality.DIMINISHED, "Diminished Sixth", "d6"),
  MINOR_SIXTH(8, IntervalNumber.SIXTH, IntervalQuality.MINOR, "Minor Sixth", "m6"),
  MAJOR_SIXTH(9, IntervalNumber.SIXTH, IntervalQuality.MAJOR, "Major Sixth", "M6"),
  AUGMENTED_SIXTH(10, IntervalNumber.SIXTH, IntervalQuality.AUGMENTED, "Augmented Sixth", "A6"),
  DIMINISHED_SEVENTH(
      9,
      IntervalNumber.SEVENTH,
      IntervalQuality.DIMINISHED,
      "Diminished Seventh",
      "d7"),
  MINOR_SEVENTH(10, IntervalNumber.SEVENTH, IntervalQuality.MINOR, "Minor Seventh", "m7"),
  MAJOR_SEVENTH(11, IntervalNumber.SEVENTH, IntervalQuality.MAJOR, "Major Seventh", "M7"),
  AUGMENTED_SEVENTH(
      12,
      IntervalNumber.SEVENTH,
      IntervalQuality.AUGMENTED,
      "Augmented Seventh",
      "A7"),
  DIMINISHED_EIGHTH(
      11,
      IntervalNumber.EIGHTH,
      IntervalQuality.DIMINISHED,
      "Diminished Eighth",
      "d8"),
  PERFECT_EIGHTH(12, IntervalNumber.EIGHTH, IntervalQuality.PERFECT, "Perfect Eighth", "P8"),
  DIMINISHED_NINTH(12, IntervalNumber.NINTH, IntervalQuality.DIMINISHED, "Diminished Ninth", "d2"),
  MINOR_NINTH(13, IntervalNumber.NINTH, IntervalQuality.MINOR, "Minor Ninth", "m9"),
  MAJOR_NINTH(14, IntervalNumber.NINTH, IntervalQuality.MAJOR, "Major Ninth", "M9"),
  AUGMENTED_NINTH(15, IntervalNumber.NINTH, IntervalQuality.AUGMENTED, "Augmented Ninth", "A9"),
  DIMINISHED_TENTH(14, IntervalNumber.TENTH, IntervalQuality.DIMINISHED, "Diminished Tenth", "d10"),
  MINOR_TENTH(15, IntervalNumber.TENTH, IntervalQuality.MINOR, "Minor Tenth", "m10"),
  MAJOR_TENTH(16, IntervalNumber.TENTH, IntervalQuality.MAJOR, "Major Tenth", "M10"),
  AUGMENTED_TENTH(17, IntervalNumber.TENTH, IntervalQuality.AUGMENTED, "Augmented Tenth", "A10"),
  DIMINISHED_ELEVENTH(
      16,
      IntervalNumber.ELEVENTH,
      IntervalQuality.DIMINISHED,
      "Diminished Eleventh",
      "d11"),
  PERFECT_ELEVENTH(17, IntervalNumber.ELEVENTH, IntervalQuality.PERFECT, "Perfect Eleventh", "P11"),
  AUGMENTED_ELEVENTH(
      18,
      IntervalNumber.ELEVENTH,
      IntervalQuality.AUGMENTED,
      "Augmented Eleventh",
      "A11"),
  DIMINISHED_TWELFTH(
      18,
      IntervalNumber.TWELFTH,
      IntervalQuality.DIMINISHED,
      "Diminished Twelfth",
      "d12"),
  PERFECT_TWELFTH(19, IntervalNumber.TWELFTH, IntervalQuality.PERFECT, "Perfect Twelfth", "P12"),
  AUGMENTED_TWELFTH(
      20,
      IntervalNumber.TWELFTH,
      IntervalQuality.AUGMENTED,
      "Augmented Twelfth",
      "A12"),
  DIMINISHED_THIRTEENTH(
      19,
      IntervalNumber.THIRTEENTH,
      IntervalQuality.DIMINISHED,
      "Diminished Thirteenth",
      "d13"),
  MINOR_THIRTEENTH(20, IntervalNumber.THIRTEENTH, IntervalQuality.MINOR, "Minor Thirteenth", "m13"),
  MAJOR_THIRTEENTH(21, IntervalNumber.THIRTEENTH, IntervalQuality.MAJOR, "Major Thirteenth", "M13"),
  AUGMENTED_THIRTEENTH(
      22,
      IntervalNumber.THIRTEENTH,
      IntervalQuality.AUGMENTED,
      "Augmented Thirteenth",
      "A13"),
  DIMINISHED_FOURTEENTH(
      21,
      IntervalNumber.FOURTEENTH,
      IntervalQuality.DIMINISHED,
      "Diminished Fourteenth",
      "d14"),
  MINOR_FOURTEENTH(22, IntervalNumber.FOURTEENTH, IntervalQuality.MINOR, "Minor Fourteenth", "m14"),
  MAJOR_FOURTEENTH(23, IntervalNumber.FOURTEENTH, IntervalQuality.MAJOR, "Major Fourteenth", "M14"),
  AUGMENTED_FOURTEENTH(
      24,
      IntervalNumber.FOURTEENTH,
      IntervalQuality.AUGMENTED,
      "Augmented Fourteenth",
      "A14");

  private final int halfSteps;
  private final IntervalNumber intervalNumber;
  private final IntervalQuality intervalQuality;
  private final String text;
  private final String abbrev;
  private final static HashMap<IntervalKey, Interval> intervalKeyToIntervalMap =
      new HashMap<IntervalKey, Interval>();
  private final static HashMap<Integer, ArrayList<Interval>> halfStepToIntervalListMap =
      new HashMap<Integer, ArrayList<Interval>>();

  static {
    for (Interval interval : Interval.values()) {
      intervalKeyToIntervalMap.put(
          interval.new IntervalKey(interval.getHalfSteps(), interval.getIntervalNumber()),
          interval);
    }

    for (Interval interval : Interval.values()) {
      if (halfStepToIntervalListMap.containsKey(interval.halfSteps)) {
        ArrayList<Interval> currentAL = halfStepToIntervalListMap.get(interval.halfSteps);
        currentAL.add(interval);
      }
      else {
        ArrayList<Interval> currentAL = new ArrayList<Interval>();
        currentAL.add(interval);
        halfStepToIntervalListMap.put(interval.halfSteps, currentAL);
      }
    }
  }

  Interval(int halfSteps, IntervalNumber intervalNumber, IntervalQuality intervalQuality,
      String text, String abbrev) {
    this.halfSteps = halfSteps;
    this.intervalNumber = intervalNumber;
    this.intervalQuality = intervalQuality;
    this.text = text;
    this.abbrev = abbrev;
  }

  public final int getHalfSteps() {
    return halfSteps;
  }

  public final IntervalNumber getIntervalNumber() {
    return intervalNumber;
  }

  public final IntervalQuality getIntervalQuality() {
    return intervalQuality;
  }

  public final String getText() {
    return text;
  }

  public final String getAbbrev() {
    return abbrev;
  }

  public final String toString() {
    return text;
  }

  public static final Interval halfStepsAndIntervalNumberToInterval(int halfSteps,
      IntervalNumber intervalNumber) {
    Interval output = null;
    IntervalKey iK = Interval.UNISON.new IntervalKey(halfSteps, intervalNumber);

    output = intervalKeyToIntervalMap.get(iK);

    return output;
  }

  public static final ArrayList<Interval> halfStepsToIntervalList(int halfSteps) {
    ArrayList<Interval> output = null;

    output = halfStepToIntervalListMap.get(halfSteps);

    return output;
  }

  public class IntervalKey {
    public int halfSteps;
    public IntervalNumber intervalNumber;

    IntervalKey(int halfSteps, IntervalNumber intervalNumber) {
      this.halfSteps = halfSteps;
      this.intervalNumber = intervalNumber;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof IntervalKey)) {
        return false;
      }

      IntervalKey iK = (IntervalKey) o;
      if ((iK.halfSteps == this.halfSteps) && (iK.intervalNumber == this.intervalNumber)) {
        return true;
      }

      return false;
    }

    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + halfSteps;
      result = 31 * result + intervalNumber.hashCode();
      return result;
    }
  }

}
