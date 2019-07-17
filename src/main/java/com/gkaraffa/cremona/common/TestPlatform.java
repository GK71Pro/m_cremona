package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.analysis.IntervalAnalytic;
import com.gkaraffa.cremona.analysis.TabularAnalytic;
import com.gkaraffa.cremona.analysis.TextView;
import com.gkaraffa.cremona.helper.Helper;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    Helper helper = Helper.getInstance();
    
    Scale scale = helper.getScale("C", "Ionian");
    TabularAnalytic tabularAnalytic = IntervalAnalytic.createIntervalAnalytic(scale);
    TextView textView = new TextView(tabularAnalytic);
    System.out.println(textView);
  }

}
