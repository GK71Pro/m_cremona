package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gkaraffa.cremona.common.CircularList;

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
      int halfSteps = this.getIntervalByLocation(index).getHalfStepsFromTonic();
      Tone currentTone = TonalSpectrum.traverseDistance(tonic, halfSteps);
      tCB.append(currentTone);
    }

    return tCB.toToneCollection();
  }

  public List<Integer> generateHalfStepList() {
    List<Integer> halfStepList = new ArrayList<>();

    int lastDistance = 0;
    for (Interval interval : intervalList) {
      int currentDistance = interval.getHalfStepsFromTonic();
      if (currentDistance == 0) {
        continue;
      }

      int calcGap = currentDistance - lastDistance;
      halfStepList.add(calcGap);
      lastDistance = currentDistance;
    }

    halfStepList.add(12 - lastDistance);

    return halfStepList;
  }

  public IntervalPattern getShiftedIntervalPattern(int offset) {
    List<Integer> oldHSL = this.generateHalfStepList();
    List<Integer> newHSL = getShiftedHalfStepList(oldHSL, offset);
    int extent = newHSL.size() - 1;

    IntervalPatternBuilder iPB = new IntervalPatternBuilder();
    iPB.append(Interval.UNISON);

    int accumulatedHalfSteps = 0;
    int iN = 0;
    for (int index = 0; index <= extent - 1; index++) {
      accumulatedHalfSteps += newHSL.get(index);
      iN++;

      Interval nInterval = Interval.halfStepsAndIntervalNumberToInterval(accumulatedHalfSteps,
          IntervalNumber.integerToIntervalNumber(iN));
      iPB.append(nInterval);
    }

    IntervalPattern intervalPattern = iPB.toIntervalPattern();

    return intervalPattern;
  }


  private List<Integer> getShiftedHalfStepList(List<Integer> oldHSL, int offset) {
    List<Integer> newHSL = new ArrayList<Integer>();
    CircularList<Integer> cL = new CircularList<Integer>((List<Integer>) oldHSL);

    cL.reset(offset);
    Integer i = null;

    while ((i = cL.visitAndMove()) != null) {
      newHSL.add(i);
    }

    return newHSL;
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
