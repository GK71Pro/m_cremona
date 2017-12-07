package com.gkaraffa.cremona.theoretical;

import java.util.LinkedHashSet;

public class Chord extends ToneCollection {
  private HarmonicPreference harmonicPreference;
  private ChordQuality chordQuality;
  private LinkedHashSet<IntervalNumber> intervalNumberSet;

  public Chord(String name, Tone[] tones, ChordQuality chordQuality,
      LinkedHashSet<IntervalNumber> intervalNumberSet) {
    super(name, tones);
    this.chordQuality = chordQuality;
    this.intervalNumberSet = intervalNumberSet;
  }


  public HarmonicPreference getHarmonicPreference() {
    return harmonicPreference;
  }


  public final ChordQuality chordQuality() {
    return chordQuality;
  }

  public final LinkedHashSet<IntervalNumber> getIntervalNumberSet() {
    return intervalNumberSet;
  }

  /*
  public final Tone getToneByIntervalNumber(IntervalNumber intervalNumber) throws CremonaException{
    if (intervalNumberSet.contains(intervalNumber)) {
      
    }
    else {
      throw new CremonaException ("IntervalNumber does not exist in this Chord.");
    }
  }
  */

}
