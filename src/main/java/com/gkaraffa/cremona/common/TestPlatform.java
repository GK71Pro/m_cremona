package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.helper.ScaleHelper;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.chord.ChordFactory;
import com.gkaraffa.cremona.theoretical.scale.HarmonizableScale;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    ScaleHelper scaleHelper = ScaleHelper.getInstance();
    Scale scale = scaleHelper.getScale("F", "lydian dominant");
    ToneCollection toneCollection = scale.getToneCollection();

    ChordFactory chordFactory = new ChordFactory();
    for (Tone tone : toneCollection) {
      System.out.print(tone);
      Chord chord =
          chordFactory.createChordFromHarmonizableScale((HarmonizableScale) scale, tone, 4);
      System.out.println(": " + chord.getLongName());
    }
  }

}
