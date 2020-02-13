package com.gkaraffa.cremona.common;

public abstract class CremonaObject {
  private String text = null;

  public CremonaObject(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }

  /*
  public final String getText() {
    return this.text;
  }
  */
}
