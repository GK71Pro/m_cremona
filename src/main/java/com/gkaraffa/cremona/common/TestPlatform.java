package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class TestPlatform {

  public static void main(String[] args) {
    IntervalPattern iP = DiatonicScale.IONIAN_PATTERN;

    System.out.println(iP.getShiftedIntervalPattern(1).getSpellingString());
  }
}
