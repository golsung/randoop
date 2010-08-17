/**
* Copyright 2004 The Apache Software Foundation.
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
package org.apache.commons.jelly.tags.jaxme;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.JellyTagException;

import org.xml.sax.SAXException;

/** 
 * <p>Marshalls a generated object generated by a JAXB implementation into xml.</p>
 * <p>
 * The result is placed into the processed content for further processing by enclosing 
 * tags.</p>
 *
 * @author <a href="mailto:joe@ispsoft.de">Jochen Wiedmann</a>
 * @author <a href="mailto:commons-dev at jakarta.apache.org">Jakarta Commons Development Team</a>
 * @version $Revision: 1.2 $
 */
public class MarshallTag extends TagSupport {
        
    private String packages;
    private Object object;
    
    public String getPackages() {
        return packages;
    }
    
    /**
     * Defines the generated objects which will be marshalled by specifying the package name.
     */
    public void setPackages(String packages) {
        this.packages = packages;
    }
    
    public Object getObject() {
        return object;
    }
    
    /** 
     * Defines the object to be unmarshalled into xml by specifying a jelly variable name.
     */
    public void setObject(Object object) {
        this.object = object;
    }
    
    public void doTag(XMLOutput output) throws MissingAttributeException, JellyTagException {
        if (packages == null) {
            throw new MissingAttributeException( "packages" );
        }
        if (object == null) {
            throw new MissingAttributeException( "object" );
        }
        try {   

            JAXBContext jaxbContext = JAXBContext.newInstance(packages);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(object, output);
            
        } catch (JAXBException ex)  {
            throw new JellyTagException(ex);
        }
    }
}
