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

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
class OdsRichtextString implements RichTextString {
    private final String string;

    public OdsRichtextString(String string) {
        this.string = string;
    }

    public void applyFont(int i, int i1, short s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void applyFont(int i, int i1, Font font) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void applyFont(Font font) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clearFormatting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getString() {
        return string;
    }

    public int length() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int numFormattingRuns() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getIndexOfFormattingRun(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void applyFont(short s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}