/*
 * Copyright 2013 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.odftoolkit.poi;

import java.util.Iterator;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.odftoolkit.simple.table.Table;

/**
 * Sheet adapter for Ods Table
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsSheet implements Sheet {
    
    private final OdsWorkbook workbook;
    private final Table table;

    OdsSheet(OdsWorkbook workbook, Table table) {
        this.workbook = workbook;
        this.table = table;
    }
    
    public Row createRow(int i) {
        // TODO this needs to be inserted at the index
        org.odftoolkit.simple.table.Row appendedRow = table.appendRow();
        return new OdsRow(this, appendedRow);
    }

    public void removeRow(Row row) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Row getRow(int i) {
        org.odftoolkit.simple.table.Row rowByIndex = table.getRowByIndex(i);
        return new OdsRow(this, rowByIndex);
    }

    public int getPhysicalNumberOfRows() {
        return table.getRowCount();
    }

    public int getFirstRowNum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getLastRowNum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setColumnHidden(int i, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isColumnHidden(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRightToLeft(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isRightToLeft() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setColumnWidth(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getColumnWidth(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDefaultColumnWidth(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDefaultColumnWidth() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getDefaultRowHeight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float getDefaultRowHeightInPoints() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDefaultRowHeight(short s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDefaultRowHeightInPoints(float f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellStyle getColumnStyle(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int addMergedRegion(CellRangeAddress cra) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setVerticallyCenter(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setHorizontallyCenter(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getHorizontallyCenter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getVerticallyCenter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeMergedRegion(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getNumMergedRegions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellRangeAddress getMergedRegion(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator<Row> rowIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setForceFormulaRecalculation(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getForceFormulaRecalculation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAutobreaks(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDisplayGuts(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDisplayZeros(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isDisplayZeros() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFitToPage(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowSumsBelow(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowSumsRight(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getAutobreaks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getDisplayGuts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getFitToPage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getRowSumsBelow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getRowSumsRight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isPrintGridlines() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPrintGridlines(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PrintSetup getPrintSetup() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Header getHeader() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Footer getFooter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSelected(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getMargin(short s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setMargin(short s, double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getProtect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void protectSheet(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getScenarioProtect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setZoom(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getTopRow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getLeftCol() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showInPane(short s, short s1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void shiftRows(int i, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void shiftRows(int i, int i1, int i2, boolean bln, boolean bln1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createFreezePane(int i, int i1, int i2, int i3) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createFreezePane(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createSplitPane(int i, int i1, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PaneInformation getPaneInformation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDisplayGridlines(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isDisplayGridlines() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDisplayFormulas(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isDisplayFormulas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDisplayRowColHeadings(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isDisplayRowColHeadings() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowBreak(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isRowBroken(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeRowBreak(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int[] getRowBreaks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int[] getColumnBreaks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setColumnBreak(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isColumnBroken(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeColumnBreak(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setColumnGroupCollapsed(int i, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void groupColumn(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ungroupColumn(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void groupRow(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ungroupRow(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowGroupCollapsed(int i, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDefaultColumnStyle(int i, CellStyle cs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void autoSizeColumn(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void autoSizeColumn(int i, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Comment getCellComment(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Drawing createDrawingPatriarch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public String getSheetName() {
        return table.getTableName();
    }

    public boolean isSelected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellRange<? extends Cell> setArrayFormula(String string, CellRangeAddress cra) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellRange<? extends Cell> removeArrayFormula(Cell cell) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DataValidationHelper getDataValidationHelper() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addValidationData(DataValidation dv) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public AutoFilter setAutoFilter(CellRangeAddress cra) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SheetConditionalFormatting getSheetConditionalFormatting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellRangeAddress getRepeatingRows() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellRangeAddress getRepeatingColumns() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRepeatingRows(CellRangeAddress cra) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRepeatingColumns(CellRangeAddress cra) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator<Row> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.table != null ? this.table.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OdsSheet other = (OdsSheet) obj;
        if (this.table != other.table && (this.table == null || !this.table.equals(other.table))) {
            return false;
        }
        return true;
    }
    
    
}
