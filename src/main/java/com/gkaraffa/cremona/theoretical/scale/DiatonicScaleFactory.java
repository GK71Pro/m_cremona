package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiatonicScaleFactory extends ScaleFactory {

  public DiatonicScaleFactory() {
    super();
  }

  @Override
  protected Scale getScale(Tone key, IntervalPattern intervalPattern, ToneCollection toneCollection,
      ScaleNomenclature scaleNomenclature) {
    return new DiatonicScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleNomenclature, intervalPattern);
  }

  @Override
  protected ScaleNomenclature evaluateScaleNomenclature(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByLocation(2);
    Interval fifthInterval = intervalPattern.getIntervalByLocation(4);
    ScaleNomenclature scaleNomenclature = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        if (fifthInterval == Interval.DIMINISHED_FIFTH) {
          scaleNomenclature = ScaleNomenclature.DIMINISHED;
        }
        else {
          scaleNomenclature = ScaleNomenclature.MINOR;
        }
        break;

      case MAJOR_THIRD:
        if (fifthInterval == Interval.AUGMENTED_FIFTH) {
          scaleNomenclature = ScaleNomenclature.AUGMENTED;
        }
        else {
          scaleNomenclature = ScaleNomenclature.MAJOR;
        }
        break;

      default:
        throw new IllegalArgumentException();
    }

    return scaleNomenclature;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 7) {
      return false;
    }

    IntervalNumber intervalNumbers[] = IntervalNumber.values();
    for (int index = 1; index < 7; index++) {
      if (intervalPattern.getIntervalByIntervalNumber(intervalNumbers[index]) == null) {
        return false;
      }
    }

    return true;
  }
}
