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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Ignore;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsRowTest {
    
    @Test
    public void cellCanBeCreated() {
        Cell cell = getEmptyRow().createCell(0);
        assertNotNull(cell);
    }
    
    @Test
    public void cellCanBeRetrieved() {
        Row row = getEmptyRow();
        Cell cell = row.createCell(0);
        assertEquals(cell, row.getCell(0));
    }
    
    @Test
    public void accessingCellThatDoesntExist() {
        assertNull(getEmptyRow().getCell(12));
    }

    @Test
    public void accessingCellThatDoesntExistReturnNullAndBlank() {
        assertNull(getEmptyRow().getCell(12, Row.RETURN_NULL_AND_BLANK));
    }
    
    @Test
    public void accessingCellThatDoesntExistMissingCellPolicyCreateNullAsBlank() {
        assertNotNull(getEmptyRow().getCell(12, Row.CREATE_NULL_AS_BLANK));
    }
    
    @Ignore("TODO: what does this mean?")
    @Test
    public void accessingCellThatDoesntExistMissingCellPolicyBlankAsNull() {
        assertNotNull(getEmptyRow().getCell(12, Row.RETURN_BLANK_AS_NULL));
    }
    
    @Test
    public void heightCanBeSet() {
        OdsRow emptyRow = getEmptyRow();
        emptyRow.setHeight((short) 15);
        assertEquals((short) 15, emptyRow.getHeight());
    }
    
    @Test
    public void heightInPointsCanBeSet() {
        OdsRow emptyRow = getEmptyRow();
        emptyRow.setHeightInPoints(1.23f);
        assertEquals(1.23f, emptyRow.getHeightInPoints(), 0.01);
    }
    
    @Ignore("Need to investigate in mapping between styles")
    @Test
    public void blankCellCanBeCreated() {
        OdsRow emptyRow = getEmptyRow();
        Cell cell = emptyRow.createCell(1, Cell.CELL_TYPE_BLANK);
        assertEquals(Cell.CELL_TYPE_BLANK, cell.getCellType());
    }
    
    private OdsRow getEmptyRow() {
        OdsWorkbook workbook = new OdsWorkbook();
        return (OdsRow) workbook.createSheet().createRow(0);
    }
    
}
