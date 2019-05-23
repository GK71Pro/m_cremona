package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.experimental.FretboardCreator;
import com.gkaraffa.cremona.instrument.model.GuitarModel;
import com.gkaraffa.cremona.instrument.model.GuitarModelFactory;
import com.gkaraffa.cremona.instrument.model.InstrumentModelFactory;
import com.gkaraffa.cremona.quickaccess.QuickAccess;
import com.gkaraffa.cremona.theoretical.scale.DiatonicScale;

public class TestPlatform {

  public static void main(String[] args) {
    String key = "E";
    String scale = "Ionian";
    
    InstrumentModelFactory imf = new GuitarModelFactory();
    GuitarModel gM = (GuitarModel) imf.createInstrumentModel();
    QuickAccess qA = QuickAccess.getInstance();
    DiatonicScale diatonicScale = (DiatonicScale) qA.getScale(key, scale);
    String fb = FretboardCreator.createFormattedFretboardCSV(gM, diatonicScale.getToneCollection());
    System.out.println(fb);
  }

}
