package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.theoretical.*;

public class Duration extends TheoreticalObject {
  private Fraction length;

  public Duration(Duration d) {
    super(d.getText());
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
