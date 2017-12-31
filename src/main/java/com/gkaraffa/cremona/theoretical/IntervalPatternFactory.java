package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntervalPatternFactory {
  private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();

  static {
    for (Interval currInterval : Interval.values()) {
      lookup.put(currInterval.getAbbrev(), currInterval);
    }
  }

  public IntervalPatternFactory() {}

  public static IntervalPattern createIntervalPattern(String name, String patternString) {
    String[] intervalArray = patternString.split(",");
    List<Interval> intervalList = new ArrayList<Interval>();

    for (String currentIntervalString : intervalArray) {
      Interval currentIntervalUnit = getIntervalByString(currentIntervalString);
      intervalList.add(currentIntervalUnit);
    }

    return new IntervalPattern(name, intervalList);
  }

  public static Interval getIntervalByString(String lookupString) {
    Interval lookupValue = lookup.get(lookupString);

    if (lookupValue == null) {
      throw new IllegalArgumentException("Illegal lookup string.");
    }

    return lookupValue;
  }

  public static IntervalPattern createIntervalPattern(List<Interval> patternList) {
    return null;
  }

}
