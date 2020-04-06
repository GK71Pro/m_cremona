package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalObject {
  private String longName = null;

  public TheoreticalObject(String longName) {
    this.longName = longName;
  }

  public final String getLongName() {
    return this.longName;
  }

  @Override
  public String toString() {
    return this.longName;
  }

  @Override
  public int hashCode() {
    int prime = 3;
    int result = 5;

    result = prime * result + ((longName == null) ? 0 : longName.hashCode());

    return result;
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
}
