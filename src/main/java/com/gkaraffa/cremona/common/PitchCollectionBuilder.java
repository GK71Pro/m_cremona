package com.gkaraffa.cremona.common;

import java.util.ArrayList;

public class PitchCollectionBuilder extends CremonaObject {
  private final ArrayList<Pitch> pitchList;

  public PitchCollectionBuilder() {
    super("");
    pitchList = new ArrayList<Pitch>();
  }

  public PitchCollectionBuilder(String text) {
    super(text);
    pitchList = new ArrayList<Pitch>();
  }

  public PitchCollectionBuilder(String text, PitchCollection pitchCollection) {
    super(text);

    pitchList = new ArrayList<Pitch>();

    for (Pitch pitch : pitchCollection) {
      pitchList.add(pitch);
    }
  }

  public int getSize() {
    return pitchList.size();
  }

  public Pitch getPitch(int position) {
    if (position > (pitchList.size() - 1)) {
      return pitchList.get(position - pitchList.size());
    }
    else {
      return pitchList.get(position);
    }
  }

  public void insert(Pitch subject) {
    if (!contains(subject)) {
      pitchList.add(subject);
    }
  }

  public boolean contains(Pitch target) {
    for (Pitch pitch : pitchList) {
      if (pitch == target) {
        return true;
      }
    }

    return false;
  }

  public PitchCollection toPitchCollection() {
    if (pitchList.isEmpty()) {
      return null;
    }

    return new PitchCollection(this.toString(), pitchList.toArray(new Pitch[pitchList.size()]));
  }
}
