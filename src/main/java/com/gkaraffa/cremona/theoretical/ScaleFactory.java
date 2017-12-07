package com.gkaraffa.cremona.theoretical;

public abstract class ScaleFactory {

  public ScaleFactory() {}

  abstract public Scale createScale(ScalarIntervalPattern scalarIntervalPattern, Tone key)
      throws IllegalArgumentException;

  abstract protected ScaleQuality evaluateScaleQuality(ScalarIntervalPattern scaleIntervalPattern);

  abstract protected boolean validateInputPattern(ScalarIntervalPattern scaleIntervalPattern);

  protected Tone[] createToneArray(ScalarIntervalPattern scalarIntervalPattern, Tone key) {
    int toneCount = scalarIntervalPattern.getSize();
    Tone[] tones = new Tone[toneCount];

    tones[0] = key;

    for (int index = 1; index < toneCount; index++) {
      Tone cur = TonalSpectrum.traverseDistance(tones[0],
          scalarIntervalPattern.getIntervalByLocation(index - 1).getHalfSteps());
      tones[index] = cur;
    }

    return tones;
  }

}
