package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.TheoreticalObject;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class Chord extends TheoreticalObject {
  private Tone tonic;
  private ChordQuality chordQuality;
  private IntervalPattern intervalPattern;
  private ToneCollection toneCollection;
  private HarmonicPreference harmonicPreference;

  public Chord(String name, ToneCollection toneCollection, ChordQuality chordQuality,
      IntervalPattern intervalPattern, HarmonicPreference harmonicPreference) {
    super(name);
    this.tonic = toneCollection.getTone(0);
    this.toneCollection = toneCollection;
    this.chordQuality = chordQuality;
    this.intervalPattern = intervalPattern;
    this.harmonicPreference = harmonicPreference;
  }

  public Tone getTonic() {
    return tonic;
  }

  public ChordQuality getChordQuality() {
    return chordQuality;
  }

  public IntervalPattern getIntervalPattern() {
    return intervalPattern;
  }

  public ToneCollection getToneCollection() {
    return toneCollection;
  }

  public HarmonicPreference getHarmonicPreference() {
    return harmonicPreference;
  }
}
