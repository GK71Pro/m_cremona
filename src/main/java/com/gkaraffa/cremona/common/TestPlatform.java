package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.helper.ScaleHelper;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    ScaleHelper scaleHelper = ScaleHelper.getInstance();
    Scale scaleA = scaleHelper.getScale("C", "Ionian");
    Scale scaleB = scaleHelper.getScale("G", "Ionian");
    
    ToneCollection tCUnion = scaleA.getToneCollection().union(scaleB.getToneCollection());
    ToneCollection tCIntersect = scaleA.getToneCollection().intersection(scaleB.getToneCollection());
    ToneCollection tCSymDiff = scaleA.getToneCollection().symDiff(scaleB.getToneCollection());
    
    System.out.println("Union: " + tCUnion.getSpellingString());
    System.out.println("Intersect: " + tCIntersect.getSpellingString());
    System.out.println("SymDiff: " + tCSymDiff.getSpellingString());
    /*
    Scale alphaScale = scaleHelper.getScale("C", "Ionian");
    Scale betaScale = scaleHelper.getScale(alphaScale.getToneCollection().getTone(4).getText(), "Ionian");
    
    do {
      System.out.println("A: " + alphaScale.getKey().getText() + ", B: " + betaScale.getKey().getText());
      String fifthToneString = alphaScale.getToneCollection().getTone(4).getText();
      alphaScale = betaScale;
      betaScale = scaleHelper.getScale(alphaScale.getToneCollection().getTone(4).getText(), "Ionian");
    } while (!alphaScale.getKey().equals(Tone.C));
    */
    
  }
}
