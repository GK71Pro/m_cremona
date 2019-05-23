package com.gkaraffa.cremona.experimental;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.common.PitchCollection;
import com.gkaraffa.cremona.instrument.model.GuitarModel;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class FretboardCreator {
  private static final String fret =
      "---------------------------------------------------------------\n";

  public FretboardCreator() {}

  public static String createFretboardText(GuitarModel guitarModel) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    sB.append(FretboardCreator.fret);

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getRow(index);

      sB.append(formatTextFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        sB.append(formatTextCell(currentFret[subindex]));
      }

      sB.append("\n" + FretboardCreator.fret);
    }

    return (sB.toString());
  }

  public static String createFretboardCSV(GuitarModel guitarModel) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getRow(index);

      sB.append(formatCSVFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        sB.append(formatCSVCell(currentFret[subindex]));
      }
      
      sB.deleteCharAt(sB.length() - 1);
      sB.append("\n");
    }

    return (sB.toString());
  }

  public static String createFormattedFretboardText(GuitarModel guitarModel,
      ToneCollection toneCollection) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    sB.append(FretboardCreator.fret);

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getFilteredRow(index, toneCollection);

      sB.append(formatTextFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        sB.append(formatTextCell(currentFret[subindex]));
      }

      sB.append("\n" + FretboardCreator.fret);
    }

    return (sB.toString());
  }

  public static String createFormattedFretboardCSV(GuitarModel guitarModel,
      ToneCollection toneCollection) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getFilteredRow(index, toneCollection);

      sB.append(formatCSVFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        sB.append(formatCSVCell(currentFret[subindex]));
      }

      sB.deleteCharAt(sB.length() - 1);
      sB.append("\n");
    }

    return (sB.toString());
  }  
  
  public static String createFormattedFretboardText(GuitarModel guitarModel,
      PitchCollection pitchCollection) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    sB.append(FretboardCreator.fret);

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getFilteredRow(index, pitchCollection);

      sB.append(formatTextFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        sB.append(formatTextCell(currentFret[subindex]));
      }

      sB.append("\n" + FretboardCreator.fret);
    }

    return (sB.toString());
  }

  public static String createFormattedFretboardCSV(GuitarModel guitarModel,
      PitchCollection pitchCollection) {
    StringBuilder sB = new StringBuilder();
    int numStrings = guitarModel.getStringCount();
    int numFrets = guitarModel.getFretCount();

    for (int index = 0; index <= numFrets; index++) {
      Pitch[] currentFret = guitarModel.getFilteredRow(index, pitchCollection);

      sB.append(formatCSVFretNumber(Integer.toString(index)));

      for (int subindex = 0; subindex < numStrings; subindex++) {
        sB.append(formatCSVCell(currentFret[subindex]));
      }

      sB.deleteCharAt(sB.length() - 1);
      sB.append("\n");
    }

    return (sB.toString());
  }  
  

  private static String formatTextFretNumber(String fretNumber) {
    StringBuilder sB = new StringBuilder();

    if (fretNumber.length() == 1) {
      sB.insert(0, " ");
    }

    sB.append(fretNumber);
    sB.append("|");

    return sB.toString();
  }

  private static String formatCSVFretNumber(String fretNumber) {
    StringBuilder sB = new StringBuilder();

    /*
    if (fretNumber.length() == 1) {
      sB.insert(0, " ");
    }
    */

    sB.append(fretNumber);
    sB.append(",");

    return sB.toString();
  }

  private static String formatTextCell(Pitch pitch) {
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


  private static String formatCSVCell(Pitch pitch) {
    StringBuilder sB = new StringBuilder();

    if (pitch == null) {
      sB.append(" ");
    }
    else {
      sB.append(pitch.getText());
    }

    /*
    if (sB.length() == 3) {
    sB.insert(0, "   ");
    sB.append("   ");
    }
    else {
    sB.insert(0, " ");
    sB.append(" ");
    }
    */

    sB.append(",");

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
