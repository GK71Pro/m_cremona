package com.gkaraffa.cremona.theoretical;

public interface Transposable {
  public ToneGroupObject transposeUp(Interval interval);
  public ToneGroupObject transposeUp(int halfSteps);
  public ToneGroupObject transposeDown(Interval interval);
  public ToneGroupObject transposeDown(int halfSteps);
}
