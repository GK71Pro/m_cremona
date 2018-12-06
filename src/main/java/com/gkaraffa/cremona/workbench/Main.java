package com.gkaraffa.cremona.workbench;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.experimental.FretboardCreator;
import com.gkaraffa.cremona.instrument.model.GuitarModel;
import com.gkaraffa.cremona.instrument.model.GuitarModelFactory;
import com.gkaraffa.cremona.instrument.model.InstrumentModelFactory;
import com.gkaraffa.cremona.quickaccess.QuickAccess;
import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.analysis.IntervalAnalysisView;
import com.gkaraffa.cremona.theoretical.analysis.RomanNumeral;
import com.gkaraffa.cremona.theoretical.analysis.RomanNumeralAnalysisView;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.DiminishedScale;
import com.gkaraffa.cremona.theoretical.scale.DiminishedScaleFactory;
import com.gkaraffa.cremona.theoretical.scale.HarmonizableScale;
import com.gkaraffa.cremona.theoretical.scale.Scale;
import com.gkaraffa.cremona.theoretical.scale.ScaleFactory;

public class Main {

  public Main() {}

  public static void main(String[] args) {
    System.out.println("Process starts.");

    try {
      testRomanNumeral();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Process completes.");
  }
  
  private static void testRomanNumeral() throws IllegalArgumentException {
    QuickAccess qA = QuickAccess.getInstance();
    DiatonicScale diatonicScale = (DiatonicScale) qA.getScale("D#/Eb", "Ionian");
    
    RomanNumeralAnalysisView view = new RomanNumeralAnalysisView(diatonicScale);
    System.out.println(view);
    IntervalAnalysisView view2 = new IntervalAnalysisView(diatonicScale);
    System.out.println(view2.getText());
    
    /*
    for (int index = 0; index < 7; index++) {
      RomanNumeral romanNumeral = RomanNumeral.createRomanNumeral(diatonicScale, index);
      Tone tone = diatonicScale.getToneCollection().getTone(index);
      Interval interval = diatonicScale.getIntervalPattern().getIntervalByLocation(index);
      System.out.println(tone.getText() + "\t" + interval + "\t" + romanNumeral + "\t" + romanNumeral.getChord());      
    }
    */
  }

  @SuppressWarnings("unused")
  private static void testQuickAccess() throws IllegalArgumentException {
    QuickAccess qA = QuickAccess.getInstance();
    Scale scale = qA.getScale("C", "Pentatonic Minor");
    System.out.println(scale);
    scale = qA.getScale("D", "Dorian");
    System.out.println(scale);
    scale = qA.getScale("E", "Dorian");
    System.out.println(scale);
    scale = qA.getScale("D", "Dorian");
    System.out.println(scale);
  }

  @SuppressWarnings("unused")
  private static void testReflection() throws ClassNotFoundException {
    HashMap<String, ScalePair> hashMap = populateMap();
    Set<String> set = hashMap.keySet();
    String[] keyArray = set.toArray(new String[set.size()]);

    for (String key : keyArray) {
      System.out.println("key: " + key);
      ScalePair pair = hashMap.get(key);
      System.out.println(pair.className + ": " + pair.scaleField);
    }
  }

  @SuppressWarnings("unused")
  private static String scrubString(String subject) {
    String exclude = "_PATTERN";
    int exLocation = subject.indexOf(exclude);

    return subject.substring(0, exLocation);
  }

  @SuppressWarnings("unused")
  private static HashMap<String, ScalePair> populateMap() throws ClassNotFoundException {
    Main localMain = new Main();
    HashMap<String, ScalePair> hashMap = new HashMap<String, ScalePair>();
    String[] names = new String[4];

    names[0] = "com.gkaraffa.cremona.theoretical.scale.DiatonicScale";
    names[1] = "com.gkaraffa.cremona.theoretical.scale.DiminishedScale";
    names[2] = "com.gkaraffa.cremona.theoretical.scale.PentatonicScale";
    names[3] = "com.gkaraffa.cremona.theoretical.scale.WholeToneScale";

    for (String name : names) {
      Class<?> scaleClass = Class.forName(name);
      String canonicalName = scaleClass.getCanonicalName();
      Field[] fields = scaleClass.getFields();

      for (Field field : fields) {
        ScalePair scalePair = localMain.new ScalePair();

        scalePair.className = canonicalName;
        scalePair.scaleField = field.getName();
        String keyString = scrubString(scalePair.scaleField);

        hashMap.put(keyString, scalePair);
      }
    }

    return hashMap;
  }

  @SuppressWarnings("unused")
  private static List<ScalePair> populatePairs() throws ClassNotFoundException {
    Main localMain = new Main();
    ArrayList<ScalePair> scalePairs = new ArrayList<ScalePair>();
    String[] names = new String[4];

    names[0] = "com.gkaraffa.cremona.theoretical.scale.DiatonicScale";
    names[1] = "com.gkaraffa.cremona.theoretical.scale.DiminishedScale";
    names[2] = "com.gkaraffa.cremona.theoretical.scale.PentatonicScale";
    names[3] = "com.gkaraffa.cremona.theoretical.scale.WholeToneScale";

    for (String name : names) {
      Class<?> scaleClass = Class.forName(name);
      String canonicalName = scaleClass.getCanonicalName();
      Field[] fields = scaleClass.getFields();

      for (Field field : fields) {
        ScalePair scalePair = localMain.new ScalePair();

        scalePair.className = canonicalName;
        scalePair.scaleField = field.getName();

        scalePairs.add(scalePair);
      }
    }

    return scalePairs;
  }

  @SuppressWarnings("unused")
  private static void testGuitarModel() {
    ScaleFactory sF = new DiatonicScaleFactory();
    Scale scaleOne = sF.createScale(DiatonicScale.IONIAN_PATTERN, Tone.C);
    Scale scaleTwo = sF.createScale(DiatonicScale.IONIAN_PATTERN, Tone.DSHARP_EFLAT);

    InstrumentModelFactory iMF = new GuitarModelFactory();
    GuitarModel gM = (GuitarModel) iMF.createInstrumentModel();

    String fretBoard = FretboardCreator.createFormattedFretboard(gM,
        scaleOne.getToneCollection().union(scaleTwo.getToneCollection()));
    System.out.println(fretBoard);
  }

  @SuppressWarnings("unused")
  private static void testPitch() {
    Pitch pitch = new Pitch(Tone.C, 1);
    for (int index = 0; index <= 24; index++) {
      System.out.println(pitch);
      pitch = pitch.generatePitchByOffset(1);
    }
  }

  @SuppressWarnings("unused")
  private static void testScale() {
    ScaleFactory scaleFactory = new DiatonicScaleFactory();
    Scale scale = scaleFactory.createScale(DiatonicScale.AEOLIAN_PATTERN, Tone.CSHARP_DFLAT);
    System.out.println(scale.getToneCollection().getSpellingString());
    System.out.println(scale.getIntervalPattern().getSpellingString());;
  }

  @SuppressWarnings("unused")
  private static void testChord() {
    ChordFactory chordFactory = new ChordFactory();
    Chord chord =
        chordFactory.createChordFromIntervalPattern(Chord.MAJOR_SEVENTH_CHORD_PATTERN, Tone.C);
    System.out.println(chord.getIntervalPattern().getSpellingString());
    System.out.println(chord.getToneCollection().getSpellingString());
    System.out.println(chord.getChordNomenclature().getText());

    ScaleFactory scaleFactory = new DiminishedScaleFactory();
    Scale scale = scaleFactory.createScale(DiminishedScale.FIRST_DIMINISHED_PATTERN, Tone.C);
    chord = chordFactory.createChordFromHarmonizableScale((HarmonizableScale) scale,
        scale.getToneCollection().getTone(6), 4);
    System.out.println(chord.getIntervalPattern().getSpellingString());
    System.out.println(chord.getToneCollection().getSpellingString());
    System.out.println(chord.getChordNomenclature().getText());
  }

  class ScalePair {
    public String className = null;
    public String scaleField = null;
  }

}

