package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class PentatonicScaleFactory extends ScaleFactory {

  public PentatonicScaleFactory() {
    super();
  }

  @Override
  protected Scale getScale(Tone key, IntervalPattern intervalPattern, ToneCollection toneCollection,
      ScaleNomenclature scaleNomenclature) {
    return new PentatonicScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleNomenclature, intervalPattern);
  }

  @Override
  protected ScaleNomenclature evaluateScaleNomenclature(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
    ScaleNomenclature scaleNomenclature = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        scaleNomenclature = ScaleNomenclature.MINOR;
        break;

      case MAJOR_THIRD:
        scaleNomenclature = ScaleNomenclature.MAJOR;
        break;

      default:
        throw new IllegalArgumentException();
    }

    return scaleNomenclature;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 5) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH) == null) {
      return false;
    }

    if (intervalPattern.getIntervalByIntervalNumber(IntervalNumber.EIGHTH) == null) {
      return false;
    }

    return true;
  }
}
