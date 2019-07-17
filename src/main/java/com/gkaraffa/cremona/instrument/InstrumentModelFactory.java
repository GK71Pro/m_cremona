package com.gkaraffa.cremona.instrument;

public abstract class InstrumentModelFactory {

  public InstrumentModelFactory() {}

  public abstract InstrumentModel createInstrumentModel();

  public abstract InstrumentModel createInstrumentModel(InstrumentModelParameterObject iMPO);

}