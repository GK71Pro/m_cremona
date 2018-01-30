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

  protected ToneCollection createToneCollection(IntervalPattern intervalPattern, Tone key) {
    int toneCount = intervalPattern.getSize();
    ToneCollectionBuilder toneCollectionBuilder = new ToneCollectionBuilder();

    toneCollectionBuilder.append(key);
    for (int index = 1; index <= toneCount; index++) {
      Tone cur = TonalSpectrum.traverseDistance(key,
          intervalPattern.getIntervalByLocation(index - 1).getHalfSteps());
      toneCollectionBuilder.append(cur);
    }

    return toneCollectionBuilder.toToneCollection();
  }

}
