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

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Validates behaviour of the POI XSSFWorkbook.
 * @author Florian Hopf, fhopf@apache.org
 */
public class XSSFWorkbookBehaviourTest {
    
    @Test
    public void activeSheetDefaultsTo0() {
        Workbook workbook = new XSSFWorkbook();
        assertEquals(0, workbook.getActiveSheetIndex());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void illegalArgumentExceptionOnSetSheetnameOnNonexistingSheet() {
        Workbook workbook = new XSSFWorkbook();
        workbook.setSheetName(1388, "foo");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void illegalArgumentExceptionOnGetSheetnameOnNonexistingSheet() {
        Workbook workbook = new XSSFWorkbook();
        workbook.getSheetName(1388);
    }
    
    @Test
    public void newSheetIsNamedSheet0() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        assertNotNull(sheet.getSheetName());
        assertEquals("Sheet0", sheet.getSheetName());
    }
    
    @Test
    public void sheetByNameThatDoesntExistIsNull() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.getSheet("DoesntExist");
        assertNull(sheet);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void illegalArgumentExceptionOnGetSheetByIndexThatDoesntExist() {
        Workbook workbook = new XSSFWorkbook();
        workbook.getSheetAt(12);
    }
    
}
