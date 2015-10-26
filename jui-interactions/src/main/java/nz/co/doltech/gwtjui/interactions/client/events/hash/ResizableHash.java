/*
 * Copyright 2015 Doltech Systems Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package nz.co.doltech.gwtjui.interactions.client.events.hash;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import nz.co.doltech.gwtjui.core.client.base.EventHash;
import nz.co.doltech.gwtjui.core.client.util.At;

public class ResizableHash implements EventHash {

    private Element element;
    private Element helper;
    private Element originalElement;
    private At originalPos;
    private At originalSize;
    private At pos;
    private At size;

    public ResizableHash(JavaScriptObject hash) {
        fromJavaScriptObject(hash);
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Element getHelper() {
        return helper;
    }

    public void setHelper(Element helper) {
        this.helper = helper;
    }

    public Element getOriginalElement() {
        return originalElement;
    }

    public void setOriginalElement(Element originalElement) {
        this.originalElement = originalElement;
    }

    public At getOriginalPos() {
        return originalPos;
    }

    public void setOriginalPos(At originalPos) {
        this.originalPos = originalPos;
    }

    public void setOriginalPos(JavaScriptObject originalPos) {
        this.originalPos = At.fromJavaScriptObject(originalPos);
    }

    public At getOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(At originalSize) {
        this.originalSize = originalSize;
    }

    public void setOriginalSize(JavaScriptObject originalSize) {
        this.originalSize = At.fromJavaScriptObject(originalSize);
    }

    public At getPos() {
        return pos;
    }

    public void setPos(At pos) {
        this.pos = pos;
    }

    public void setPos(JavaScriptObject pos) {
        this.pos = At.fromJavaScriptObject(pos);
    }

    public At getSize() {
        return size;
    }

    public void setSize(At size) {
        this.size = size;
    }

    public void setSize(JavaScriptObject size) {
        this.size = At.fromJavaScriptObject(size);
    }

    @Override
    public native void fromJavaScriptObject(JavaScriptObject jso) /*-{
        if(jso.element !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::element = jso.element[0];
        }
        if(jso.helper !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::helper = jso.helper[0];
        }
        if(jso.originalElement !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::originalElement = jso.originalElement[0];
        }
        this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::setOriginalPos(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.originalPosition);
        this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::setOriginalSize(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.originalSize);
        this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::setPos(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.position);
        this.@nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash::setSize(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.size);
    }-*/;
}
