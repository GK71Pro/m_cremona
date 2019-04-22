package com.gkaraffa.cremona.theoretical;

public abstract class ToneGroupObject extends TheoreticalObject {
  protected ToneCollection toneCollection;
  
  public ToneGroupObject(String text) {
    super(text);
  }

  public ToneCollection getToneCollection() {
    return toneCollection;
  }

  public void setToneCollection(ToneCollection toneCollection) {
    this.toneCollection = toneCollection;
  }

  public boolean contentsEqual(Object o) {
    if (!(o instanceof ToneGroupObject)) {
      return false;
    }
    
    ToneCollection tC = (ToneCollection) o;
    
    if(this.toneCollection.contains(tC) && tC.contains(toneCollection)) {
      return true;
    }
    
    return false;
  }
}
