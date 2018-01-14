package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject implements Iterable<Interval>, Spellable {
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
    String majorChordPatternString = "P1,M3,P5";
    String minorChordPatternString = "P1,m3,P5";
    String diminishedChordPatternString = "P1,m3,d5";
    String augmentedChordPatternString = "P1,M3,A5";
    


    IONIAN_PATTERN = iPF.createIntervalPattern("Ionian", ionianPatternString);
    DORIAN_PATTERN = iPF.createIntervalPattern("Dorian", dorianPatternString);
    PHRYGIAN_PATTERN = iPF.createIntervalPattern("Phrygian", phrygianPatternString);
    LYDIAN_PATTERN = iPF.createIntervalPattern("Lydian", lydianPatternString);
    MIXOLYDIAN_PATTERN = iPF.createIntervalPattern("Mixolydian", mixolydianPatternString);
    AEOLIAN_PATTERN = iPF.createIntervalPattern("Aeolian", aeolianPatternString);
    LOCRIAN_PATTERN = iPF.createIntervalPattern("Locrian", locrianPatternString);
    HARMONIC_MINOR_PATTERN = iPF.createIntervalPattern("Harmonic Minor", harmonicMinorPatternString);
    MELODIC_MINOR_PATTERN = iPF.createIntervalPattern("Melodic Minor", melodicMinorPatternString);
    WHOLE_TONE_PATTERN = iPF.createIntervalPattern("Whole Tone", wholeTonePatternString);
    FIRST_DIMINISHED_PATTERN =
        iPF.createIntervalPattern("First Diminished", firstDiminishedPatternString);
    SECOND_DIMINISHED_PATTERN =
        iPF.createIntervalPattern("Second Diminished", secondDiminishedPatternString);
    PENTATONIC_MAJOR_PATTERN =
        iPF.createIntervalPattern("Pentatonic Major", pentatonicMajorPatternString);
    PENTATONIC_MINOR_PATTERN =
        iPF.createIntervalPattern("Pentatonic Minor", pentatonicMinorPatternString);
    MAJOR_CHORD_PATTERN = 
        iPF.createIntervalPattern("Major", majorChordPatternString);
    MINOR_CHORD_PATTERN = 
        iPF.createIntervalPattern("Minor", minorChordPatternString);
    DIMINISHED_CHORD_PATTERN = 
        iPF.createIntervalPattern("Diminished", diminishedChordPatternString);
    AUGMENTED_CHORD_PATTERN = 
        iPF.createIntervalPattern("Augmented", augmentedChordPatternString);

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
  
  public int getCountByIntervalNumber(IntervalNumber intervalNumber) {
    int count = 0;
    
    for (Interval interval : intervalList) {
      if (interval.getIntervalNumber().equals(intervalNumber)) {
        count++;
      }
    }
    
    return count;
  }

  public Interval getIntervalByLocation(int location) {
    return intervalList.get(location);
  }

  public int getSize() {
    return intervalList.size();
  }
  
  public String getSpellingString() {
    StringBuilder sb = new StringBuilder();
    for(Interval interval: intervalList) {
      sb.append(interval.getAbbrev());
      sb.append(", ");
    }
    
    sb.setLength(sb.length() - 2);
    
    return sb.toString();
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

  public static IntervalPattern IONIAN_PATTERN;
  public static IntervalPattern DORIAN_PATTERN;
  public static IntervalPattern PHRYGIAN_PATTERN;
  public static IntervalPattern LYDIAN_PATTERN;
  public static IntervalPattern MIXOLYDIAN_PATTERN;
  public static IntervalPattern AEOLIAN_PATTERN;
  public static IntervalPattern LOCRIAN_PATTERN;
  public static IntervalPattern HARMONIC_MINOR_PATTERN;
  public static IntervalPattern MELODIC_MINOR_PATTERN;
  public static IntervalPattern WHOLE_TONE_PATTERN;
  public static IntervalPattern FIRST_DIMINISHED_PATTERN;
  public static IntervalPattern SECOND_DIMINISHED_PATTERN;
  public static IntervalPattern PENTATONIC_MAJOR_PATTERN;
  public static IntervalPattern PENTATONIC_MINOR_PATTERN;
  public static IntervalPattern MAJOR_CHORD_PATTERN;
  public static IntervalPattern MINOR_CHORD_PATTERN;
  public static IntervalPattern DIMINISHED_CHORD_PATTERN;
  public static IntervalPattern AUGMENTED_CHORD_PATTERN;
}
