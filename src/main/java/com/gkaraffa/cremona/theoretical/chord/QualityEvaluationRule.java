package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.IntervalPattern;

abstract class QualityEvaluationRule {

  public QualityEvaluationRule() {}
  
  public abstract ChordQuality applyRuleForIntervalPattern(IntervalPattern intervalPattern);

}
