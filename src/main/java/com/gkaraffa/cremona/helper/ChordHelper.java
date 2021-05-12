package com.gkaraffa.cremona.helper;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;

public class ChordHelper {
  private HashMap<String, ChordPair> chordPairMap = null;
  private HashMap<String, Chord> chordMap = new HashMap<String, Chord>();
  private static ChordHelper instance = null;

  private ChordHelper() {
    this.chordPairMap = this.populateChordPairs();
  }

  public static ChordHelper getInstance() {
    if (instance == null) {
      return new ChordHelper();
    }
    else {
      return instance;
    }
  }

  public Chord getChord(String keyString, String chordString) throws IllegalArgumentException {
    Tone keyTone = Tone.stringToTone(keyString);

    chordString = chordString.trim().toUpperCase().replace(' ', '_');

    // try cache lookup
    String lookupKey = keyTone.getText() + " " + chordString;
    Chord chord = searchChordMap(lookupKey);
    if (chord != null) {
      // return if found
      return chord;
    }

    // generate
    chord = generateChord(keyTone, chordString);

    // insert into cache Map
    storeChordInMap(chord);
    return chord;
  }

  private Chord searchChordMap(String chordKey) {
    Chord chord = chordMap.get(chordKey);

    return chord;
  } 

  private ChordFactory getChordFactory(ChordPair chordPair)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    String factoryString = chordPair.className + "Factory";
    Class<?> entityClass = Class.forName(factoryString);
    ChordFactory chordFactory = (ChordFactory) entityClass.newInstance();

    return chordFactory;
  }

  private IntervalPattern getIntervalPattern(ChordPair chordPair) throws ClassNotFoundException,
      InstantiationException, IllegalAccessException, NoSuchFieldException {
    Class<?> entityClass = Class.forName(chordPair.className);
    Field field = entityClass.getField(chordPair.chordField);
    IntervalPattern intervalPattern = (IntervalPattern) field.get(null);

    return intervalPattern;
  }

  private Chord generateChord(Tone keyTone, String chordString) throws IllegalArgumentException {
    ChordPair chordPair = chordPairMap.get(chordString);
    if (chordPair == null) {
      throw new IllegalArgumentException("Cannot map argument to chord");
    }

    ChordFactory chordFactory = null;
    IntervalPattern intervalPattern = null;
    try {
      chordFactory = getChordFactory(chordPair);
      intervalPattern = getIntervalPattern(chordPair);
    }
    catch (Exception e) {
      throw new IllegalArgumentException("Cannot map to a ScaleFactory or IntervalPattern");
    }

    Chord chord = chordFactory.createChordFromIntervalPattern(intervalPattern, keyTone);

    return chord;
  }

  private void storeChordInMap(Chord chord) {
    String keyValue = chord.getLongName().trim().toUpperCase();
    chordMap.put(keyValue, chord);
  }



  private String scrubString(String subject) {
    String exclude = "_CHORD_PATTERN";
    int exLocation = subject.indexOf(exclude);

    return subject.substring(0, exLocation);
  }

  private HashMap<String, ChordPair> populateChordPairs() {
    HashMap<String, ChordPair> hashMap = new HashMap<String, ChordPair>();
    Class<?> chordClass = Chord.class;
    Field[] fields = chordClass.getFields();

    for (Field field : fields) {
      ChordPair chordPair = new ChordPair();

      chordPair.className = chordClass.getCanonicalName();
      chordPair.chordField = field.getName();
      String keyString = scrubString(chordPair.chordField);

      hashMap.put(keyString, chordPair);
    }

    return hashMap;
  }


  class ChordPair {
    public String className = null;
    public String chordField = null;
  }
}
