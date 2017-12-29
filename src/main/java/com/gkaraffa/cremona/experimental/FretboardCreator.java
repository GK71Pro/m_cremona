package com.gkaraffa.cremona.experimental;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.instrument.model.GuitarModel;

public class FretboardCreator {
  private static final String fret = "---------------------------------------------------------------\n";

  public FretboardCreator() {
    // TODO Auto-generated constructor stub
  }

  public static String createFretboard(GuitarModel guitarModel) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    //header
    //append fret line
    sB.append(FretboardCreator.fret);

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getRow(index);

      //append fret number
      sB.append(formatFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        //append cell
        sB.append(formatCell(currentFret[subindex]));
      }
      
      //line complete
      sB.append("\n");
      
      //append fret line
      sB.append(FretboardCreator.fret);
    }

    return (sB.toString());
  }
  
  private static String formatFretNumber(String fretNumber) {
    StringBuilder sB = new StringBuilder();
    
    if (fretNumber.length() == 1) {
      sB.insert(0, " ");
    }

    sB.append(fretNumber);
    sB.append("|");
    
    return sB.toString();
  }
  
  private static String formatCell(Pitch pitch) {
    StringBuilder sB = new StringBuilder();
    
    if (pitch == null) {
      sB.append("   ");
    }
    else {
      sB.append(pitch.getText());
    }

    if (sB.length() == 3) {
      sB.insert(0, "   ");
      sB.append("   ");
    }
    else {
      sB.insert(0, " ");
      sB.append(" ");
    }

    sB.append("|");
    
    return sB.toString();
  }
}

  /*
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
  */
