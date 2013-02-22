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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
public class XSSFRowBehaviourTest {
    
    @Test
    public void newRowHasNoCells() {
        assertEquals(0, getEmptyRow().getPhysicalNumberOfCells());
    }
    
    @Test
    public void getCellThatDoesntExist() {
        assertNull(getEmptyRow().getCell(12));
    }
    
    @Test
    public void accessingCellThatDoesntExistMissingCellPolicyCreateNullAsBlank() {
        assertNotNull(getEmptyRow().getCell(12, Row.CREATE_NULL_AS_BLANK));
    }
    
    private Row getEmptyRow() {
        return new XSSFWorkbook().createSheet().createRow(0);
    }
    
}
