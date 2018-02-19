package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntervalPatternFactory {
  private static IntervalPatternFactory instance = null;
  private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();

  static {
    for (Interval currInterval : Interval.values()) {
      lookup.put(currInterval.getAbbrev(), currInterval);
    }
  }

  private IntervalPatternFactory() {}

  public static synchronized IntervalPatternFactory getInstance() {
    if (instance == null) {
      instance = new IntervalPatternFactory();
    }
    
    return instance;
  }
  
  public IntervalPattern createIntervalPattern(String name, String patternString) {
    String[] intervalArray = patternString.split(",");
    List<Interval> intervalList = new ArrayList<Interval>();

    for (String currentIntervalString : intervalArray) {
      Interval currentIntervalUnit = getIntervalByString(currentIntervalString);
      intervalList.add(currentIntervalUnit);
    }

    return new IntervalPattern(name, intervalList);
  }
  
  public IntervalPattern createIntervalPattern(String name, String[] patternStringArray) {
    List<Interval> intervalList = new ArrayList<Interval>();
    
    for (String currentIntervalString : patternStringArray) {
      Interval currentIntervalUnit = getIntervalByString(currentIntervalString);
      intervalList.add(currentIntervalUnit);
    }

    return new IntervalPattern(name, intervalList);
  }
  
  /*
  public IntervalPattern createIntervalPattern(String name, int[] stepArray) {
    List<Interval> intervalList = new ArrayList<Interval>();
    
    for (int step: stepArray) {
      
    }
  }
  */

  public Interval getIntervalByString(String lookupString) {
    Interval lookupValue = lookup.get(lookupString);

    if (lookupValue == null) {
      throw new IllegalArgumentException("Illegal lookup string.");
    }

    return lookupValue;
  }

  public IntervalPattern createIntervalPattern(List<Interval> patternList) {
    return null;
  }

}
