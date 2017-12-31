package com.gkaraffa.cremona.theoretical;

public abstract class ScaleFactory {

  public ScaleFactory() {}

  abstract public Scale createScale(IntervalPattern intervalPattern, Tone key)
      throws IllegalArgumentException;

  abstract protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern);

  abstract protected boolean validateInputPattern(IntervalPattern intervalPattern);

  protected Tone[] createToneArray(IntervalPattern intervalPattern, Tone key) {
    int toneCount = intervalPattern.getSize();
    Tone[] tones = new Tone[toneCount];

    tones[0] = key;

    for (int index = 1; index < toneCount; index++) {
      Tone cur = TonalSpectrum.traverseDistance(tones[0],
          intervalPattern.getIntervalByLocation(index - 1).getHalfSteps());
      tones[index] = cur;
    }

    return tones;
  }

}
