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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsRow implements Row {

    private final org.odftoolkit.simple.table.Row row;
    private final Sheet sheet;

    public OdsRow(Sheet sheet, org.odftoolkit.simple.table.Row row) {
        this.sheet = sheet;
        this.row = row;
    }

    public Cell createCell(int i) {
        org.odftoolkit.simple.table.Cell cellByIndex = row.getCellByIndex(i);
        return new OdsCell(cellByIndex);
    }

    public Cell createCell(int i, int type) {
        org.odftoolkit.simple.table.Cell cellByIndex = row.getCellByIndex(i);
        return new OdsCell(cellByIndex);
    }

    public void removeCell(Cell cell) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowNum(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getRowNum() {
        return row.getRowIndex();
    }

    public Cell getCell(int i) {
        return getCell(i, Row.RETURN_NULL_AND_BLANK);
    }

    public Cell getCell(int i, MissingCellPolicy mcp) {
        if (mcp == Row.CREATE_NULL_AS_BLANK) {
            return new OdsCell(row.getCellByIndex(i));
        } else if (mcp == Row.RETURN_NULL_AND_BLANK) {
            if (i > row.getCellCount() - 1) {
                return null;
            }
            return new OdsCell(row.getCellByIndex(i));
        } else {
            return null;
        }
    }

    public short getFirstCellNum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getLastCellNum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPhysicalNumberOfCells() {
        return row.getCellCount();
    }

    public void setHeight(short s) {
        row.setHeight(s, false);
    }

    public void setZeroHeight(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getZeroHeight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setHeightInPoints(float f) {
        row.setHeight(f, false);
    }

    public short getHeight() {
        return (short) row.getHeight();
    }

    public float getHeightInPoints() {
        // TODO there can be conversion problems
        return (float) row.getHeight();
    }

    public boolean isFormatted() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellStyle getRowStyle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRowStyle(CellStyle cs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator<Cell> cellIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sheet getSheet() {
        return sheet;
    }

    public Iterator<Cell> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.row != null ? this.row.hashCode() : 0);
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
        final OdsRow other = (OdsRow) obj;
        if (this.row != other.row && (this.row == null || !this.row.equals(other.row))) {
            return false;
        }
        return true;
    }
}
