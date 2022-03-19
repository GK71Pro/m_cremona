package com.gkaraffa.cremona.common;

public abstract class CremonaObject {
  private String text = null;

  protected CremonaObject(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }
}
