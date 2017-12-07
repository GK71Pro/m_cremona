package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.theoretical.TheoreticalObject;
import com.gkaraffa.cremona.theoretical.Tone;

public class Pitch extends TheoreticalObject implements Comparable<Pitch> {
  private Tone tone;
  private int range;
  private int absVal;

  public Pitch(Pitch p) {
    super(p.getText());
    this.tone = p.getTone();
    this.range = p.getRange();
    this.absVal = generateAbsVal(this.tone, this.range);
  }

  public Pitch(Tone tone, int range) {
    super(tone.getText() + " " + range);
    this.tone = tone;
    this.range = range;
    this.absVal = generateAbsVal(this.tone, this.range);
  }

  public Tone getTone() {
    return this.tone;
  }

  public int getRange() {
    return this.range;
  }

  public int getAbsVal() {
    return absVal;
  }

  private int generateAbsVal(Tone tone, int range) {
    int toneOrd = tone.ordinal();

    if (toneOrd >= 9) {
      toneOrd -= 9;
    }
    else {
      toneOrd += 3;
    }

    int generated = ((range - 1) * 12) + toneOrd;

    return generated;
  }

  public int compareTo(Pitch o) {
    if (this.absVal > o.getAbsVal()) {
      return 1;
    }
    else
      if (this.absVal < o.getAbsVal()) {
        return -1;
      }
      else {
        return 0;
      }
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pitch)) {
      return false;
    }

    Pitch pitch = (Pitch) o;
    if (pitch.getAbsVal() == this.absVal) {
      return true;
    }

    return false;
  }

  @Override
  public int hashCode() {
    int result = 19;
    result = 37 * result + this.absVal;

    return result;
  }


}
