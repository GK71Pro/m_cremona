package com.gkaraffa.cremona.theoretical;

public class ChordIntervalPattern extends IntervalPattern {

  public ChordIntervalPattern(String name, String inPatternString) throws IllegalArgumentException {
    super(name, inPatternString);
  }

  public static ChordIntervalPattern majorPattern = new ChordIntervalPattern("Major", "M3,P5");
  public static ChordIntervalPattern minorPattern = new ChordIntervalPattern("Minor", "m3,P5");
  public static ChordIntervalPattern diminishedPattern = new ChordIntervalPattern("Minor", "m3,d5");
  public static ChordIntervalPattern augmentedPattern =
      new ChordIntervalPattern("Augmented", "M3,A5");
  public static ChordIntervalPattern suspendedFourthPattern =
      new ChordIntervalPattern("Suspended 4th", "P4,P5");
}
