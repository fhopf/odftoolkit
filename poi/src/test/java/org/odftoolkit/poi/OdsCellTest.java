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

import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsCellTest {
    
    @Test
    public void doubleValueCanBeSet() {
        Cell emptyCell = getEmptyCell();
        emptyCell.setCellValue(1);
        assertEquals(1, emptyCell.getNumericCellValue(), 0.00001);
    }
    
    @Test
    public void richTextStringCanBeSet() {
        Cell emptyCell = getEmptyCell();
        emptyCell.setCellValue(new OdsRichtextString("foo"));
        assertEquals("foo", emptyCell.getRichStringCellValue().getString());
    }
    
    @Test
    public void booleanValueCanBeSet() {
        Cell emptyCell = getEmptyCell();
        emptyCell.setCellValue(true);
        assertEquals(true, emptyCell.getBooleanCellValue());
    }
    
    @Ignore
    @Test
    public void dateValueCanBeSet() {
        Date date = new Date();
        Cell cell = getEmptyCell();
        cell.setCellValue(date);
        assertEquals(date, cell.getDateCellValue());
    }
    
    @Test
    @Ignore
    public void whatHappensOnIncompatibleValues() {
        
    }
    
    private Cell getEmptyCell() {
        return new OdsWorkbook().createSheet().createRow(0).createCell(0);
    }
}
