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

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;

/**
 *
 * @author Florian Hopf, fhopf@apache.org
 */
class OdsCreationHelper implements CreationHelper {

    public OdsCreationHelper() {
    }

    public RichTextString createRichTextString(String string) {
        return new OdsRichtextString(string);
    }

    public DataFormat createDataFormat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Hyperlink createHyperlink(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FormulaEvaluator createFormulaEvaluator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ClientAnchor createClientAnchor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
