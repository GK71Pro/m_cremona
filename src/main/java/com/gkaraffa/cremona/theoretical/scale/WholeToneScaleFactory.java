package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class WholeToneScaleFactory extends ScaleFactory {

  public WholeToneScaleFactory() {
    super();
  }

  @Override
  protected Scale getScale(Tone key, IntervalPattern intervalPattern, ToneCollection toneCollection,
      ScaleNomenclature scaleNomenclature) {
    return new WholeToneScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleNomenclature, intervalPattern);
  }

  @Override
  protected ScaleNomenclature evaluateScaleNomenclature(IntervalPattern intervalPattern) {
    return ScaleNomenclature.WHOLE_TONE;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    Interval thirdInterval;
    Interval fifthInterval;

    if (((thirdInterval =
        intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD)) == null)
        || (thirdInterval != Interval.MAJOR_THIRD)) {
      return false;
    }

    if (((fifthInterval =
        intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH)) == null)
        || (fifthInterval != Interval.AUGMENTED_FIFTH)) {
      return false;
    }
    
    return true;
  }
}
