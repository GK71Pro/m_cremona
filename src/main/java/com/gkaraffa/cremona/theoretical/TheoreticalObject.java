package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalObject {
  private String text = null;

  public TheoreticalObject(String text) {
    this.text = text;
  }

  public String toString() {
    return this.text;
  }

  public final String getText() {
    return this.text;
  }

}
