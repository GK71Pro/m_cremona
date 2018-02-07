package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.ToneCollectionBuilder;

public abstract class ScaleFactory {

  public ScaleFactory() {}

  protected abstract Scale getScale(Tone key, IntervalPattern intervalPattern,
      ToneCollection toneCollection, ScaleQuality scaleQuality);

  protected abstract ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern);

  protected abstract boolean validateInputPattern(IntervalPattern intervalPattern);

  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!validateInputPattern(intervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return getScale(key, intervalPattern, toneCollection, scaleQuality);
  }

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
