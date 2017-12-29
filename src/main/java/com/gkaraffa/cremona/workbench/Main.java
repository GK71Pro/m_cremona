package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.theoretical.Tone;

public class Main {

  public Main() {}

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    System.out.println("Process starts.");

    try {
      //testFretboardCreator();
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
}

