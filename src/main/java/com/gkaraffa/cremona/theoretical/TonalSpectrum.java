package com.gkaraffa.cremona.theoretical;

/**
 * Representation of 12-tone western chromatic scale
 * 
 * @author Gabriel Karaffa
 */
public class TonalSpectrum {
  public static final int octave = 12;
  public static final int upperLimit = octave - 1;
  public static Tone[] tones = new Tone[octave];

  static {
    tones[0] = Tone.C;
    tones[1] = Tone.CSHARP_DFLAT;
    tones[2] = Tone.D;
    tones[3] = Tone.DSHARP_EFLAT;
    tones[4] = Tone.E;
    tones[5] = Tone.F;
    tones[6] = Tone.FSHARP_GFLAT;
    tones[7] = Tone.G;
    tones[8] = Tone.GSHARP_AFLAT;
    tones[9] = Tone.A;
    tones[10] = Tone.ASHARP_BFLAT;
    tones[11] = Tone.B;
  }

  private static Tone getNote(int location) throws IllegalArgumentException {
    if ((location > upperLimit) || (location < 0)) {
      throw new IllegalArgumentException();
    }
    else {
      return tones[location];
    }
  }

  private static int locateNote(Tone target) {
    int index;

    for (index = 0; index <= upperLimit; index++) {
      if (tones[index].equals(target)) {
        break;
      }
    }
    return index;
  }

  /**
   * 
   * @param startTone
   * @param stopTone
   * @return distance between tones in half-steps
   */
  public static int measureDistance(Tone startTone, Tone stopTone) {
    int startLoc = locateNote(startTone);
    int stopLoc = locateNote(stopTone);

    if (stopLoc < startLoc) {
      stopLoc += octave;
    }

    return (stopLoc - startLoc);
  }

  /**
   * 
   * @param tonic
   * @param distance
   * @return Tone at (distance) half-steps from (tonic)
   */
  public static Tone traverseDistance(Tone tonic, int distance) {
    int location = locateNote(tonic);

    location += distance;

    while (location > upperLimit) {
      location -= octave;
    }

    return getNote(location);
  }

  /**
   * 
   * @param tonic
   * @param distance
   * @return Tone at (distance) half-steps from (tonic) in reverse
   */
  public static Tone reverseDistance(Tone tonic, int distance) {
    int location = locateNote(tonic);
    int invertDistance = 12 - distance;

    location += invertDistance;

    while (location > upperLimit) {
      location -= octave;
    }

    return getNote(location);
  }

  /**
   * 
   * @param tonic
   * @param interval
   * @return Tone at (interval) from (tonic)
   */
  public static Tone traverseInterval(Tone tonic, Interval interval) {
    return traverseDistance(tonic, interval.getHalfStepsFromTonic());
  }

  /**
   * 
   * @param tonic
   * @param interval
   * @return Tone at (interval) from (tonic) in reverse
   */
  public static Tone reverseInterval(Tone tonic, Interval interval) {
    return traverseDistance(tonic, 12 - interval.getHalfStepsFromTonic());
  }

}
