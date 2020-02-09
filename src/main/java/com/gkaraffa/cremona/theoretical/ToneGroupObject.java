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
  
  @Override
  public int hashCode() {
    int prime = 7;
    int result = 11;

    result = prime * result + ((toneCollection == null) ? 0 : toneCollection.hashCode());

    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof ToneGroupObject)) {
      return false;
    }

    ToneGroupObject tGO = (ToneGroupObject) o;

    return (tGO.hashCode() == this.hashCode());
  }
}
