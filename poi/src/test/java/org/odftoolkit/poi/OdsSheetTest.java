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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsSheetTest {
    
    @Test
    @Ignore
    public void emptySheetHasNoRows() {
        assertEquals(0, emptySheet().getPhysicalNumberOfRows());
    }
    
    @Test
    public void rowCanBeCreated() {
        Sheet sheet = emptySheet();
        Row row = sheet.createRow(0);
        assertNotNull(row);
        // TODO assertEquals
    }
    
    @Ignore("No way to add a row at a certain position")
    @Test
    public void rowCanBeAccessedByIndex() {
        Sheet sheet = emptySheet();
        Row row = sheet.createRow(0);
        assertNotNull(row);
        assertEquals(row.getRowNum(), sheet.getRow(0).getRowNum());
    }
    
    @Ignore("Cells can't be removed")
    @Test
    public void newRowHasNoCells() {
        Sheet sheet = emptySheet();
        Row row = sheet.createRow(0);
        assertEquals(0, row.getPhysicalNumberOfCells());
    }
    
    @Test
    public void sheetCanBeRetrievedFromRow() {
        Sheet sheet = emptySheet();
        Row row = sheet.createRow(0);
        assertEquals(sheet, row.getSheet());
    }
    
    private OdsSheet emptySheet() {
        Workbook workbook = new OdsWorkbook();
        return (OdsSheet) workbook.createSheet();
    }
    
}
