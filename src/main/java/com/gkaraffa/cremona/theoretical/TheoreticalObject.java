package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalObject {
  private String text = null;
  private String abbrev = null;

  public TheoreticalObject(String text) {
    this.text = text;
  }

  public final String getText() {
    return this.text;
  }

  public final String getAbbrev() {
    return abbrev;
  }

  public final void setAbbrev(String abbrev) {
    this.abbrev = abbrev;
  }

  @Override
  public String toString() {
    return this.text;
  }

  @Override
  public int hashCode() {
    int prime = 3;
    int result = 5;

    result = prime * result + ((text == null) ? 0 : text.hashCode());

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
