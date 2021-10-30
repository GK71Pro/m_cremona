package com.gkaraffa.cremona.theoretical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ToneCollection implements Iterable<Tone>, Spellable {
  private final List<Tone> toneList = new ArrayList<>();

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
  }

  public List<Tone> getListCopy() {
    return new ArrayList<>(this.toneList);
  }

  public boolean contains(ToneCollection target) {
    for (Tone targetElement : target) {
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

  private boolean areTonesDistinct(List<Tone> toneList) {
    TreeSet<Tone> treeSet = new TreeSet<>(toneList);

    if (toneList.size() != treeSet.size()) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int prime = 5;
    int result = 7;

    result = prime * result + ((toneList == null) ? 0 : toneList.hashCode());

    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof ToneCollection)) {
      return false;
    }

    ToneCollection tC = (ToneCollection) o;

    return (tC.hashCode() == this.hashCode());
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
