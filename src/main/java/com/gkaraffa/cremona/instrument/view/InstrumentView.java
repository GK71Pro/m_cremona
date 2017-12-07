package com.gkaraffa.cremona.instrument.view;

import com.gkaraffa.cremona.common.PitchCollection;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class InstrumentView {

  public InstrumentView() {}

  public abstract String getTextView();

  public abstract String getTextView(ToneCollection toneCollection);
  
  public abstract String getTextView(PitchCollection pitchCollection);

  public abstract String getCSVView();

  public abstract String getCSVView(ToneCollection toneCollection);
  
  public abstract String getCSVView(PitchCollection pitchCollection);

  @Override
  public String toString() {
    return getTextView();
  }

}
