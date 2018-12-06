package com.gkaraffa.cremona.theoretical.analysis;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class IntervalAnalysisView implements AnalysisView {
  private Scale scale = null;
  
  public IntervalAnalysisView() {}
  
  public IntervalAnalysisView(Scale scale) {
    this.scale = scale;
  }

  @Override
  public String getText() {
    StringBuffer sB = new StringBuffer();
    int maxOffset = scale.getToneCollection().getSize() - 1;

    
    for(int index = 0; index <= maxOffset; index++) {
      Interval interval = scale.getIntervalPattern().getIntervalByLocation(index);
      IntervalNumber intervalNumber = interval.getIntervalNumber();

      sB.append(String.format("%-3.3s", intervalNumber.getAbbrev()));
      sB.append("\t");
      sB.append(String.format("%-15.15s", intervalNumber.getDiatonicFunction()));
      sB.append("\t");
      sB.append(String.format("%-20.20s", interval.getText()));
      sB.append("\t");
      sB.append(String.format("%-5.5s", scale.getToneCollection().getTone(index)));
      sB.append("\n");
    }
    
    return sB.toString();
  }

  @Override
  public String getCSV() {
    StringBuffer sB = new StringBuffer();
    int maxOffset = scale.getToneCollection().getSize() - 1;

    
    for(int index = 0; index <= maxOffset; index++) {
      Interval interval = scale.getIntervalPattern().getIntervalByLocation(index);
      IntervalNumber intervalNumber = interval.getIntervalNumber();

      sB.append(intervalNumber.getAbbrev());
      sB.append(",");
      sB.append(intervalNumber.getDiatonicFunction());
      sB.append(",");
      sB.append(interval.getText());
      sB.append(",");
      sB.append(scale.getToneCollection().getTone(index));
      sB.append(",");
    }
    
    return sB.toString();
  }
  
  @Override
  public String toString() {
    return getText();
  }

}
