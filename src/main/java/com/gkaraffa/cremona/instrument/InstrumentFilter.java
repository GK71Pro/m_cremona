package com.gkaraffa.cremona.instrument;

public interface InstrumentFilter {
  public InstrumentView filterByTone(InstrumentModel instrumentModel);
  public InstrumentView filterByPitch(InstrumentModel instrumentModel);
}
