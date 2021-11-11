package com.gkaraffa.cremona.common;

import java.util.List;

public class CircularList<E>{
  private List<E> iList = null;
  private int current = 0;
  private int ticker;
  
  
  public CircularList(List<E> iList) {
    this.iList = iList;
    this.ticker = iList.size();
  }
  
  public void reset(int start) {
    if ((start < 0) || (start >= iList.size())) {
      throw new IllegalArgumentException();
    }
    
    this.current = start;
  }
  
  public E visitAndMove() {
    if (this.ticker == 0) {
      return null;
    }
    
    E element = (E) iList.get(current);
    
    ticker--;
    current++;
    if (current >= iList.size()) {
      current = 0;
    }
    
    return element;
  }
}
