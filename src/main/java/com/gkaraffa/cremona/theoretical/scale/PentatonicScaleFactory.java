package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.IntervalPatternFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class PentatonicScaleFactory extends ScaleFactory {

  static {
    IntervalPatternFactory iPF = IntervalPatternFactory.getInstance();

    PENTATONIC_MAJOR_PATTERN = iPF.createIntervalPattern("Pentatonic Major", "P1,M2,M3,P5,M6,P8");
    PENTATONIC_MINOR_PATTERN = iPF.createIntervalPattern("Pentatonic Minor", "P1,m3,P4,P5,m7,P8");
  }

  public PentatonicScaleFactory() {}

  @Override
  public Scale createScale(IntervalPattern intervalPattern, Tone key) {
    if (!validateInputPattern(intervalPattern)) {
      throw new IllegalArgumentException("Input pattern is invalid.");
    }

    ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
    ToneCollection toneCollection = this.createToneCollection(intervalPattern, key);

    return new PentatonicScale(key.getText() + " " + intervalPattern.getText(), toneCollection,
        scaleQuality, intervalPattern);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
    ScaleQuality scaleQuality = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        scaleQuality = ScaleQuality.MINOR;
        break;

      case MAJOR_THIRD:
        scaleQuality = ScaleQuality.MAJOR;
        break;

      default:
        throw new IllegalArgumentException();
    }

    return scaleQuality;
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

  public static IntervalPattern PENTATONIC_MAJOR_PATTERN;
  public static IntervalPattern PENTATONIC_MINOR_PATTERN;
}
