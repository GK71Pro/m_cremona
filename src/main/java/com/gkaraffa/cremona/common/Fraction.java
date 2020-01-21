package com.gkaraffa.cremona.common;

public class Fraction extends Object implements Comparable<Object> {
  private int numerator = 0;
  private int denominator = 1;
  private int workingNumerator;
  private int workingDenominator;

  // accessors and mutators
  public int getNumerator() {
    return (this.numerator);
  }

  public int getDenominator() {
    return (this.denominator);
  }

  public int getWorkingNumerator() {
    return (this.workingNumerator);
  }

  public int getWorkingDenominator() {
    return (this.workingDenominator);
  }

  // constructors
  public Fraction() {}

  public Fraction(int paramNumerator, int paramDenominator) {
    // check for divide by zero
    if (paramDenominator == 0) {
      throw (new IllegalArgumentException("Argument paramDenominator is 0"));
    }

    this.numerator = paramNumerator;
    this.denominator = paramDenominator;
    this.workingNumerator = paramNumerator;
    this.workingDenominator = paramDenominator;
    reduce();
  }

  public Fraction(Fraction sourceFraction) {
    this.numerator = sourceFraction.getNumerator();
    this.denominator = sourceFraction.getDenominator();
    this.workingNumerator = sourceFraction.getNumerator();
    this.workingDenominator = sourceFraction.getDenominator();
    reduce();
  }

  public static Fraction[] createWorkingCommonTermPair(Fraction fractionA, Fraction fractionB) {
    Fraction[] returnArray = new Fraction[2];

    int multiple = fractionB.getDenominator() * fractionA.getDenominator();
    int fANum = fractionA.getNumerator() * (multiple / fractionA.getDenominator());
    int fBNum = fractionB.getNumerator() * (multiple / fractionB.getDenominator());

    returnArray[0] = new Fraction(fANum, multiple);
    returnArray[1] = new Fraction(fBNum, multiple);

    return (returnArray);
  }

  public Fraction add(Fraction incrementor) {
    Fraction result = null;
    Fraction[] fractionArray = null;

    fractionArray = Fraction.createWorkingCommonTermPair(this, incrementor);
    result = new Fraction(
        (fractionArray[0].getWorkingNumerator() + fractionArray[1].getWorkingNumerator()),
        fractionArray[0].getWorkingDenominator());
    return (result);
  }

  public Fraction subtract(Fraction decrementor) {
    Fraction result = null;
    Fraction[] fractionArray = null;

    fractionArray = Fraction.createWorkingCommonTermPair(this, decrementor);
    result = new Fraction(
        (fractionArray[0].getWorkingNumerator() - fractionArray[1].getWorkingNumerator()),
        fractionArray[0].getWorkingDenominator());
    return (result);
  }

  public Fraction multiply(Fraction multiplier) {
    int productNum = multiplier.getNumerator() * this.numerator;
    int productDen = multiplier.getDenominator() * this.denominator;

    return (new Fraction(productNum, productDen));
  }

  public Fraction divide(Fraction divisor) {
    int quotientNum = divisor.getDenominator() * this.numerator;
    int quotientDen = divisor.getNumerator() * this.denominator;

    return (new Fraction(quotientNum, quotientDen));
  }

  @Override
  public String toString() {
    return ("" + this.numerator + "/" + this.denominator);
  }

  @Override
  public int compareTo(Object o) {
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;

    // identity check
    if (this == o) {
      return EQUAL;
    }

    // test for same object type
    if (!(o instanceof Fraction)) {
      throw new ClassCastException();
    }

    // test for lesser or greater
    Fraction[] fractionArray = Fraction.createWorkingCommonTermPair(this, (Fraction) o);

    if (fractionArray[1].getWorkingNumerator() == fractionArray[0].getWorkingNumerator()) {
      return EQUAL;
    }
    else
      if (fractionArray[0].getWorkingNumerator() < fractionArray[1].getWorkingNumerator()) {
        return BEFORE;
      }
      else {
        return AFTER;
      }
  }

  @Override
  public boolean equals(Object other) {
    // 1 - identity check
    // 2 - type check
    // 3 - content check

    // identity check
    if (this == other) {
      return (true);
    }

    // type check
    if (!(this.getClass().getName().equals(other.getClass().getName()))) {
      return (false);
    }

    // content check
    if ((((Fraction) other).getNumerator() == this.numerator)
        && (((Fraction) other).getDenominator() == this.denominator)) {
      return (true);
    }
    else {
      return (false);
    }
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 5 * hash + this.numerator;
    hash = 7 * hash + this.denominator;
    return hash;
  }

  // private methods
  private void reduce() {
    boolean negativeFlag = false;

    if (this.numerator < 0) {
      this.numerator = this.numerator * -1;
      negativeFlag = true;
    }

    int gcd = euclideanGCD(this.numerator, this.denominator);

    this.numerator = this.numerator / gcd;
    if (negativeFlag) {
      this.numerator = this.numerator * -1;
    }

    this.denominator = this.denominator / gcd;
  }

  private int euclideanGCD(int alpha, int beta) {
    int max;
    int min;
    int mod;
    int premod;

    if (alpha > beta) {
      max = alpha;
      min = beta;
    }
    else {
      max = beta;
      min = alpha;
    }

    premod = min;
    mod = max % min;

    while (mod != 0) {
      premod = mod;
      max = min;
      min = mod;
      mod = max % min;
    }

    return (premod);
  }

}
