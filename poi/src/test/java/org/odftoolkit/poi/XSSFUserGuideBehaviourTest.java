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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class XSSFUserGuideBehaviourTest {
    
    @Test
    public void dateCellsCanBeCreated() throws Exception {
        Workbook wb = new XSSFWorkbook();
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
        
        Workbook workbook = saveAndLoad(wb);
        Sheet resultSheet = workbook.getSheet("new sheet");
        Row resultRow = resultSheet.getRow(0);
        assertEquals(firstCellDate, resultRow.getCell(0).getDateCellValue());
        assertEquals(secondCellDate, resultRow.getCell(1).getDateCellValue());
        assertEquals(thirdCellValue.getTime(), resultRow.getCell(2).getDateCellValue());
    }
    
    private Workbook saveAndLoad(Workbook wb) throws FileNotFoundException, IOException {
        File tempFile = File.createTempFile("poixls", ".xls");
        tempFile.deleteOnExit();
        FileOutputStream fileOut = new FileOutputStream(tempFile);
        wb.write(fileOut);
        fileOut.close();

        FileInputStream in = new FileInputStream(tempFile);
        Workbook result = new XSSFWorkbook(in);
        in.close();
        return result;
    }
    
}
