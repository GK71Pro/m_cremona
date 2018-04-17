package com.gkaraffa.cremona.theoretical.chord;

import com.gkaraffa.cremona.theoretical.IntervalPattern;

abstract class NomenclatureEvaluationRule {

  public NomenclatureEvaluationRule() {}
  
  public abstract ChordNomenclature applyRuleForIntervalPattern(IntervalPattern intervalPattern);

}
