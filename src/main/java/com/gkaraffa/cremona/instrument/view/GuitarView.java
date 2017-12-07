package com.gkaraffa.cremona.instrument.view;

import java.util.ArrayList;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.common.PitchCollection;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class GuitarView extends InstrumentView {
  private ArrayList<ArrayList<Pitch>> strings = new ArrayList<ArrayList<Pitch>>();
  private int numberFrets;


  public GuitarView(ArrayList<ArrayList<Pitch>> strings, int numberFrets) {
    super();
    this.strings = strings;
    this.numberFrets = numberFrets;
  }

  
  @Override
  public String getTextView() {
    StringBuilder sB = new StringBuilder();
    int numStrings = strings.size();

    sB.append("---------------------------------------------------------------\n");

    for (int index = 0; index <= numberFrets; index++) {
      StringBuilder fretNumber = new StringBuilder(Integer.toString(index));

      if (fretNumber.length() == 1) {
        fretNumber.insert(0, " ");
      }

      sB.append(fretNumber.toString());
      sB.append("|");

      for (int subindex = 0; subindex < numStrings; subindex++) {
        ArrayList<Pitch> currentString = (ArrayList<Pitch>) strings.get(subindex);
        Pitch currentPitch = (Pitch) currentString.get(index);
        String subjectString = currentPitch.getText();

        if (subjectString.length() == 3) {
          sB.append("   ").append(subjectString).append("   ");
        }
        else {
          sB.append(" ").append(subjectString).append(" ");
        }

        sB.append("|");
      }
      
      sB.append("\n");
      sB.append("---------------------------------------------------------------\n");
    }

    return (sB.toString());
  }
  

  

  @Override
  public String getTextView(ToneCollection toneCollection) {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      sb.append(index);
      sb.append("\t");
      for (int subindex = 0; subindex < numStrings; subindex++) {
        ArrayList<Pitch> currentString = (ArrayList<Pitch>) strings.get(subindex);
        Pitch currentPitch = (Pitch) currentString.get(index);
        if (toneCollection.contains(currentPitch.getTone())) {
          sb.append(currentPitch.toString());
        }
        else {
          sb.append(" ");
        }
        sb.append("\t");
      }
      sb.append("\n");
    }

    return (sb.toString());
  }

  @Override
  public String getTextView(PitchCollection pitchCollection) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getCSVView() {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Pitch currentPitch = getPitch(subindex, index);
        sb.append(currentPitch.toString());
        sb.append(",");
      }
      sb.append("\n");
    }
    return (sb.toString());
  }

  @Override
  public String getCSVView(ToneCollection toneCollection) {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Pitch currentPitch = getPitch(subindex, index);
        if (toneCollection.contains(currentPitch.getTone())) {
          sb.append(currentPitch.toString());
        }
        else {
          sb.append(" ");
        }
        sb.append(",");
      }
      sb.append("\n");
    }
    return (sb.toString());
  }

  @Override
  public String getCSVView(PitchCollection pitchCollection) {
    // TODO Auto-generated method stub
    return null;
  }

  public Pitch getPitch(int numString, int numFret) {
    return ((Pitch) strings.get(numString).get(numFret));
  }

  /*
  public Tone getTone(int numString, int numFret) {
    return ((Tone) strings.get(numString).get(numFret));
  }
  */

  /*
  public ArrayList<Tone> getGuitarList(ToneCollection collection) {
    ArrayList<Tone> al = new ArrayList<Tone>();
    int numStrings = strings.size();
  
    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Tone currentTone = getTone(subindex, index);
        if (collection.contains(currentTone)) {
          al.add(currentTone);
        }
        else {
          al.add(null);
        }
      }
    }
  
    return (al);
  }
  */
}
