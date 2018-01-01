package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject implements Iterable<Interval> {
  private List<Interval> intervalList;
  private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();

  static {
    for (Interval currInterval : Interval.values()) {
      lookup.put(currInterval.getAbbrev(), currInterval);
    }

    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();
    
    String ionianPatternString = "M2,M3,P4,P5,M6,M7,P8";
    String dorianPatternString = "M2,m3,P4,P5,M6,m7,P8";
    String phrygianPatternString = "m2,m3,P4,P5,m6,m7,P8";
    String lydianPatternString = "M2,M3,A4,P5,M6,M7,P8";
    String mixolydianPatternString = "M2,M3,P4,P5,M6,m7,P8";
    String aeolianPatternString = "M2,m3,P4,P5,m6,m7,P8";
    String locrianPatternString = "m2,m3,P4,d5,m6,m7,P8";
    String harmonicMinorPatternString = "M2,m3,P4,P5,m6,M7,P8";
    String melodicMinorPatternString = "M2,m3,P4,P5,M6,M7,P8";
    String wholeTonePatternString = "M2,M3,A4,A5,A6,P8";
    String firstDiminishedPatternString = "M2,m3,P4,d5,m6,d7,M7,P8";
    String secondDiminishedPatternString = "m2,m3,d4,d5,d6,d7,m7,P8";
    String pentatonicMajorPatternString = "M2,M3,P5,M6,P8";
    String pentatonicMinorPatternString = "m3,P4,P5,m7,P8";


    ionianPattern = iPF.createIntervalPattern("Ionian", ionianPatternString);
    dorianPattern = iPF.createIntervalPattern("Dorian", dorianPatternString);
    phrygianPattern = iPF.createIntervalPattern("Phrygian", phrygianPatternString);
    lydianPattern = iPF.createIntervalPattern("Lydian", lydianPatternString);
    mixolydianPattern = iPF.createIntervalPattern("Mixolydian", mixolydianPatternString);
    aeolianPattern = iPF.createIntervalPattern("Aeolian", aeolianPatternString);
    locrianPattern = iPF.createIntervalPattern("Locrian", locrianPatternString);
    harmonicMinorPattern = iPF.createIntervalPattern("Harmonic Minor", harmonicMinorPatternString);
    melodicMinorPattern = iPF.createIntervalPattern("Melodic Minor", melodicMinorPatternString);
    wholeTonePattern = iPF.createIntervalPattern("Whole Tone", wholeTonePatternString);
    firstDiminishedPattern =
        iPF.createIntervalPattern("First Diminished", firstDiminishedPatternString);
    secondDiminishedPattern =
        iPF.createIntervalPattern("Second Diminished", secondDiminishedPatternString);
    pentatonicMajorPattern =
        iPF.createIntervalPattern("Pentatonic Major", pentatonicMajorPatternString);
    pentatonicMinorPattern =
        iPF.createIntervalPattern("Pentatonic Minor", pentatonicMinorPatternString);
  }

  public IntervalPattern(String name, List<Interval> intervalList) {
    super(name);

    this.intervalList = intervalList;
  }

  public Interval getIntervalByIntervalNumber(IntervalNumber intervalNumber) {
    for (Interval interval : intervalList) {
      if (interval.getIntervalNumber().equals(intervalNumber)) {
        return interval;
      }
    }

    return null;
  }

  public Interval getIntervalByLocation(int location) {
    return intervalList.get(location);
  }

  public int getSize() {
    return intervalList.size();
  }

  public Iterator<Interval> iterator() {
    return new IntervalIterator();
  }

  class IntervalIterator implements Iterator<Interval> {
    private int index = 0;

    public boolean hasNext() {
      return index < getSize();
    }

    public Interval next() {
      return getIntervalByLocation(index++);
    }

    public void remove() {
      throw new UnsupportedOperationException("not supported yet");
    }
  }

  public static IntervalPattern ionianPattern;
  public static IntervalPattern dorianPattern;
  public static IntervalPattern phrygianPattern;
  public static IntervalPattern lydianPattern;
  public static IntervalPattern mixolydianPattern;
  public static IntervalPattern aeolianPattern;
  public static IntervalPattern locrianPattern;
  public static IntervalPattern harmonicMinorPattern;
  public static IntervalPattern melodicMinorPattern;
  public static IntervalPattern wholeTonePattern;
  public static IntervalPattern firstDiminishedPattern;
  public static IntervalPattern secondDiminishedPattern;
  public static IntervalPattern pentatonicMajorPattern;
  public static IntervalPattern pentatonicMinorPattern;
}
