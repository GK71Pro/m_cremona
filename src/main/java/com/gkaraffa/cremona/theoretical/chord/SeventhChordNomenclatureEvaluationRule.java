package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;

public class SeventhChordNomenclatureEvaluationRule extends NomenclatureEvaluationRule {

  public SeventhChordNomenclatureEvaluationRule() {}

  @Override
  public ChordNomenclature applyRuleForIntervalPattern(IntervalPattern intervalPattern) {
    Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
    Interval fifthInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.FIFTH);
    Interval seventhInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.SEVENTH);

    if (thirdInterval == Interval.MAJOR_THIRD) {
      if (fifthInterval == Interval.PERFECT_FIFTH) {
        if (seventhInterval == Interval.MAJOR_SEVENTH) {
          return ChordNomenclature.MAJOR_SEVENTH;
        }
        else
          if (seventhInterval == Interval.MINOR_SEVENTH) {
            return ChordNomenclature.DOMINANT_SEVENTH;
          }
      }
      else
        if (fifthInterval == Interval.AUGMENTED_FIFTH) {
          if (seventhInterval == Interval.MAJOR_SEVENTH) {
            return ChordNomenclature.AUGMENTED_MAJOR_SEVENTH;
          }
        }
    }
    else
      if (thirdInterval == Interval.MINOR_THIRD) {
        if (fifthInterval == Interval.PERFECT_FIFTH) {
          if (seventhInterval == Interval.MINOR_SEVENTH) {
            return ChordNomenclature.MINOR_SEVENTH;
          }
          else
            if (seventhInterval == Interval.MAJOR_SEVENTH) {
              return ChordNomenclature.MINOR_MAJOR_SEVENTH;
            }
        }
        else
          if (fifthInterval == Interval.DIMINISHED_FIFTH) {
            if (seventhInterval == Interval.MINOR_SEVENTH) {
              return ChordNomenclature.HALF_DIMINISHED_SEVENTH;
            }
            else
              if (seventhInterval == Interval.DIMINISHED_SEVENTH) {
                return ChordNomenclature.DIMINISHED_SEVENTH;
              }
          }
      }

    throw new IllegalArgumentException();
  }
}
