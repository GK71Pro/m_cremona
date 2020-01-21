package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ToneCollection implements Iterable<Tone>, Spellable {
  // prefer ArrayList to Array
  private final List<Tone> toneList = new ArrayList<Tone>();
  // private final Tone[] tones;

  /*
  public ToneCollection(Tone[] tones) {
    if (this.areTonesDistinct(tones)) {
      this.tones = tones;
    }
    else {
      throw new IllegalArgumentException("Elements are not distinct.");
    }
  }
  */

  public ToneCollection(List<Tone> toneList) {
    if (this.areTonesDistinct(toneList)) {
      this.toneList.addAll(toneList);
    }
    else {
      throw new IllegalArgumentException("Elements are not distinct.");
    }
  }

  public boolean contains(Tone target) {
    return this.toneList.contains(target);
    /*
    for (Tone tone : tones) {
      if (tone.equals(target)) {
        return true;
      }
    }
    
    return false;
    */
  }

  /*
  public Tone[] getArrayCopy() {
    return Arrays.copyOf(this.tones, this.tones.length);
  }
  */
  
  public List<Tone> getListCopy() {
    return new ArrayList<Tone>(this.toneList);
  }

  public boolean contains(ToneCollection target) {
    /*
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
    */
    
    for (Tone targetElement: target) {
      if (!this.toneList.contains(targetElement)) {
        return false;
      }
    }
    
    return true;
  }

  public ToneCollection intersection(ToneCollection compCollection) {
    ToneCollectionBuilder toneCollectionBuilder = new ToneCollectionBuilder();

    for (Tone compTone : compCollection) {
      if (this.contains(compTone)) {
        toneCollectionBuilder.append(compTone);
      }
    }

    return toneCollectionBuilder.toToneCollection();
  }

  public ToneCollection union(ToneCollection target) {
    ToneCollectionBuilder toneCollectionBuilder = new ToneCollectionBuilder(this);

    for (Tone tone : target) {
      toneCollectionBuilder.append(tone);
    }

    return toneCollectionBuilder.toToneCollection();
  }

  public ToneCollection symDiff(ToneCollection target) {
    ToneCollectionBuilder toneCollectionBuilder = new ToneCollectionBuilder(this.union(target));
    ToneCollection tcIntersect = this.intersection(target);

    for (Tone tone : tcIntersect) {
      toneCollectionBuilder.remove(tone);
    }

    return toneCollectionBuilder.toToneCollection();
  }

  @Override
  public String getSpellingString() {
    StringBuilder sb = new StringBuilder();

    for (Tone tone : this.toneList) {
      sb.append(tone.getText() + ", ");
    }

    sb.setLength(sb.length() - 2);

    return sb.toString();
  }

  public int getSize() {
    return this.toneList.size();
  }

  public Tone getTone(int position) {
    int length = this.toneList.size();

    if (position > (length - 1)) {
      return this.toneList.get(position - length);
    }
    else {
      return this.toneList.get(position);
    }
  }

  public int getPosition(Tone target) {    
    int index = this.toneList.indexOf(target);
    
    if (index != -1) {
      return index;
    }    
    
    throw new IllegalArgumentException("Tone does not exist in this ToneCollection");
  }

  /*
  private boolean areTonesDistinct(Tone[] tones) {
    TreeSet<Tone> treeSet = new TreeSet<Tone>(Arrays.asList(tones));

    if (tones.length != treeSet.size()) {
      return false;
    }

    return true;
  }
  */

  private boolean areTonesDistinct(List<Tone> toneList) {
    TreeSet<Tone> treeSet = new TreeSet<Tone>(toneList);

    if (toneList.size() != treeSet.size()) {
      return false;
    }

    return true;
  }

  @Override
  public Iterator<Tone> iterator() {
    return new ToneIterator();
  }

  class ToneIterator implements Iterator<Tone> {
    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < getSize();
    }

    @Override
    public Tone next() {
      return getTone(index++);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("not supported yet");
    }
  }
}
