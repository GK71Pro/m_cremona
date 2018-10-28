package com.gkaraffa.cremona.quickaccess;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.scale.Scale;
import com.gkaraffa.cremona.theoretical.scale.ScaleFactory;

public class QuickAccess {
  private static HashMap<String, ScalePair> hashMap;
  private static QuickAccess local;

  static {
    local = new QuickAccess();
    hashMap = populatePairs();
  }


  public static Scale getScale(String keyString, String scaleString)
      throws IllegalArgumentException {
    keyString = keyString.trim().toUpperCase();
    scaleString = scaleString.trim().toUpperCase().replace(' ', '_');

    // conversion
    Tone keyTone = Tone.stringToTone(keyString);

    ScalePair scalePair = hashMap.get(scaleString);
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

    // generation
    Scale scale = scaleFactory.createScale(intervalPattern, keyTone);

    return scale;
  }

  private static IntervalPattern getIntervalPattern(ScalePair scalePair)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
      NoSuchFieldException {
    Class<?> entityClass = Class.forName(scalePair.className);
    Field field = entityClass.getField(scalePair.scaleField);
    IntervalPattern intervalPattern = (IntervalPattern) field.get(null);

    return intervalPattern;

  }

  private static ScaleFactory getScaleFactory(ScalePair scalePair)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    String factoryString = scalePair.className + "Factory";
    Class<?> entityClass = Class.forName(factoryString);
    ScaleFactory scaleFactory = (ScaleFactory) entityClass.newInstance();

    return scaleFactory;
  }

  private static String scrubString(String subject) {
    String exclude = "_PATTERN";
    int exLocation = subject.indexOf(exclude);

    return subject.substring(0, exLocation);
  }

  private static HashMap<String, ScalePair> populatePairs() {
    HashMap<String, ScalePair> hashMap = new HashMap<String, ScalePair>();
    String[] names = new String[4];

    names[0] = "com.gkaraffa.cremona.theoretical.scale.DiatonicScale";
    names[1] = "com.gkaraffa.cremona.theoretical.scale.DiminishedScale";
    names[2] = "com.gkaraffa.cremona.theoretical.scale.PentatonicScale";
    names[3] = "com.gkaraffa.cremona.theoretical.scale.WholeToneScale";

    for (String name : names) {
      Class<?> scaleClass;
      try {
        scaleClass = Class.forName(name);
      }
      catch (ClassNotFoundException cNFE) {
        continue;
      }

      String canonicalName = scaleClass.getCanonicalName();
      Field[] fields = scaleClass.getFields();

      for (Field field : fields) {
        ScalePair scalePair = local.new ScalePair();

        scalePair.className = canonicalName;
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
