package com.gkaraffa.cremona.instrument.view;

import java.util.ArrayList;

import com.gkaraffa.cremona.common.Pitch;

public class GuitarViewParameters extends InstrumentViewParameters {
  private int numberOfFrets;
  private ArrayList<Pitch> openStringPitches = new ArrayList<Pitch>();

  public GuitarViewParameters() {
    super();
  }
    
  public int getNumberOfFrets() {
    return numberOfFrets;
  }

  public void setNumberOfFrets(int numberOfFrets) {
    this.numberOfFrets = numberOfFrets;
  }

  public ArrayList<Pitch> getOpenStringPitches() {
    return openStringPitches;
  }

  public void setOpenStringPitches(ArrayList<Pitch> openStringPitches) {
    this.openStringPitches = openStringPitches;
  }
}
