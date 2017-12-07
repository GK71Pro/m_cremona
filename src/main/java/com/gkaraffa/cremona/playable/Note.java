package com.gkaraffa.cremona.playable;

import com.gkaraffa.cremona.common.Duration;
import com.gkaraffa.cremona.common.Pitch;

public class Note extends PlayableObject {
  private Pitch pitch;
  private Duration duration;

  public Note(Note note) {
    super();
    this.pitch = note.getPitch();
    this.duration = note.getDuration();
  }

  public Note(Pitch pitch, Duration duration) {
    super();
    this.pitch = pitch;
    this.duration = duration;
  }

  public Pitch getPitch() {
    return pitch;
  }

  public Duration getDuration() {
    return duration;
  }

}
