package com.gkaraffa.cremona.theoretical;

public enum Tone {
  C("C"),
  CSHARP_DFLAT("C#/Db"),
  D("D"),
  DSHARP_EFLAT("D#/Eb"),
  E("E"),
  F("F"),
  FSHARP_GFLAT("F#/Gb"),
  G("G"),
  GSHARP_AFLAT("G#/Ab"),
  A("A"),
  ASHARP_BFLAT("A#/Bb"),
  B("B");

private final String text;

Tone(String text) {
  this.text = text;
}

public final String getText() {
  return text;
}

public final String toString() {
  return text;
}


}
