package com.gkaraffa.cremona.theoretical.analysis;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class RomanNumeral {
  private Interval interval;
  private Chord chord;
  private String text;


  public RomanNumeral(Interval interval, Chord chord, String text) {
    this.interval = interval;
    this.chord = chord;
    this.text = text;
  }

  public Interval getInterval() {
    return interval;
  }

  public Chord getChord() {
    return chord;
  }

  public String getText() {
    return text;
  }
  
  @Override
  public String toString() {
    return text;
  }

  public static RomanNumeral createRomanNumeral(DiatonicScale diatonicScale, int position) {
    // get interval
    Interval interval = diatonicScale.getIntervalPattern().getIntervalByLocation(position);

    // get chordNomenclature
    // create chord
    ChordFactory chordFactory = new ChordFactory();
    Chord chord = chordFactory.createChordFromHarmonizableScale(diatonicScale,
        diatonicScale.getToneCollection().getTone(position), 3);

    String text = evaluate(interval, chord);

    return new RomanNumeral(interval, chord, text);

  }

  private static String evaluate(Interval interval, Chord chord)
      throws IllegalArgumentException {
    String raw = null;

    switch (interval.getIntervalNumber()) {
      case FIRST:
        raw = "I";
        break;
      case SECOND:
        raw = "II";
        break;
      case THIRD:
        raw = "III";
        break;
      case FOURTH:
        raw = "IV";
        break;
      case FIFTH:
        raw = "V";
        break;
      case SIXTH:
        raw = "VI";
        break;
      case SEVENTH:
        raw = "VII";
        break;
      default:
        throw new IllegalArgumentException("Inapplicable IntervalNumber");
    }

    switch (chord.getChordNomenclature()) {
      case MAJOR:
        return raw;
      case MINOR:
        return raw.toLowerCase();
      case DIMINISHED:
        return raw.toLowerCase() + "°";
      case AUGMENTED:
        return raw + "+";
      default:
        throw new IllegalArgumentException("Inapplicable ChordNomenclature");
    }
  }

}
