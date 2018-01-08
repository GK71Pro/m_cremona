package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.DiminishedScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.PentatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.Scale;
import com.gkaraffa.cremona.theoretical.scale.ScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.WholeToneScaleFactory;

public class Main {

  public Main() {}

  public static void main(String[] args) {
    System.out.println("Process starts.");

    try {
      testScale();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("Process completes.");
  }


  @SuppressWarnings("unused")
  private static void testPitch() {
    Pitch pitch = new Pitch(Tone.C, 1);
    for (int index = 0; index <= 24; index ++) {
      System.out.println(pitch);
      pitch = pitch.generatePitchByOffset(1);
    }
  }
  
  private static void testScale() {    
    ScaleFactory scaleFactory = new WholeToneScaleFactory();
    Scale scale = scaleFactory.createScale(IntervalPattern.wholeTonePattern, Tone.C);
    System.out.println(scale);
    System.out.println(scale.getSpellingString());
  }
}

