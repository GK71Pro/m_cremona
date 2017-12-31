package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject implements Iterable<Interval> {
  //private List<Interval> intervalList = new ArrayList<Interval>();
  private List<Interval> intervalList;
  private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();

  static {
    for (Interval currInterval : Interval.values()) {
      lookup.put(currInterval.getAbbrev(), currInterval);
    }
  }

  /*
  public IntervalPattern(String name, String inPatternString) throws IllegalArgumentException {
    super(name);

    String[] intervalArray = inPatternString.split(",");
    for (String currentIntervalString : intervalArray) {
      Interval currentIntervalUnit = lookup.get(currentIntervalString);
      if (currentIntervalUnit == null) {
        throw new IllegalArgumentException("Illegal pattern string.");
      }

      intervalList.add(currentIntervalUnit);
    }
  }
  */
  
  public IntervalPattern(String name, List<Interval> intervalList) {
    super(name);
    
    this.intervalList = intervalList;
  }
  
  /*
  
  public static Interval getIntervalByString(String lookupString) {
    Interval lookupValue = lookup.get(lookupString);
    
    if (lookupValue == null) {
      throw new IllegalArgumentException("Illegal lookup string.");
    }
    
    return lookupValue;
  }
  */

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
}
