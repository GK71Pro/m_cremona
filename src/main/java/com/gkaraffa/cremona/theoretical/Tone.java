package com.gkaraffa.cremona.theoretical;

import java.util.HashMap;

/**
 * Enumeration of tones from the 12-tone western chromatic scale.
 * 
 * @author Gabriel Karaffa
 */

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
  private final static HashMap<String, Tone> hashMap = new HashMap<>();

  static {
    for (Tone tone : Tone.values()) {
      hashMap.put(tone.text, tone);
    }
  }

  /**
   * Converts a properly formatted string to a Tone
   * 
   * @param toneString
   * @return tone
   * @throws IllegalArgumentException
   */
  public static final Tone stringToTone(String toneString) throws IllegalArgumentException {
    Tone tone = hashMap.get(toneString.trim());
    // Tone tone = hashMap.get(toneString.trim().toUpperCase());

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
