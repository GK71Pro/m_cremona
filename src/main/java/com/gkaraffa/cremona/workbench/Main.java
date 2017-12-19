package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.common.PitchCollection;
import com.gkaraffa.cremona.common.PitchCollectionBuilder;
import com.gkaraffa.cremona.instrument.model.GuitarModel;
import com.gkaraffa.cremona.instrument.model.GuitarModelFactory;
import com.gkaraffa.cremona.instrument.model.InstrumentModelFactory;
import com.gkaraffa.cremona.theoretical.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.ScalarIntervalPattern;
import com.gkaraffa.cremona.theoretical.Scale;
import com.gkaraffa.cremona.theoretical.ScaleFactory;
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
    
  @SuppressWarnings("unused")
  private static void testGuitarModel() {
    ScaleFactory sF = new DiatonicScaleFactory();
    Scale scale = sF.createScale(ScalarIntervalPattern.ionianPattern, Tone.C);
    
    PitchCollectionBuilder pCB = new PitchCollectionBuilder();
    pCB.insert(new Pitch(Tone.ASHARP_BFLAT, 3));
    pCB.insert(new Pitch(Tone.CSHARP_DFLAT, 3));
    PitchCollection pC = pCB.toPitchCollection();
    
    InstrumentModelFactory iMF = new GuitarModelFactory();
    GuitarModel gM = (GuitarModel) iMF.createInstrumentModel();
    
    String fretBoard = FretboardCreator.createFretboard(gM);
    System.out.println(fretBoard);
  }
  
  private static void testPitch() {
    Pitch pitch = new Pitch(Tone.C, 1);
    for (int index = 0; index <= 24; index ++) {
      System.out.println(pitch);
      pitch = pitch.generatePitchByOffset(1);
    }
  }
}

