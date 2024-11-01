package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.helper.ChordHelper;
import com.gkaraffa.cremona.helper.ScaleHelper;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    ScaleHelper scaleHelper = ScaleHelper.getInstance();
    ChordHelper chordHelper = ChordHelper.getInstance();

    Scale scale = scaleHelper.getScale("B","First Diminished");
    Chord chord = chordHelper.getChord("C","Major");

    System.out.println(scale.getToneCollection().getSpellingString());

    // Interval interval = Interval.MAJOR_SIXTH;
    int halfStep = 2;
    // ChordFactory chordFactory = new ChordFactory();
    // ScaleFactory scaleFactory = new DiatonicScaleFactory();

    // Chord chord = chordFactory.createChordFromIntervalPattern(Chord.MAJOR_CHORD_PATTERN, Tone.C);
    // Scale scale = scaleFactory.createScale(DiatonicScale.IONIAN_PATTERN, Tone.C);
    // Chord transChord = (Chord) chord.transposeUp(halfStep);
    // Chord tdChord = (Chord) chord.transposeDown(halfStep);

    Scale transScale = (Scale) scale.transposeUp(halfStep);
    Scale tdScale = (Scale) scale.transposeDown(halfStep);

    System.out.println(scale);
    System.out.println(transScale);
    System.out.println(tdScale);

    System.out.println(chord);


    /*
    int stepUp = interval.getHalfStepsFromTonic();
    int stepDown = TonalSpectrum.getInverseDistance(interval.getHalfStepsFromTonic());


    System.out.println("Up: " + stepUp);
    System.out.println("Down: " + stepDown);

    Tone base = Tone.C;
    Tone targetUp = TonalSpectrum.traverseDistance(base, stepUp);
    Tone targetDown = TonalSpectrum.traverseDistance(base, stepDown);

    System.out.println("Base: " + base);
    System.out.println("Tone up: " + targetUp);
    System.out.println("Tone down: " + targetDown);
    */
  }



/*
    public static void main(String[] args) {
    List<IntervalPattern> modePatternList = createLydianDominantModePatternList();
    ScaleFactory sFactory = new DiatonicScaleFactory();
    Tone key = Tone.C;
    List<Scale> parallelModeList = new ArrayList<Scale>(7);

    for(IntervalPattern iP: modePatternList) {
      parallelModeList.add(sFactory.createScale(iP, key));
    }

    for(Scale scale: parallelModeList) {
      System.out.println(scale.getLongName());
      System.out.println(scale.getToneCollection().getSpellingString());
    }

  }

  public static List<IntervalPattern> createLydianDominantModePatternList(){
    IntervalPattern basePattern = DiatonicScale.LYDIAN_DOMINANT_PATTERN;
    List<IntervalPattern> modeList = basePattern.deriveIntervalPatternListForModes();

    return modeList;
  }

 */

}
