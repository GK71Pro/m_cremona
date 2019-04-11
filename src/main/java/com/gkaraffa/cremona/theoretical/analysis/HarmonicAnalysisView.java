package com.gkaraffa.cremona.theoretical.analysis;

import java.util.ArrayList;
import java.util.List;

import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class HarmonicAnalysisView implements AnalysisView {
  private DiatonicScale dScale = null;
  // private List<Chord> chords = new ArrayList<Chord>();
  private List<RomanNumeral> romanNumerals = new ArrayList<RomanNumeral>();
  
  public HarmonicAnalysisView() {}
  
  public HarmonicAnalysisView(DiatonicScale dScale) {
    this.dScale = dScale;
    // this.chords = new ArrayList<Chord>();
    
    // generateChords();
    generateRomanNumerals();
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    StringBuilder sB = new StringBuilder();
    
    for(RomanNumeral romanNumeral: romanNumerals) {
      Chord chord = romanNumeral.getChord();
      sB.append(String.format("%-4.4s", romanNumeral.getText()));
      sB.append("\t");
      sB.append(String.format("%-20.20s", chord));
      sB.append("\t");
      sB.append(String.format("%-19.19s", this.getSpellingString(chord)));
      sB.append("\n");
    }
    
    return sB.toString();
  }

  @Override
  public String getCSV() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
  private void generateChords() {
    ToneCollection tones = this.dScale.getToneCollection();
    ChordFactory chordFactory = new ChordFactory();
    
    for(Tone tone: tones) {
      this.chords.add(chordFactory.createChordFromHarmonizableScale(this.dScale, tone, 3));
    }
  }
  */
  
  private void generateRomanNumerals() {
    int exLimit = this.dScale.getToneCollection().getSize();
    
    for(int index = 0; index < exLimit; index++) {
      romanNumerals.add(RomanNumeral.createRomanNumeral(this.dScale, index));
    }
  }
  
  private String getSpellingString(Chord chord) {
    StringBuilder sB = new StringBuilder();

    ToneCollection chordTones = chord.getToneCollection();
    for(Tone tone: chordTones) {
      sB.append(tone);
      sB.append(", ");
    }
    
    int size = sB.length();
    sB.delete((size - 2), size);
    
    return sB.toString();
  }
  
}
