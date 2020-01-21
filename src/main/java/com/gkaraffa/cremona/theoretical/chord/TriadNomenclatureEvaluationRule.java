package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;

public class TriadNomenclatureEvaluationRule extends NomenclatureEvaluationRule {

  public TriadNomenclatureEvaluationRule() {}

  @Override
  public ChordNomenclature applyRuleForIntervalPattern(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
    Interval fifthInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH);

    if (thirdInterval == Interval.MAJOR_THIRD) {
      if (fifthInterval == Interval.PERFECT_FIFTH) {
        return ChordNomenclature.MAJOR;
      }
      else
        if (fifthInterval == Interval.AUGMENTED_FIFTH) {
          return ChordNomenclature.AUGMENTED;
        }
    }
    else
      if (thirdInterval == Interval.MINOR_THIRD) {
        if (fifthInterval == Interval.PERFECT_FIFTH) {
          return ChordNomenclature.MINOR;
        }
        else
          if (fifthInterval == Interval.DIMINISHED_FIFTH) {
            return ChordNomenclature.DIMINISHED;
          }
      }

    throw new IllegalArgumentException();
  }
}
