package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.ToneCollectionBuilder;

public abstract class ScaleFactory {

  public ScaleFactory() {}

  abstract public Scale createScale(IntervalPattern intervalPattern, Tone key);

  abstract protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern);

  abstract protected boolean validateInputPattern(IntervalPattern intervalPattern);

  //TO REMOVE
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
  
  protected ToneCollection createToneCollection(IntervalPattern intervalPattern, Tone key) {
    int toneCount = intervalPattern.getSize();
    ToneCollectionBuilder toneCollectionBuilder = new ToneCollectionBuilder();

    toneCollectionBuilder.insert(key);
    for(int index = 1; index < toneCount; index++) {
      Tone cur = TonalSpectrum.traverseDistance(key,
          intervalPattern.getIntervalByLocation(index - 1).getHalfSteps());
      toneCollectionBuilder.insert(cur);
    }
    
    return toneCollectionBuilder.toToneCollection();
  }

}
