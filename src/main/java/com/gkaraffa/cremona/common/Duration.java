package com.gkaraffa.cremona.common;

public class Duration extends CremonaObject {
  private Fraction length;

  public Duration(Duration d) {
    super(d.toString());
    this.length = d.getLength();
  }

  public Duration(Fraction length) {
    super(length.getNumerator() + "/" + length.getDenominator());
    this.length = length;
  }

  public Fraction getLength() {
    return this.length;
  }
}
