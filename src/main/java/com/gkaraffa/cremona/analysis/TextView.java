package com.gkaraffa.cremona.analysis;

import java.util.List;

public class TextView extends View {
  private TabularAnalytic tabularAnalytic = null;
  private int numCols;
  private int numRows;
  private int[] columnMaxs;
  private int fieldSpace;
  private String viewString;

  public TextView(TabularAnalytic tabularAnalytic) {
    this.tabularAnalytic = tabularAnalytic;
    this.numCols = tabularAnalytic.getColumnCount();
    this.numRows = tabularAnalytic.getRowCount();
    this.columnMaxs = this.getColumnMaxs();
    this.fieldSpace = this.getFieldSpace();
    this.viewString = this.renderViewString();
  }

  @Override
  public byte[] getByteArray() {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public String toString() {
    return this.viewString;
  }

  private String renderViewString() {
    StringBuilder sB = new StringBuilder();

    sB.append(this.renderHeader());
    sB.append(this.renderBody());
    sB.append(this.renderFoot());
    
    return sB.toString();
  }
  
  private int getFieldSpace() {
    int fieldCount = this.columnMaxs.length;
    int fieldSpace = fieldCount + 1;

    for (int columnMax : this.columnMaxs) {
      fieldSpace = fieldSpace + columnMax + 2;
    }
    
    return fieldSpace;
  }

  private String renderHeader() {
    StringBuilder sB = new StringBuilder();
    sB.append(renderBar());
    sB.append("\n" + renderTitles());
    sB.append("\n" + renderBar());
    sB.append("\n");

    return sB.toString();
  }

  private String renderBody() {
    StringBuilder sB = new StringBuilder();
    
    for(int index = 0; index < this.numRows; index++) {
      List<AnalyticCell> analyticCells = this.tabularAnalytic.getAnalyticRow(index);
      int columnCount = 0;
      
      for(AnalyticCell analyticCell: analyticCells) {
        sB.append("| ");
        sB.append(String.format(createFormatString(this.columnMaxs[columnCount]), analyticCell));
        sB.append(" ");
        columnCount++;
      }
      sB.append("|\n");
    }
    
    return sB.toString();
  }
  
  private String renderFoot() {
    return (renderBar() + "\n");
  }

  private String createFormatString(int columnMax) {
    StringBuilder sB = new StringBuilder();

    sB.append("%-");
    sB.append(columnMax);
    sB.append(".");
    sB.append(columnMax);
    sB.append("s");

    return sB.toString();
  }

  private String renderTitles() {
    List<HeaderCell> headerCells = this.tabularAnalytic.getHeaderRow();
    StringBuilder sB = new StringBuilder();

    for (int index = 0; index < this.numCols; index++) {
      sB.append("| ");
      sB.append(String.format(createFormatString(this.columnMaxs[index]), headerCells.get(index)));
      sB.append(" ");
    }

    sB.append("|");

    return sB.toString();
  }

  private String renderBar() {
    StringBuilder sB = new StringBuilder();
    for (int index = 0; index < this.fieldSpace; index++) {
      sB.append('-');
    }

    return sB.toString();
  }

  private int[] getColumnMaxs() {
    int[] columnMaxs = new int[this.numCols];

    for (int index = 0; index < this.numCols; index++) {
      int maxLen = 0;

      // check all rows
      List<AnalyticCell> analyticCells = tabularAnalytic.getAnalyticColumn(index);
      for (AnalyticCell analyticCell : analyticCells) {
        int currentLength = analyticCell.getAnalyticText().length();
        if (currentLength > maxLen) {
          maxLen = currentLength;
        }
      }

      // check header
      int headerLength = tabularAnalytic.getHeaderRow().get(index).getHeaderText().length();
      if (headerLength > maxLen) {
        maxLen = headerLength;
      }

      columnMaxs[index] = maxLen;
    }

    return columnMaxs;
  }

}
