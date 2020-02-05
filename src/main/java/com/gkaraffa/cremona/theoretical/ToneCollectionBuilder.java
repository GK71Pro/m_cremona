package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;

public class ToneCollectionBuilder {
  private final ArrayList<Tone> toneList;

  public ToneCollectionBuilder() {
    toneList = new ArrayList<Tone>();
  }

  public ToneCollectionBuilder(ToneCollection toneCollection) {
    toneList = new ArrayList<Tone>();

    toneList.addAll(toneCollection.getListCopy());
  }

  public int getSize() {
    return toneList.size();
  }

  public Tone getTone(int position) {
    if (position > (toneList.size() - 1)) {
      return toneList.get(position - toneList.size());
    }
    else {
      return toneList.get(position);
    }
  }

  public boolean contains(Tone target) {
    return toneList.contains(target);
  }

  public void append(Tone subject) {
    if (!contains(subject)) {
      toneList.add(subject);
    }
  }

  public void prepend(Tone subject) {
    if (!contains(subject)) {
      toneList.add(0, subject);
    }
  }

  public void remove(int index) {
    toneList.remove(index);
  }
  
  public void remove(Tone subject) {
    int index = toneList.indexOf(subject);
    
    if (index != -1) {
      this.remove(index);
    }    
  }

  public ToneCollection toToneCollection() {
    if (toneList.isEmpty()) {
      return null;
    }

    return new ToneCollection(toneList);
  }
}
