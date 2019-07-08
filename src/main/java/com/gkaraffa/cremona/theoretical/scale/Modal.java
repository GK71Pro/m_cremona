package com.gkaraffa.cremona.theoretical.scale;

public interface Modal {
  
  
  public Modal getModeByNumber(int modalOffset);
  // return the mode (modelOffset) steps from originating mode
  
  public Modal getModeByName(String modeName);
  // return the mode corresponding to the (modeName)
  
}
