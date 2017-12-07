package com.gkaraffa.cremona.theoretical;

public interface Harmonizable {
  public Tone getToneAtRelativeIntervalNumber(IntervalNumber rootInterval, IntervalNumber offsetInterval);
}
