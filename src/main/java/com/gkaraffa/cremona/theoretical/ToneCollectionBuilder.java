package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;

public class ToneCollectionBuilder {
  private final ArrayList<Tone> toneList;

  public ToneCollectionBuilder() {
    // super(text);
    toneList = new ArrayList<Tone>();
  }

  public ToneCollectionBuilder(ToneCollection toneCollection) {
    toneList = new ArrayList<Tone>();

    for (Tone tone : toneCollection) {
      toneList.add(tone);
    }
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

  public void insert(Tone subject) {
    if (!contains(subject)) {
      toneList.add(subject);
    }
  }

  public boolean contains(Tone target) {
    return toneList.contains(target);
  }

  public ToneCollection toToneCollection() {
    if (toneList.isEmpty()) {
      return null;
    }

    return new ToneCollection(toneList.toArray(new Tone[toneList.size()]));
  }
}
