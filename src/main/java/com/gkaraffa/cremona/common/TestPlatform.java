package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;

public class TestPlatform {

  public static void main(String[] args) {
    for(Interval interval: Interval.values()) {
      int halfSteps = interval.getHalfSteps();
      IntervalNumber intervalNumber = interval.getIntervalNumber();
      
      Interval foundInterval = Interval.halfStepsAndIntervalNumberToInterval(halfSteps, intervalNumber);

      System.out.println(interval.getAbbrev() 
          + " : " + halfSteps 
          + " : " + intervalNumber 
          + " : " + foundInterval.getAbbrev());
    }
  }
}
