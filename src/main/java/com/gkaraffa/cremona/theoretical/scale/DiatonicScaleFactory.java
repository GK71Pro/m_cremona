package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class DiatonicScaleFactory extends ScaleFactory {

  public DiatonicScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!validateInputPattern(intervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return new DiatonicScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleQuality, intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByLocation(1);
    Interval fifthInterval = intervalPattern.getIntervalByLocation(3);
    ScaleQuality scaleQuality = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        if (fifthInterval == Interval.DIMINISHED_FIFTH) {
          scaleQuality = ScaleQuality.DIMINISHED;
        }
        else {
          scaleQuality = ScaleQuality.MINOR;
        }
        break;

      case MAJOR_THIRD:
        if (fifthInterval == Interval.AUGMENTED_FIFTH) {
          scaleQuality = ScaleQuality.AUGMENTED;
        }
        else {
          scaleQuality = ScaleQuality.MAJOR;
        }
        break;

      default:
        throw new IllegalArgumentException();
    }

    return scaleQuality;
  }

  @Override
  protected boolean validateInputPattern(IntervalPattern intervalPattern) {
    if (intervalPattern.getSize() != 7) {
      return false;
    }
    
    IntervalNumber intervalNumbers[] = IntervalNumber.values();
    for(int index = 1; index <= 7; index++) {
      if (intervalPattern.getIntervalByIntervalNumber(intervalNumbers[index]) == null) {
        return false;
      }
    }
    
    return true;
  }
}
