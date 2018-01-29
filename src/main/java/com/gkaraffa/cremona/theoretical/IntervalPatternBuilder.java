package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.List;

public class IntervalPatternBuilder {
  private List<Interval> intervalList = new ArrayList<Interval>();

  public IntervalPatternBuilder() {}

  public IntervalPatternBuilder(IntervalPattern source) {
    for (Interval sourceInterval : source) {
      intervalList.add(sourceInterval);
    }
  }

  public int getSize() {
    return intervalList.size();
  }

  public Interval getInterval(int position) {
    if (position > (intervalList.size() - 1)) {
      return intervalList.get(position - intervalList.size());
    }
    else {
      return intervalList.get(position);
    }
  }

  public boolean contains(Interval target) {
    return intervalList.contains(target);
  }

  public void append(Interval subject) {
    if (!contains(subject)) {
      intervalList.add(subject);
    }
  }

  public void prepend(Interval subject) {
    if (!contains(subject)) {
      intervalList.add(0, subject);
    }
  }

  public void remove(int index) {
    intervalList.remove(index);
  }

  
  public IntervalPattern toIntervalPattern() {
    if (intervalList.isEmpty()) {
      return null;
    }

    return new IntervalPattern("", intervalList);
  }
}
