package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.analysis.IntervalAnalytic;
import com.gkaraffa.cremona.analysis.RomanNumeralAnalytic;
import com.gkaraffa.cremona.analysis.TabularAnalytic;
import com.gkaraffa.cremona.analysis.TextViewFactory;
import com.gkaraffa.cremona.analysis.View;
import com.gkaraffa.cremona.analysis.ViewFactory;
import com.gkaraffa.cremona.helper.Helper;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    Helper helper = Helper.getInstance();
    Scale scale = helper.getScale("A", "Melodic Minor");
    TabularAnalytic tabularAnalytic = IntervalAnalytic.createIntervalAnalytic(scale);
    TabularAnalytic romanNumeralAnalytic = RomanNumeralAnalytic.createRomanNumeralAnalytic((DiatonicScale) scale);
    
    ViewFactory viewFactory = new TextViewFactory();
    View[] views = new View[2];
    views[0] = (View) viewFactory.renderView(tabularAnalytic);
    views[1] = (View) viewFactory.renderView(romanNumeralAnalytic);

    for(View view: views) {
      System.out.println(view);
    }
  }

}
