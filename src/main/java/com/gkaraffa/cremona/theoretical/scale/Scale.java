package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Spellable;
import com.gkaraffa.cremona.theoretical.TheoreticalObject;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

//public abstract class Scale extends ToneCollection {
public abstract class Scale extends TheoreticalObject implements Spellable{
  private ScaleQuality scaleQuality;
  private Tone key;
  private IntervalPattern intervalPattern;
  //new
  private ToneCollection toneCollection;

  /*
  public Scale(String name, Tone[] tones, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name, tones);
    this.scaleQuality = scaleQuality;
    this.key = tones[0];
    this.intervalPattern = intervalPattern;
  }
  */
  
  public Scale(String name, ToneCollection toneCollection, ScaleQuality scaleQuality,
      IntervalPattern intervalPattern) {
    super(name);
    this.toneCollection = toneCollection;
    this.scaleQuality = scaleQuality;
    this.key = toneCollection.getTone(0);
    this.intervalPattern = intervalPattern;
  }

  public ScaleQuality getScaleQuality() {
    return scaleQuality;
  }

  public Tone getKey() {
    return this.key;
  }

  public IntervalPattern getIntervalPattern() {
    return this.intervalPattern;
  }
  
  public ToneCollection getToneCollection() {
    return this.toneCollection;
  }
  
  public String getSpellingString() {
    String baseString = this.toneCollection.getSpellingString();
    return (baseString + ", (" + this.key + ")");
  }
  
  /*
     @Override
  public String getSpellingString() {
    String baseString = super.getSpellingString();
    return (baseString + ", (" + this.key + ")");
  }

   */

}
