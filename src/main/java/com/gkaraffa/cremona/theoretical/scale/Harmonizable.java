package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.Tone;

public interface Harmonizable {
  public Tone getToneAtRelativeIntervalNumber(IntervalNumber rootInterval, IntervalNumber offsetInterval);
}
