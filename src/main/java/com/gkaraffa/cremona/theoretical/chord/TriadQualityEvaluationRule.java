package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;

public class TriadQualityEvaluationRule extends QualityEvaluationRule {

  public TriadQualityEvaluationRule() {}

  @Override
  public ChordQuality applyRuleForIntervalPattern(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
    Interval fifthInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH);

    if (thirdInterval == Interval.MAJOR_THIRD) {
      if (fifthInterval == Interval.PERFECT_FIFTH) {
        return ChordQuality.MAJOR;
      }
      else if (fifthInterval == Interval.AUGMENTED_FIFTH) {
        return ChordQuality.AUGMENTED;
      }
    }
    else if (thirdInterval == Interval.MINOR_THIRD) {
      if (fifthInterval == Interval.PERFECT_FIFTH) {
        return ChordQuality.MINOR;
      }
      else if (fifthInterval == Interval.DIMINISHED_FIFTH) {
        return ChordQuality.DIMINISHED;
      }
    }

    throw new IllegalArgumentException();
  }
}
