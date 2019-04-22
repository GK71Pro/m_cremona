package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalObject {
  private String text = null;

  public TheoreticalObject(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }

  public final String getText() {
    return this.text;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof TheoreticalObject)) {
      return false;
    }
    TheoreticalObject tO = (TheoreticalObject) o;

    return (tO.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + text.hashCode();
    return result;
  }
}
