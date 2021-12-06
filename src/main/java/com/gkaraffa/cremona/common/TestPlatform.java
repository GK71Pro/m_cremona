package com.gkaraffa.cremona.common;

import java.util.ArrayList;
import java.util.List;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.Scale;
import com.gkaraffa.cremona.theoretical.scale.ScaleFactory;

public class TestPlatform {

  public static void main(String[] args) {
    List<IntervalPattern> modePatternList = createLydianDominantModePatternList();
    ScaleFactory sFactory = new DiatonicScaleFactory();
    Tone key = Tone.C;
    List<Scale> parallelModeList = new ArrayList<Scale>(7);
    
    for(IntervalPattern iP: modePatternList) {
      parallelModeList.add(sFactory.createScale(iP, key));
    }
    
    for(Scale scale: parallelModeList) {
      System.out.println(scale.getLongName());
      System.out.println(scale.getToneCollection().getSpellingString());
    }

  }
  
  public static List<IntervalPattern> createLydianDominantModePatternList(){
    IntervalPattern basePattern = DiatonicScale.LYDIAN_DOMINANT_PATTERN;
    List<IntervalPattern> modeList = basePattern.deriveIntervalPatternListForModes();
    
    return modeList;
  }



}
