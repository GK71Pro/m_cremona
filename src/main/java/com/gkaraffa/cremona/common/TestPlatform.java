package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.helper.Helper;
import com.gkaraffa.cremona.theoretical.scale.Scale;

public class TestPlatform {

  public static void main(String[] args) {
    Helper helper = Helper.getInstance();
    Scale scale = helper.getScale("A", "Melodic Minor");
    scale.getText();
  }
}
