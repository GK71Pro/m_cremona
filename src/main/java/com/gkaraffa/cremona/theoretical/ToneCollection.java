package com.gkaraffa.cremona.theoretical;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class ToneCollection extends TheoreticalObject implements Iterable<Tone>, Spellable {
  private final Tone[] tones;

  public ToneCollection(String name, Tone[] tones) throws IllegalArgumentException {
    super(name);
    if (this.areTonesDistinct(tones)) {
      this.tones = tones;
    }
    else {
      throw new IllegalArgumentException("Elements are not distinct.");
    }
  }

  public boolean contains(Tone target) {
    for (Tone tone : tones) {
      if (tone.equals(target)) {
        return true;
      }
    }

    return false;
  }

  public boolean contains(ToneCollection target) {
    for (Tone targetElement : target) {
      boolean found = false;

      for (Tone tone : tones) {
        if (tone.equals(targetElement)) {
          found = true;
        }
      }

      if (!found) {
        return false;
      }
    }

    return true;
  }

  public ToneCollection intersection(ToneCollection target) {
    ToneCollectionBuilder toneCollectionBuilder =
        new ToneCollectionBuilder("Intersection of " + this.getText() + " and " + target.getText());

    for (Tone outerTone : tones) {
      for (Tone innerTone : target) {
        if (innerTone.equals(outerTone)) {
          toneCollectionBuilder.insert(innerTone);
          break;
        }
      }
    }

    return toneCollectionBuilder.toToneCollection();
  }

  public ToneCollection union(ToneCollection target) {
    ToneCollectionBuilder toneCollectionBuilder =
        new ToneCollectionBuilder("Union of " + this.getText() + " and " + target.getText(), this);

    for (Tone tone : target) {
      toneCollectionBuilder.insert(tone);
    }

    return toneCollectionBuilder.toToneCollection();
  }

  @Override
  public String getSpellingString() {
    StringBuilder sb = new StringBuilder();

    for (Tone tone : tones) {
      sb.append(tone.getText() + ", ");
    }

    sb.setLength(sb.length() - 2);

    return sb.toString();
  }

  public int getSize() {
    return tones.length;
  }

  public Tone getTone(int position) {
    if (position > (tones.length - 1)) {
      return tones[position - tones.length];
    }
    else {
      return tones[position];
    }
  }

  public int getPosition(Tone target) throws IllegalArgumentException {
    for (int i = 0; i < tones.length; i++) {
      if (this.tones[i].equals(target)) {
        return i;
      }
    }

    throw new IllegalArgumentException("Tone does not exist in this ToneCollection");
  }

  private boolean areTonesDistinct(Tone[] tones) {
    TreeSet<Tone> treeSet = new TreeSet<Tone>(Arrays.asList(tones));

    if (tones.length != treeSet.size()) {
      return false;
    }

    return true;
  }

  public Iterator<Tone> iterator() {
    return new ToneIterator();
  }

  class ToneIterator implements Iterator<Tone> {
    private int index = 0;

    public boolean hasNext() {
      return index < getSize();
    }

    public Tone next() {
      return getTone(index++);
    }

    public void remove() {
      throw new UnsupportedOperationException("not supported yet");
    }
  }


}
