package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.theoretical.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Scale;
import com.gkaraffa.cremona.theoretical.ScaleFactory;
import com.gkaraffa.cremona.theoretical.Tone;

public class Main {

  public Main() {}

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    System.out.println("Process starts.");

    try {
      testPitch();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("Process completes.");
  }


  private static void testPitch() {
    Pitch pitch = new Pitch(Tone.C, 1);
    for (int index = 0; index <= 24; index ++) {
      System.out.println(pitch);
      pitch = pitch.generatePitchByOffset(1);
    }
  }
  
  private static void testFretboard() {
    
    ScaleFactory scaleFactory = new DiatonicScaleFactory();
    Scale scale = scaleFactory.createScale(new IntervalPatternFactory().createIntervalPattern("Ionian", DiatonicScaleFactory.ionianPatternString), Tone.C);
  }
}

