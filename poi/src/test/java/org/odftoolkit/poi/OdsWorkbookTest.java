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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.odftoolkit.simple.SpreadsheetDocument;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;
import org.junit.Ignore;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsWorkbookTest {
    
    @Test
    public void emptyWorkbookCanBeWrittenToStream() throws IOException, Exception {
        OdsWorkbook workbook = new OdsWorkbook();
        byte [] result = write(workbook);
        ByteArrayInputStream in = new ByteArrayInputStream(result);
        SpreadsheetDocument doc = SpreadsheetDocument.loadDocument(in);
        assertNotNull(doc);
    }

    @Test
    public void workbookCanBeLoadedFromStream() throws IOException {
        OdsWorkbook workbook = new OdsWorkbook(simpleSheetStream());
        byte[] result = write(workbook);
        byte[] testDocument = fromStream(simpleSheetStream());
        assertEquals(testDocument.length, result.length);
    }
    
    
    
    private byte[] fromStream(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte [] buf = new byte[1024];
        int i = -1;
        while ((i = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, i);
        }
        out.flush();
        return out.toByteArray();
    }
    
    private byte[] write(Workbook workbook) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return out.toByteArray();
    }
    
    @Test
    public void activeSheetIndexDefaultsTo0() {
        // in settings.xml: <config:config-item config:name="ActiveTable" config:type="string">A</config:config-item>
        OdsWorkbook workbook = new OdsWorkbook();
        assertEquals(0, workbook.getActiveSheetIndex());
    }
    
    @Test
    public void workbookNotHiddenByDefault() {
        OdsWorkbook workbook = new OdsWorkbook();
        assertFalse(workbook.isHidden());
    }
    
    @Ignore("no property found yet for hiding a whole spreadsheet")
    @Test
    public void workbookCanBeSetToHidden() {
        OdsWorkbook workbook = new OdsWorkbook();
        workbook.setHidden(true);
        assertTrue(workbook.isHidden());
    }

    @Test
    public void sheetnameCanBeRead() {
        OdsWorkbook workbook = new OdsWorkbook(simpleSheetStream());
        assertEquals("A", workbook.getSheetName(0));
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void readSheetnameForNonexistingSheet() {
        OdsWorkbook workbook = new OdsWorkbook();
        workbook.getSheetName(1388);
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void setSheetnameForNonexistingSheet() {
        OdsWorkbook workbook = new OdsWorkbook();
        workbook.setSheetName(1388, "foo");
    }
    
    @Test
    public void sheetnameCanBeSet() {
        OdsWorkbook workbook = new OdsWorkbook(simpleSheetStream());
        workbook.setSheetName(0, "B");
        
        assertEquals("B", workbook.getSheetName(0));
    }
    
    @Test
    public void newSheetCanBeCreated() {
        OdsWorkbook workbook = new OdsWorkbook();
        Sheet sheet = workbook.createSheet();
        
        assertNotNull(sheet);
    }
    
    @Test
    public void newSheetHasReferenceToItsWorkbook() {
        OdsWorkbook workbook = new OdsWorkbook();
        Sheet sheet = workbook.createSheet();
        
        assertSame(workbook, sheet.getWorkbook());
    }
    
    @Test
    public void newSheetNameIsSheet0() {
        OdsWorkbook workbook = new OdsWorkbook();
        Sheet sheet = workbook.createSheet();
        
        assertEquals("Sheet0", sheet.getSheetName());
    }
    
    @Test
    public void newlyCreatedSheetCanBeAccessedByName() {
        OdsWorkbook workbook = new OdsWorkbook();
        Sheet sheet = workbook.createSheet();
        Sheet sheetByName = workbook.getSheet("Sheet0");
        
        assertEquals(sheet, sheetByName);
    }
    
    @Test
    public void existingSheetCanBeAccessedByName() {
        OdsWorkbook workbook = new OdsWorkbook(simpleSheetStream());
        Sheet sheetByName = workbook.getSheet("A");
        
        assertEquals("A", sheetByName.getSheetName());
    }
    
    @Test
    public void sheetByNameThatDoesntExistIsNull() {
        Workbook workbook = new OdsWorkbook();
        Sheet sheet = workbook.getSheet("DoesntExist");
        assertNull(sheet);
    }
    
    private InputStream simpleSheetStream() {
        return getClass().getResourceAsStream("/simpleSheet.ods");
    }
    
    
    
}
