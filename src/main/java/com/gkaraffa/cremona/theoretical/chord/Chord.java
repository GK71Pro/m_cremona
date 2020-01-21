package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.ToneGroupObject;

public class Chord extends ToneGroupObject {
  private Tone tonic;
  private ChordNomenclature chordNomenclature;
  private IntervalPattern intervalPattern;
  // private ToneCollection toneCollection;
  private HarmonicPreference harmonicPreference;

  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    MAJOR_CHORD_PATTERN = iPF.createIntervalPattern("Major", "P1,M3,P5");
    MINOR_CHORD_PATTERN = iPF.createIntervalPattern("Minor", "P1,m3,P5");
    DIMINISHED_CHORD_PATTERN = iPF.createIntervalPattern("Diminished", "P1,m3,d5");
    AUGMENTED_CHORD_PATTERN = iPF.createIntervalPattern("Augmented", "P1,M3,A5");
    MAJOR_SEVENTH_CHORD_PATTERN = iPF.createIntervalPattern("Major Seventh", "P1,M3,P5,M7");
    DOMINANT_SEVENTH_CHORD_PATTERN = iPF.createIntervalPattern("Dominant Seventh", "P1,M3,P5,m7");
    MINOR_SEVENTH_CHORD_PATTERN = iPF.createIntervalPattern("Minor Seventh", "P1,m3,P5,m7");
    MINORMAJOR_SEVENTH_CHORD_PATTERN =
        iPF.createIntervalPattern("Minor-Major Seventh", "P1,m3,P5,M7");
    HALF_DIMINISHED_SEVENTH_CHORD_PATTERN =
        iPF.createIntervalPattern("Half-Diminished Seventh", "P1,m3,d5,m7");
    DIMINISHED_SEVENTH_CHORD_PATTERN =
        iPF.createIntervalPattern("Diminished Seventh", "P1,m3,d5,d7");
    AUGMENTED_MAJOR_SEVENTH_CHORD_PATTERN =
        iPF.createIntervalPattern("Augmented-Major Seventh", "P1,M3,A5,M7");
  }

  public Chord(String name, ToneCollection toneCollection, ChordNomenclature chordNomenclature,
      IntervalPattern intervalPattern, HarmonicPreference harmonicPreference) {
    super(name);
    this.tonic = toneCollection.getTone(0);
    this.toneCollection = toneCollection;
    this.chordNomenclature = chordNomenclature;
    this.intervalPattern = intervalPattern;
    this.harmonicPreference = harmonicPreference;
  }

  public Tone getTonic() {
    return tonic;
  }

  public ChordNomenclature getChordNomenclature() {
    return chordNomenclature;
  }

  public IntervalPattern getIntervalPattern() {
    return intervalPattern;
  }

  @Override
  public ToneCollection getToneCollection() {
    return toneCollection;
  }

  public HarmonicPreference getHarmonicPreference() {
    return harmonicPreference;
  }

  @Override
  public boolean contentsEqual(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  public static IntervalPattern MAJOR_CHORD_PATTERN;
  public static IntervalPattern MINOR_CHORD_PATTERN;
  public static IntervalPattern DIMINISHED_CHORD_PATTERN;
  public static IntervalPattern AUGMENTED_CHORD_PATTERN;
  public static IntervalPattern MAJOR_SEVENTH_CHORD_PATTERN;
  public static IntervalPattern DOMINANT_SEVENTH_CHORD_PATTERN;
  public static IntervalPattern MINOR_SEVENTH_CHORD_PATTERN;
  public static IntervalPattern MINORMAJOR_SEVENTH_CHORD_PATTERN;
  public static IntervalPattern HALF_DIMINISHED_SEVENTH_CHORD_PATTERN;
  public static IntervalPattern DIMINISHED_SEVENTH_CHORD_PATTERN;
  public static IntervalPattern AUGMENTED_MAJOR_SEVENTH_CHORD_PATTERN;

}
