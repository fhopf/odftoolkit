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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.odftoolkit.simple.SpreadsheetDocument;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.odftoolkit.simple.table.Table;

/**
 * Tests that the functionality described in the user guide is available.
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class UserGuideTest {

    @Test
    public void newWorkbookCanBeCreated() throws IOException, Exception {
        Workbook wb = new OdsWorkbook();
        SpreadsheetDocument doc = writeAndLoad(wb);
        assertNotNull(doc);
    }

    @Test
    public void newSheetsCanBeCreated() throws Exception {
        Workbook wb = new OdsWorkbook();  // or new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");
        SpreadsheetDocument doc = writeAndLoad(wb);
        List<Table> tables = doc.getTableList();
        assertEquals(2, tables.size());
        assertEquals("new sheet", tables.get(0).getTableName());
        assertEquals("second sheet", tables.get(1).getTableName());
    }

    @Test
    public void newCellsCanBeCreated() throws Exception {
        Workbook wb = new OdsWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short) 0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);

        SpreadsheetDocument doc = writeAndLoad(wb);
        assertNotNull(doc);

        Table table = doc.getSheetByName("new sheet");
        // TODO 2 rows are created automatically, create row simply appends
        org.odftoolkit.simple.table.Row rowByIndex = table.getRowByIndex(2);
        assertNotNull(rowByIndex);
        // currently 5 cells are created by default?
        //assertEquals(4, rowByIndex.getCellCount());
        assertEquals(1, rowByIndex.getCellByIndex(0).getDoubleValue(), 0.0001);
        assertEquals(1.2, rowByIndex.getCellByIndex(1).getDoubleValue(), 0.0001);
        assertEquals("This is a string", rowByIndex.getCellByIndex(2).getStringValue());
        assertEquals(true, rowByIndex.getCellByIndex(3).getBooleanValue());
    }

    @Ignore("doesn't seem to be possible to set a date-time-value currently")
    @Test
    public void dateCellsCanBeCreated() throws Exception {
        Workbook wb = new OdsWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        Date firstCellDate = new Date();
        
        // Create a cell and put a date value in it.  The first cell is not styled
        // as a date.
        Cell cell = row.createCell(0);
        cell.setCellValue(firstCellDate);

        // we style the second cell as a date (and time).  It is important to
        // create a new cell style from the workbook otherwise you can end up
        // modifying the built in style and effecting not only this cell but other cells.
        Date secondCellDate = new Date();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        cell = row.createCell(1);
        cell.setCellValue(secondCellDate);
        cell.setCellStyle(cellStyle);

        Calendar thirdCellValue = Calendar.getInstance();
        //you can also set date as java.util.Calendar
        cell = row.createCell(2);
        cell.setCellValue(thirdCellValue);
        cell.setCellStyle(cellStyle);
        
        SpreadsheetDocument doc = writeAndLoad(wb);
        assertNotNull(doc);
    }
    
    private SpreadsheetDocument writeAndLoad(Workbook wb) throws Exception, FileNotFoundException, IOException {
        File tempFile = File.createTempFile("poiodf", ".ods");
        tempFile.deleteOnExit();
        FileOutputStream fileOut = new FileOutputStream(tempFile);
        wb.write(fileOut);
        fileOut.close();

        // check that file can be opened with odftoolkit
        return SpreadsheetDocument.loadDocument(tempFile);
    }
}