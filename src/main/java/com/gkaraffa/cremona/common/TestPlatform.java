package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.analysis.IntervalAnalytic;
import com.gkaraffa.cremona.analysis.RomanNumeralAnalytic;
import com.gkaraffa.cremona.analysis.TabularAnalytic;
import com.gkaraffa.cremona.analysis.TextView;
import com.gkaraffa.cremona.analysis.TextViewFactory;
import com.gkaraffa.cremona.analysis.ViewFactory;
import com.gkaraffa.cremona.helper.Helper;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    Helper helper = Helper.getInstance();
    Scale scale = helper.getScale("C", "Ionian");
    TabularAnalytic tabularAnalytic = IntervalAnalytic.createIntervalAnalytic(scale);
    TabularAnalytic romanNumeralAnalytic = RomanNumeralAnalytic.createRomanNumeralAnalytic((DiatonicScale) scale);
    
    ViewFactory viewFactory = new TextViewFactory();
    TextView[] textViews = new TextView[2];
    textViews[0] = (TextView) viewFactory.renderView(tabularAnalytic);
    textViews[1] = (TextView) viewFactory.renderView(romanNumeralAnalytic);

    for(TextView textView: textViews) {
      System.out.println(textView);
    }
  }

}
