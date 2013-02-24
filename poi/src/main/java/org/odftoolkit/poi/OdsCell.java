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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
class OdsCell implements Cell {
    private final org.odftoolkit.simple.table.Cell cell;

    public OdsCell(org.odftoolkit.simple.table.Cell cell) {
        this.cell = cell;
    }

    public int getColumnIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getRowIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sheet getSheet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Row getRow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellType(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCellType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCachedFormulaResultType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellValue(double d) {
        cell.setDoubleValue(d);
    }

    public void setCellValue(Date date) {
        // TODO timezone?
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // libre office uses this format: 2012-02-24T09:30:00
        cell.setDateValue(cal);
        // set the correct format on the cell
        DateFormat format = new SimpleDateFormat("yyyy-MM-ddzHH:mm:ss");
        cell.getOdfElement().setOfficeDateValueAttribute(format.format(date));
    }

    public void setCellValue(Calendar clndr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellValue(RichTextString rts) {
        cell.setStringValue(rts.getString());
    }

    public void setCellValue(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellFormula(String string) throws FormulaParseException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getCellFormula() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getNumericCellValue() {
        return cell.getDoubleValue();
    }

    public Date getDateCellValue() {
        // TODO fault tolerance?
        return cell.getDateValue().getTime();
    }

    public RichTextString getRichStringCellValue() {
        return new OdsRichtextString(cell.getStringValue());
    }

    public String getStringCellValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellValue(boolean bln) {
        cell.setBooleanValue(bln);
    }

    public void setCellErrorValue(byte b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getBooleanCellValue() {
        return cell.getBooleanValue();
    }

    public byte getErrorCellValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellStyle(CellStyle cs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellStyle getCellStyle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAsActiveCell() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCellComment(Comment cmnt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Comment getCellComment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeCellComment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Hyperlink getHyperlink() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setHyperlink(Hyperlink hprlnk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellRangeAddress getArrayFormulaRange() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isPartOfArrayFormulaGroup() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.cell != null ? this.cell.hashCode() : 0);
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
        final OdsCell other = (OdsCell) obj;
        if (this.cell != other.cell && (this.cell == null || !this.cell.equals(other.cell))) {
            return false;
        }
        return true;
    }
    
    
}
