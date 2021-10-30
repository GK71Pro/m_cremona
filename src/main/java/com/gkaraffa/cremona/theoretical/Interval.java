package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.HashMap;

public enum Interval {
  UNISON(0, IntervalNumber.FIRST, Quality.PERFECT, "Perfect Unison", "P1"),
  DIMINISHED_SECOND(0, IntervalNumber.SECOND, Quality.DIMINISHED, "Diminished Second", "d2"),
  MINOR_SECOND(1, IntervalNumber.SECOND, Quality.MINOR, "Minor Second", "m2"),
  MAJOR_SECOND(2, IntervalNumber.SECOND, Quality.MAJOR, "Major Second", "M2"),
  AUGMENTED_SECOND(3, IntervalNumber.SECOND, Quality.AUGMENTED, "Augmented Second", "A2"),
  DIMINISHED_THIRD(2, IntervalNumber.THIRD, Quality.DIMINISHED, "Diminished Third", "d3"),
  MINOR_THIRD(3, IntervalNumber.THIRD, Quality.MINOR, "Minor Third", "m3"),
  MAJOR_THIRD(4, IntervalNumber.THIRD, Quality.MAJOR, "Major Third", "M3"),
  AUGMENTED_THIRD(5, IntervalNumber.THIRD, Quality.AUGMENTED, "Augmented Third", "A3"),
  DIMINISHED_FOURTH(4, IntervalNumber.FOURTH, Quality.DIMINISHED, "Diminished Fourth", "d4"),
  PERFECT_FOURTH(5, IntervalNumber.FOURTH, Quality.PERFECT, "Perfect Fourth", "P4"),
  AUGMENTED_FOURTH(6, IntervalNumber.FOURTH, Quality.AUGMENTED, "Augmented Fourth", "A4"),
  DIMINISHED_FIFTH(6, IntervalNumber.FIFTH, Quality.DIMINISHED, "Diminished Fifth", "d5"),
  PERFECT_FIFTH(7, IntervalNumber.FIFTH, Quality.PERFECT, "Perfect Fifth", "P5"),
  AUGMENTED_FIFTH(8, IntervalNumber.FIFTH, Quality.AUGMENTED, "Augmented Fifth", "A5"),
  DIMINISHED_SIXTH(7, IntervalNumber.SIXTH, Quality.DIMINISHED, "Diminished Sixth", "d6"),
  MINOR_SIXTH(8, IntervalNumber.SIXTH, Quality.MINOR, "Minor Sixth", "m6"),
  MAJOR_SIXTH(9, IntervalNumber.SIXTH, Quality.MAJOR, "Major Sixth", "M6"),
  AUGMENTED_SIXTH(10, IntervalNumber.SIXTH, Quality.AUGMENTED, "Augmented Sixth", "A6"),
  DIMINISHED_SEVENTH(9, IntervalNumber.SEVENTH, Quality.DIMINISHED, "Diminished Seventh", "d7"),
  MINOR_SEVENTH(10, IntervalNumber.SEVENTH, Quality.MINOR, "Minor Seventh", "m7"),
  MAJOR_SEVENTH(11, IntervalNumber.SEVENTH, Quality.MAJOR, "Major Seventh", "M7"),
  AUGMENTED_SEVENTH(12, IntervalNumber.SEVENTH, Quality.AUGMENTED, "Augmented Seventh", "A7"),
  DIMINISHED_EIGHTH(11, IntervalNumber.EIGHTH, Quality.DIMINISHED, "Diminished Eighth", "d8"),
  PERFECT_EIGHTH(12, IntervalNumber.EIGHTH, Quality.PERFECT, "Perfect Eighth", "P8"),
  DIMINISHED_NINTH(12, IntervalNumber.NINTH, Quality.DIMINISHED, "Diminished Ninth", "d2"),
  MINOR_NINTH(13, IntervalNumber.NINTH, Quality.MINOR, "Minor Ninth", "m9"),
  MAJOR_NINTH(14, IntervalNumber.NINTH, Quality.MAJOR, "Major Ninth", "M9"),
  AUGMENTED_NINTH(15, IntervalNumber.NINTH, Quality.AUGMENTED, "Augmented Ninth", "A9"),
  DIMINISHED_TENTH(14, IntervalNumber.TENTH, Quality.DIMINISHED, "Diminished Tenth", "d10"),
  MINOR_TENTH(15, IntervalNumber.TENTH, Quality.MINOR, "Minor Tenth", "m10"),
  MAJOR_TENTH(16, IntervalNumber.TENTH, Quality.MAJOR, "Major Tenth", "M10"),
  AUGMENTED_TENTH(17, IntervalNumber.TENTH, Quality.AUGMENTED, "Augmented Tenth", "A10"),
  DIMINISHED_ELEVENTH(
      16,
      IntervalNumber.ELEVENTH,
      Quality.DIMINISHED,
      "Diminished Eleventh",
      "d11"),
  PERFECT_ELEVENTH(17, IntervalNumber.ELEVENTH, Quality.PERFECT, "Perfect Eleventh", "P11"),
  AUGMENTED_ELEVENTH(18, IntervalNumber.ELEVENTH, Quality.AUGMENTED, "Augmented Eleventh", "A11"),
  DIMINISHED_TWELFTH(18, IntervalNumber.TWELFTH, Quality.DIMINISHED, "Diminished Twelfth", "d12"),
  PERFECT_TWELFTH(19, IntervalNumber.TWELFTH, Quality.PERFECT, "Perfect Twelfth", "P12"),
  AUGMENTED_TWELFTH(20, IntervalNumber.TWELFTH, Quality.AUGMENTED, "Augmented Twelfth", "A12"),
  DIMINISHED_THIRTEENTH(
      19,
      IntervalNumber.THIRTEENTH,
      Quality.DIMINISHED,
      "Diminished Thirteenth",
      "d13"),
  MINOR_THIRTEENTH(20, IntervalNumber.THIRTEENTH, Quality.MINOR, "Minor Thirteenth", "m13"),
  MAJOR_THIRTEENTH(21, IntervalNumber.THIRTEENTH, Quality.MAJOR, "Major Thirteenth", "M13"),
  AUGMENTED_THIRTEENTH(
      22,
      IntervalNumber.THIRTEENTH,
      Quality.AUGMENTED,
      "Augmented Thirteenth",
      "A13"),
  DIMINISHED_FOURTEENTH(
      21,
      IntervalNumber.FOURTEENTH,
      Quality.DIMINISHED,
      "Diminished Fourteenth",
      "d14"),
  MINOR_FOURTEENTH(22, IntervalNumber.FOURTEENTH, Quality.MINOR, "Minor Fourteenth", "m14"),
  MAJOR_FOURTEENTH(23, IntervalNumber.FOURTEENTH, Quality.MAJOR, "Major Fourteenth", "M14"),
  AUGMENTED_FOURTEENTH(
      24,
      IntervalNumber.FOURTEENTH,
      Quality.AUGMENTED,
      "Augmented Fourteenth",
      "A14");

  private final int halfStepsFromTonic;
  private final IntervalNumber intervalNumber;
  private final Quality intervalQuality;
  private final String text;
  private final String abbrev;
  private final static HashMap<IntervalKey, Interval> intervalKeyToIntervalMap =
      new HashMap<>();
  private final static HashMap<Integer, ArrayList<Interval>> halfStepToIntervalListMap =
      new HashMap<>();

  static {
    for (Interval interval : Interval.values()) {
      intervalKeyToIntervalMap.put(
          interval.new IntervalKey(interval.getHalfStepsFromTonic(), interval.getIntervalNumber()),
          interval);
    }

    for (Interval interval : Interval.values()) {
      if (halfStepToIntervalListMap.containsKey(interval.halfStepsFromTonic)) {
        ArrayList<Interval> currentAL = halfStepToIntervalListMap.get(interval.halfStepsFromTonic);
        currentAL.add(interval);
      }
      else {
        ArrayList<Interval> currentAL = new ArrayList<>();
        currentAL.add(interval);
        halfStepToIntervalListMap.put(interval.halfStepsFromTonic, currentAL);
      }
    }
  }

  Interval(int halfStepsFromTonic, IntervalNumber intervalNumber, Quality intervalQuality,
      String text, String abbrev) {
    this.halfStepsFromTonic = halfStepsFromTonic;
    this.intervalNumber = intervalNumber;
    this.intervalQuality = intervalQuality;
    this.text = text;
    this.abbrev = abbrev;
  }

  public final int getHalfStepsFromTonic() {
    return halfStepsFromTonic;
  }

  public final IntervalNumber getIntervalNumber() {
    return intervalNumber;
  }

  public final Quality getIntervalQuality() {
    return intervalQuality;
  }

  public final String getText() {
    return text;
  }

  public final String getAbbrev() {
    return abbrev;
  }

  @Override
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
      if (iK.hashCode() == this.hashCode()) {
        return true;
      }

      return false;
    }

    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + halfSteps;
      result = 31 * result + ((intervalNumber == null) ? 0 : intervalNumber.hashCode());
      return result;
    }
  }

}
