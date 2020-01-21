package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject implements Iterable<Interval>, Spellable {
  private List<Interval> intervalList;

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

  @Override
  public String getSpellingString() {
    StringBuilder sb = new StringBuilder();
    for (Interval interval : intervalList) {
      sb.append(interval.getAbbrev());
      sb.append(", ");
    }

    sb.setLength(sb.length() - 2);

    return sb.toString();
  }

  public ToneCollection toToneCollection(Tone tonic) {
    int toneCount = this.getSize();
    ToneCollectionBuilder tCB = new ToneCollectionBuilder();

    tCB.append(tonic);
    for (int index = 1; index < toneCount; index++) {
      int halfSteps = this.getIntervalByLocation(index).getHalfSteps();
      Tone currentTone = TonalSpectrum.traverseDistance(tonic, halfSteps);
      tCB.append(currentTone);
    }

    return tCB.toToneCollection();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof IntervalPattern)) {
      return false;
    }
    IntervalPattern iP = (IntervalPattern) o;

    return (iP.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 19;
    result = 37 * (result + this.getSpellingString().hashCode());
    return result;
  }

  @Override
  public Iterator<Interval> iterator() {
    return new IntervalIterator();
  }

  class IntervalIterator implements Iterator<Interval> {
    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < getSize();
    }

    @Override
    public Interval next() {
      return getIntervalByLocation(index++);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("not supported yet");
    }
  }
}
