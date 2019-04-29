package com.gkaraffa.cremona.theoretical.analysis;

import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class RomanNumeralAnalysisView implements AnalysisView{
  private RomanNumeral[] romanNumerals = new RomanNumeral[7];
  
  public RomanNumeralAnalysisView() {}
  
  public RomanNumeralAnalysisView(DiatonicScale scale) {
    int maxOffset = scale.getToneCollection().getSize() - 1;
    for(int index = 0; index <= maxOffset; index++) {
      romanNumerals[index] = RomanNumeral.createRomanNumeral(scale, index, 4);
    }
  }
  
  @Override
  public String getText() {
    StringBuilder sB = new StringBuilder();
    
    for(RomanNumeral romanNumeral: romanNumerals) {
      sB.append(String.format("%-4.4s", romanNumeral.getText()));
      sB.append("\t");
      sB.append(String.format("%-20.20s", romanNumeral.getChord()));
      sB.append("\n");
    }
    
    return sB.toString();
  }
  
  @Override
  public String getCSV() {
    StringBuilder sB = new StringBuilder();
    
    for(RomanNumeral romanNumeral: romanNumerals) {
      sB.append(romanNumeral.getText());
      sB.append(",");
      sB.append(romanNumeral.getChord());
      sB.append("\n");
    }
    
    return sB.toString();
  }
  
  @Override
  public String toString() {
    return this.getText();
  }

}
