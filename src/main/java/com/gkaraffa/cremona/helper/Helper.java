package com.gkaraffa.cremona.helper;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.scale.Scale;
import com.gkaraffa.cremona.theoretical.scale.ScaleFactory;

public class Helper {
  private HashMap<String, ScalePair> pairMap = null;
  private HashMap<String, Scale> scaleMap = new HashMap<String, Scale>();
  private static Helper instance = null;


  private Helper() {
    this.pairMap = populatePairs();
  }


  public static Helper getInstance() {
    if (instance == null) {
      return new Helper();
    }
    else {
      return instance;
    }
  }

  public Scale getScale(String keyString, String scaleString) throws IllegalArgumentException {
    Tone keyTone = keyStringToTone(keyString);

    scaleString = scaleString.trim().toUpperCase().replace(' ', '_');

    // try cache lookup
    String lookupKey = keyTone.getText() + " " + scaleString;
    Scale scale = searchScaleMap(lookupKey);
    if (scale != null) {
      // return if found
      return scale;
    }

    // generate
    scale = generateScale(keyTone, scaleString);

    // insert into cache Map
    storeScaleInMap(scale);
    return scale;
  }


  private Scale generateScale(Tone keyTone, String scaleString) throws IllegalArgumentException {
    ScalePair scalePair = pairMap.get(scaleString);
    if (scalePair == null) {
      throw new IllegalArgumentException("Cannot map argument to scale");
    }

    ScaleFactory scaleFactory = null;
    IntervalPattern intervalPattern = null;
    try {
      scaleFactory = getScaleFactory(scalePair);
      intervalPattern = getIntervalPattern(scalePair);
    }
    catch (Exception e) {
      throw new IllegalArgumentException("Cannot map to a ScaleFactory or IntervalPattern");
    }

    Scale scale = scaleFactory.createScale(intervalPattern, keyTone);

    return scale;
  }

  private Scale searchScaleMap(String scaleKey) {
    Scale scale = scaleMap.get(scaleKey);
    return scale;
  }


  private void storeScaleInMap(Scale scale) {
    String keyValue = scale.getText().trim().toUpperCase();
    scaleMap.put(keyValue, scale);
  }


  private Tone keyStringToTone(String keyString) throws IllegalArgumentException {
    // keyString = keyString.trim().toUpperCase();
    Tone keyTone = Tone.stringToTone(keyString);

    return keyTone;
  }

  private IntervalPattern getIntervalPattern(ScalePair scalePair) throws ClassNotFoundException,
      InstantiationException, IllegalAccessException, NoSuchFieldException {
    Class<?> entityClass = Class.forName(scalePair.className);
    Field field = entityClass.getField(scalePair.scaleField);
    IntervalPattern intervalPattern = (IntervalPattern) field.get(null);

    return intervalPattern;
  }

  private ScaleFactory getScaleFactory(ScalePair scalePair)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    String factoryString = scalePair.className + "Factory";
    Class<?> entityClass = Class.forName(factoryString);
    ScaleFactory scaleFactory = (ScaleFactory) entityClass.newInstance();

    return scaleFactory;
  }

  private String scrubString(String subject) {
    String exclude = "_PATTERN";
    int exLocation = subject.indexOf(exclude);

    return subject.substring(0, exLocation);
  }

  private HashMap<String, ScalePair> populatePairs() {
    HashMap<String, ScalePair> hashMap = new HashMap<String, ScalePair>();
    String[] names = new String[] {
        "com.gkaraffa.cremona.theoretical.scale.DiatonicScale",
        "com.gkaraffa.cremona.theoretical.scale.DiminishedScale",
        "com.gkaraffa.cremona.theoretical.scale.PentatonicScal",
        "com.gkaraffa.cremona.theoretical.scale.WholeToneScale"
    };

    for (String name : names) {
      Class<?> scaleClass;
      
      try {
        scaleClass = Class.forName(name);
      }
      catch (ClassNotFoundException cNFE) {
        continue;
      }

      Field[] fields = scaleClass.getFields();
      for (Field field : fields) {
        ScalePair scalePair = new ScalePair();

        scalePair.className = scaleClass.getCanonicalName();
        scalePair.scaleField = field.getName();
        String keyString = scrubString(scalePair.scaleField);

        hashMap.put(keyString, scalePair);
      }
    }

    return hashMap;
  }


  class ScalePair {
    public String className = null;
    public String scaleField = null;
  }
}
