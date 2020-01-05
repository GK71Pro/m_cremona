package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.helper.ChordHelper;
import com.gkaraffa.cremona.helper.ScaleHelper;
import com.gkaraffa.cremona.theoretical.chord.Chord;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    ScaleHelper scaleHelper = ScaleHelper.getInstance();
    Scale scale = scaleHelper.getScale("A", "Melodic Minor");
    scale.getText();

    ChordHelper chordHelper = ChordHelper.getInstance();
    Chord chord = chordHelper.getChord("C", "dominant seventh");
    System.out.println(chord.getText());
    System.out.println(chord.getToneCollection().getSpellingString());

  }
}
