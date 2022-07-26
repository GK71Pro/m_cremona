package com.gkaraffa.cremona.theoretical.scale;

import com.gkaraffa.cremona.theoretical.Interval;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.ToneGroupObject;
import com.gkaraffa.cremona.theoretical.Transposable;

public abstract class Scale extends ToneGroupObject implements Transposable {
  private Tone key;
  private ScaleNomenclature scaleNomenclature;
  private IntervalPattern intervalPattern;
  private ToneCollection toneCollection;

  public Scale(String name, ToneCollection toneCollection, ScaleNomenclature scaleNomenclature,
      IntervalPattern intervalPattern) {
    super(name);
    this.toneCollection = toneCollection;
    this.scaleNomenclature = scaleNomenclature;
    this.key = toneCollection.getTone(0);
    this.intervalPattern = intervalPattern;
  }

  public Tone getKey() {
    return this.key;
  }

  public ScaleNomenclature getScaleNomenclature() {
    return scaleNomenclature;
  }

  public IntervalPattern getIntervalPattern() {
    return this.intervalPattern;
  }

  @Override
  public ToneCollection getToneCollection() {
    return this.toneCollection;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Scale)) {
      return false;
    }

    Scale sO = (Scale) o;

    return (sO.hashCode() == this.hashCode());
  }

  @Override
  public int hashCode() {
    int result = 17;

    result = 23 * result + getLongName().hashCode();

    return result;
  }

  private Scale generateNewScale(IntervalPattern intervalPattern, Tone tonic) {
    ScaleFactory scaleFactory = this.getScaleFactory();
    Scale genScale = scaleFactory.createScale(intervalPattern, tonic);

    return genScale;
  }

  protected abstract ScaleFactory getScaleFactory();

  private int calculateLocation(int segment, int offset) {
    int location = segment + offset;
    int limit = this.getToneCollection().getSize() + 1;

    if (location > limit) {
      location -= limit;
    }

    return location;
  }

  public Tone getToneAtRelativeIntervalNumber(IntervalNumber rootInterval,
      IntervalNumber offsetInterval) {

    return this.getToneCollection()
        .getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

  @Override
  public ToneGroupObject transposeUp(Interval interval) {
    Tone transTonic = TonalSpectrum.traverseInterval(this.toneCollection.getTone(0), interval);

    return this.generateNewScale(intervalPattern, transTonic);
  }

  @Override
  public ToneGroupObject transposeUp(int halfSteps) {
    Tone transTonic = TonalSpectrum.traverseDistance(this.toneCollection.getTone(0), halfSteps);

    return this.generateNewScale(intervalPattern, transTonic);
  }

  @Override
  public ToneGroupObject transposeDown(Interval interval) {
    Tone transTonic = TonalSpectrum.reverseInterval(this.toneCollection.getTone(0), interval);

    return this.generateNewScale(intervalPattern, transTonic);
  }

  @Override
  public ToneGroupObject transposeDown(int halfSteps) {
    Tone transTonic = TonalSpectrum.reverseDistance(this.toneCollection.getTone(0), halfSteps);

    return this.generateNewScale(intervalPattern, transTonic);
  }


}
