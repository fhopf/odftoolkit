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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

/**
 * A POI Workbook implementation that used odfdom.
 * @author Florian Hopf, fhopf@apache.org
 */
public class OdsWorkbook implements Workbook {

    private SpreadsheetDocument doc;

    public OdsWorkbook() {
        try {
            this.doc = SpreadsheetDocument.newSpreadsheetDocument();
            // poi doesn't append a sheet automatically, so remove it
            doc.removeSheet(0);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public OdsWorkbook(InputStream in) {
        try {
            this.doc = SpreadsheetDocument.loadDocument(in);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public int getActiveSheetIndex() {
        return 0;
    }

    public void setActiveSheet(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getFirstVisibleTab() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFirstVisibleTab(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSheetOrder(String string, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSelectedTab(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSheetName(int i, String string) {
        Table sheetByIndex = getSheet(i);
        sheetByIndex.setTableName(string);
    }

    public String getSheetName(int i) {
        Table sheetByIndex = getSheet(i);
        return sheetByIndex.getTableName();
    }
    

    public int getSheetIndex(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getSheetIndex(Sheet sheet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sheet createSheet() {
        Table newTable = doc.appendSheet(createNewSheetName());
        return new OdsSheet(this, newTable);
    }

    public Sheet createSheet(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sheet cloneSheet(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getNumberOfSheets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Sheet getSheetAt(int i) {
        Table table = doc.getSheetByIndex(i);
        if (table == null) {
            String range = "-";
            if (doc.getSheetCount() > 0) {
                range = "0..." + doc.getSheetCount();
            }
            throw new IllegalArgumentException(String.format("Sheet at index %d doesn't exist. Available: %s", Integer.valueOf(i), range));
        }
        return new OdsSheet(this, table);
    }

    public Sheet getSheet(String name) {
        Table table = doc.getSheetByName(name);
        return getSheetOrNull(table);
    }
    
    private OdsSheet getSheetOrNull(Table table) {
        if (table == null) {
            return null;
        } else {
            return new OdsSheet(this, table);
        }
    }

    public void removeSheetAt(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRepeatingRowsAndColumns(int i, int i1, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Font createFont() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Font findFont(short s, short s1, short s2, String string, boolean bln, boolean bln1, short s3, byte b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getNumberOfFonts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Font getFontAt(short s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellStyle createCellStyle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getNumCellStyles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CellStyle getCellStyleAt(short s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void write(OutputStream out) throws IOException {
        try {
            doc.save(out);
        } catch (Exception ex) {
            // todo differ between IO and other exception
            throw new IOException(ex);
        }
    }

    public int getNumberOfNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Name getName(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Name getNameAt(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Name createName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getNameIndex(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeName(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeName(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPrintArea(int i, String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPrintArea(int i, int i1, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPrintArea(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removePrintArea(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MissingCellPolicy getMissingCellPolicy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setMissingCellPolicy(MissingCellPolicy mcp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DataFormat createDataFormat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int addPicture(byte[] bytes, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<? extends PictureData> getAllPictures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CreationHelper getCreationHelper() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isHidden() {
        return false;
    }

    public void setHidden(boolean bln) {
        // nothing found yet
        // probably set all sheets to be hidden?
    }

    public boolean isSheetHidden(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isSheetVeryHidden(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSheetHidden(int i, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSheetHidden(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addToolPack(UDFFinder udff) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setForceFormulaRecalculation(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getForceFormulaRecalculation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Table getSheet(int i) throws IllegalArgumentException {
        final Table sheetByIndex = doc.getSheetByIndex(i);
        if (sheetByIndex == null) {
            // TODO this should contain a hint on the available sheets
            throw new IllegalArgumentException();
        }
        return sheetByIndex;
    }

    private String createNewSheetName() {
        int index = doc.getSheetCount();
        String name = "Sheet" + index;
        while (doc.getSheetByName(name) != null) {
            index++;
            name = "Sheet" + index;
        }
        return name;
    }
    
}
