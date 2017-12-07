package com.gkaraffa.cremona.instrument.view;

import java.util.ArrayList;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;

public class GuitarViewFactory extends InstrumentViewFactory {

  public GuitarViewFactory() {
    super();
  }

  @Override
  public InstrumentView createInstrumentView() {
    int fretCount = 24;
    ArrayList<ArrayList<Pitch>> guitarStrings = new ArrayList<ArrayList<Pitch>>();
    
    guitarStrings.add(createStringNotes(new Pitch(Tone.E, 2), fretCount));
    guitarStrings.add(createStringNotes(new Pitch(Tone.A, 3), fretCount));
    guitarStrings.add(createStringNotes(new Pitch(Tone.D, 3), fretCount));
    guitarStrings.add(createStringNotes(new Pitch(Tone.G, 3), fretCount));
    guitarStrings.add(createStringNotes(new Pitch(Tone.B, 4), fretCount));
    guitarStrings.add(createStringNotes(new Pitch(Tone.E, 4), fretCount));

    return new GuitarView(guitarStrings, fretCount);
  }

  @Override
  public InstrumentView createInstrumentView(InstrumentViewParameters iVP) {
    int fretCount;
    ArrayList<Pitch> parmOpenStringPitches = new ArrayList<Pitch>();

    if (iVP instanceof GuitarViewParameters) {
      GuitarViewParameters gVP = (GuitarViewParameters) iVP;
      fretCount = gVP.getNumberOfFrets();
      parmOpenStringPitches = gVP.getOpenStringPitches();
    }
    else {
      throw new IllegalArgumentException();
    }

    // build
    ArrayList<ArrayList<Pitch>> guitarStrings = new ArrayList<ArrayList<Pitch>>();
    int stringCount = parmOpenStringPitches.size();
    for (int index = 0; index < stringCount; index++) {
      guitarStrings.add(createStringNotes(parmOpenStringPitches.get(index), fretCount));
    }
    
    return new GuitarView(guitarStrings, fretCount);
  }

  private ArrayList<Pitch> createStringNotes(Pitch pitch, int numberFrets) {
    ArrayList<Pitch> stringPitches = new ArrayList<Pitch>();
    int index = 0;

    Pitch nextPitch = pitch;
    do {
      stringPitches.add(nextPitch);
      
      if (nextPitch.getTone() == Tone.GSHARP_AFLAT) {
        nextPitch = new Pitch(TonalSpectrum.traverseDistance(nextPitch.getTone(), 1), nextPitch.getRange() + 1);
      }
      else {
        nextPitch = new Pitch(TonalSpectrum.traverseDistance(nextPitch.getTone(), 1), nextPitch.getRange());        
      }
      
      index++;
    } while (index <= numberFrets);

    return stringPitches;
  }
}
