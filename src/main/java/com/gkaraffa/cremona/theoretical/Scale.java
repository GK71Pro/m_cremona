package com.gkaraffa.cremona.theoretical;

public abstract class Scale extends ToneCollection {
  private ScaleQuality scaleQuality;
  private Tone key;

  public Scale(String name, Tone[] tones, ScaleQuality scaleQuality) {
    super(name, tones);
    this.scaleQuality = scaleQuality;
    this.key = tones[0];
  }

  public ScaleQuality getScaleQuality() {
    return scaleQuality;
  }

  public Tone getKey() {
    return this.key;
  }
  
  @Override
  public String getSpellingString() {
    String baseString = super.getSpellingString();
    return ( baseString + ", (" + this.key + ")" );
  }

}
