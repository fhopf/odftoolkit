/************************************************************************
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 *
 * Use is subject to license terms.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0. You can also
 * obtain a copy of the License at http://odftoolkit.org/docs/license.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ************************************************************************/

/*
 * This file is automatically generated.
 * Don't edit manually.
 */    

package org.odftoolkit.odfdom.pkg.manifest;

import org.odftoolkit.odfdom.doc.OdfFileDom;
import org.odftoolkit.odfdom.dom.element.OdfElement;
import org.odftoolkit.odfdom.dom.element.manifest.OdfEncryptionDataElement;

/**
 *
 */
public class EncryptionData extends OdfEncryptionDataElement
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3402017679469778676L;
	
	public EncryptionData( OdfFileDom _aOwnerDoc )
    {
        super( _aOwnerDoc );
    }
    
    public KeyDerivation getKeyDerivation(){
    	return OdfElement.findFirstChildNode(KeyDerivation.class, this);
    }
    
    public KeyDerivation setKeyDerivation(String _aKeyDerivationName, String _aSalt, Integer _aIterationCount){
    	removeKeyDerivation();
        return (KeyDerivation)createKeyDerivationElement(_aKeyDerivationName, _aSalt, _aIterationCount);
    }
    
    public void removeKeyDerivation(){
    	KeyDerivation key = OdfElement.findFirstChildNode(KeyDerivation.class, this);
        while (key != null) {
        	KeyDerivation nextKey = OdfElement.findNextChildNode(KeyDerivation.class, key);
            this.removeChild(key);
            key = nextKey;
        }
    }
    
    public Algorithm setAlgorithm(String _algorithmName, String _initialisationVector) {
    	removeAlgorithm();
        return (Algorithm)createAlgorithmElement(_algorithmName, _initialisationVector);
    }

    public Algorithm getAlgorithm() {
    	return OdfElement.findFirstChildNode(Algorithm.class, this);
    }
    
    public void removeAlgorithm(){
    	Algorithm algorithm = OdfElement.findFirstChildNode(Algorithm.class, this);
        while (algorithm != null) {
        	Algorithm nextAlgorithm = OdfElement.findNextChildNode(Algorithm.class, algorithm);
            this.removeChild(algorithm);
            algorithm = nextAlgorithm;
        }
    }
}
