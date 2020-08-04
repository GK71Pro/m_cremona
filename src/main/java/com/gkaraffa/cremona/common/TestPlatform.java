package com.gkaraffa.cremona.common;

import java.util.List;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class TestPlatform {

  public static void main(String[] args) {

    for (Interval interval : DiatonicScale.MELODIC_MINOR_PATTERN) {
      System.out.println(interval.getAbbrev() + " : " + interval.getHalfStepsFromTonic() + " : "
          + interval.getIntervalNumber() + " : " + interval.getAbbrev());
    }

    List<Integer> distanceList = DiatonicScale.IONIAN_PATTERN.halfStepList();
    for (int x : distanceList) {
      System.out.println(x);
    }
  }
  
}
