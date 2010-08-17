/*
 * Copyright 2003-2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.collections.primitives.decorators;

import org.apache.commons.collections.primitives.ByteCollection;
import org.apache.commons.collections.primitives.ByteIterator;

/**
 * 
 * @since Commons Primitives 1.0
 * @version $Revision: 1.2 $ $Date: 2004/02/25 20:46:27 $
 * 
 * @author Rodney Waldhoff 
 */
abstract class BaseProxyByteCollection implements ByteCollection {
    protected abstract ByteCollection getProxiedCollection();

    protected BaseProxyByteCollection() {
    }
    
    public boolean add(byte element) {
        return getProxiedCollection().add(element);
    }

    public boolean addAll(ByteCollection c) {
        return getProxiedCollection().addAll(c);
    }

    public void clear() {
        getProxiedCollection().clear();
    }

    public boolean contains(byte element) {
        return getProxiedCollection().contains(element);
    }

    public boolean containsAll(ByteCollection c) {
        return getProxiedCollection().containsAll(c);
    }

    public boolean isEmpty() {
        return getProxiedCollection().isEmpty();
    }

    public ByteIterator iterator() {
        return getProxiedCollection().iterator();
    }

    public boolean removeAll(ByteCollection c) {
        return getProxiedCollection().removeAll(c);
    }

    public boolean removeElement(byte element) {
        return getProxiedCollection().removeElement(element);
    }

    public boolean retainAll(ByteCollection c) {
        return getProxiedCollection().retainAll(c);
    }

    public int size() {
        return getProxiedCollection().size();
    }

    public byte[] toArray() {
        return getProxiedCollection().toArray();
    }

    public byte[] toArray(byte[] a) {
        return getProxiedCollection().toArray(a);
    }

    // TODO: Add note about possible contract violations here.
    
    public boolean equals(Object obj) {
        return getProxiedCollection().equals(obj);
    }

    public int hashCode() {
        return getProxiedCollection().hashCode();
    }

    public String toString() {
        return getProxiedCollection().toString();
    }

}
