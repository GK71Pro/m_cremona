package com.gkaraffa.cremona.common;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class PitchCollection extends CremonaObject implements Iterable<Pitch> {
  private final Pitch[] pitches;

  public PitchCollection(String name, Pitch[] pitches) throws IllegalArgumentException {
    super(name);
    if (this.arePitchesDistinct(pitches)) {
      this.pitches = pitches;
    }
    else {
      throw new IllegalArgumentException("Elements are not distinct.");
    }
  }

  public boolean contains(Pitch target) {
    for (Pitch pitch : pitches) {
      if (pitch.equals(target)) {
        return true;
      }
    }

    return false;
  }

  public boolean contains(PitchCollection target) {
    for (Pitch targetElement : target) {
      boolean found = false;

      for (Pitch pitch : pitches) {
        if (pitch.equals(targetElement)) {
          found = true;
        }
      }

      if (!found) {
        return false;
      }
    }

    return true;
  }

  public PitchCollection intersection(PitchCollection target) {
    PitchCollectionBuilder pitchCollectionBuilder = new PitchCollectionBuilder(
        "Intersection of " + this.toString() + " and " + target.toString());
    // "Intersection of " + this.getText() + " and " + target.getText());

    for (Pitch outerPitch : pitches) {
      for (Pitch innerPitch : target) {
        if (innerPitch.equals(outerPitch)) {
          pitchCollectionBuilder.insert(innerPitch);
          break;
        }
      }
    }

    return pitchCollectionBuilder.toPitchCollection();
  }

  public PitchCollection union(PitchCollection target) {
    PitchCollectionBuilder pitchCollectionBuilder = new PitchCollectionBuilder(
        "Union of " + this.toString() + " and " + target.toString(), this);
    // new PitchCollectionBuilder("Union of " + this.getText() + " and " + target.getText(), this);

    for (Pitch pitch : target) {
      pitchCollectionBuilder.insert(pitch);
    }

    return pitchCollectionBuilder.toPitchCollection();
  }

  public String getSpellingString() {
    StringBuilder sb = new StringBuilder();

    for (Pitch pitch : pitches) {
      sb.append(pitch.toString() + ", ");
      // sb.append(pitch.getText() + ", ");
    }

    sb.setLength(sb.length() - 2);

    return sb.toString();
  }

  public int getSize() {
    return pitches.length;
  }

  public Pitch getpitch(int position) {
    if (position > (pitches.length - 1)) {
      return pitches[position - pitches.length];
    }
    else {
      return pitches[position];
    }
  }

  public int getPosition(Pitch target) throws IllegalArgumentException {
    for (int i = 0; i < pitches.length; i++) {
      if (this.pitches[i].equals(target)) {
        return i;
      }
    }

    throw new IllegalArgumentException("Pitch does not exist in this PitchCollection");
  }

  private boolean arePitchesDistinct(Pitch[] pitches) {
    TreeSet<Pitch> treeSet = new TreeSet<>(Arrays.asList(pitches));

    if (pitches.length != treeSet.size()) {
      return false;
    }

    return true;
  }

  @Override
  public Iterator<Pitch> iterator() {
    return new PitchIterator();
  }

  class PitchIterator implements Iterator<Pitch> {
    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < getSize();
    }

    @Override
    public Pitch next() {
      return getpitch(index++);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("not supported yet");
    }
  }

}
