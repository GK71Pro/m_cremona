package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject implements Iterable<Interval>, Spellable {
  private List<Interval> intervalList;
  private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();

  static {
    for (Interval currInterval : Interval.values()) {
      lookup.put(currInterval.getAbbrev(), currInterval);
    }
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
    for (Interval interval : intervalList) {
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
}
