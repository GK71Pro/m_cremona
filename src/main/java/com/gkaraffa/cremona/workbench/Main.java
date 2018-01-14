package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.Scale;
import com.gkaraffa.cremona.theoretical.scale.ScaleFactory;

public class Main {

  public Main() {}

  public static void main(String[] args) {
    System.out.println("Process starts.");

    try {
      testChord();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Process completes.");
  }


  @SuppressWarnings("unused")
  private static void testPitch() {
    Pitch pitch = new Pitch(Tone.C, 1);
    for (int index = 0; index <= 24; index++) {
      System.out.println(pitch);
      pitch = pitch.generatePitchByOffset(1);
    }
  }

  @SuppressWarnings("unused")
  private static void testScale() {
    ScaleFactory scaleFactory = new DiatonicScaleFactory();
    Scale scale = scaleFactory.createScale(IntervalPattern.IONIAN_PATTERN, Tone.C);
    System.out.println(scale);
    System.out.println(scale.getSpellingString());
  }
  
  private static void testChord() {
    ChordFactory chordFactory = new ChordFactory();
    Chord chord = chordFactory.createChordFromIntervalPattern(IntervalPattern.AUGMENTED_CHORD_PATTERN, Tone.C);
    System.out.println(chord.getIntervalPattern().getSpellingString());
    System.out.println(chord.getToneCollection().getSpellingString());
    System.out.println(chord.getChordQuality().getText());
    
  }
}

