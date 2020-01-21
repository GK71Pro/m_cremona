package com.gkaraffa.cremona.theoretical;

import java.util.HashMap;

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
  private final static HashMap<String, Tone> hashMap = new HashMap<String, Tone>();

  static {
    for (Tone tone : Tone.values()) {
      hashMap.put(tone.text, tone);
    }
  }

  public static final Tone stringToTone(String toneString) throws IllegalArgumentException {
    Tone tone = hashMap.get(toneString);

    if (tone == null) {
      throw new IllegalArgumentException("toneString <" + toneString + "> does not map to a Tone");
    }

    return tone;
  }


  Tone(String text) {
    this.text = text;
  }

  public final String getText() {
    return text;
  }

  @Override
  public final String toString() {
    return text;
  }

}
