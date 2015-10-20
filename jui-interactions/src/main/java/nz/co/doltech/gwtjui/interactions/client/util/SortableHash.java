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
package nz.co.doltech.gwtjui.interactions.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import nz.co.doltech.gwtjui.core.client.base.EventHash;
import nz.co.doltech.gwtjui.core.client.util.At;

public class SortableHash implements EventHash {

    private Element helper;
    private Element item;
    private Element placeholder;
    private Element sender;
    private At offset;
    private At originalPos;
    private At pos;

    public SortableHash(JavaScriptObject hash) {
        fromJavaScriptObject(hash);
    }

    public Element getHelper() {
        return helper;
    }

    public void setHelper(Element helper) {
        this.helper = helper;
    }

    public Element getItem() {
        return item;
    }

    public void setItem(Element item) {
        this.item = item;
    }

    public Element getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(Element placeholder) {
        this.placeholder = placeholder;
    }

    public Element getSender() {
        return sender;
    }

    public void setSender(Element sender) {
        this.sender = sender;
    }

    public At getOffset() {
        return offset;
    }

    public void setOffset(At offset) {
        this.offset = offset;
    }

    public void setOffset(JavaScriptObject offset) {
        this.offset = At.fromJavaScriptObject(offset);
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

    public At getPos() {
        return pos;
    }

    public void setPos(At pos) {
        this.pos = pos;
    }

    public void setPos(JavaScriptObject pos) {
        this.pos = At.fromJavaScriptObject(pos);
    }

    @Override
    public native void fromJavaScriptObject(JavaScriptObject jso) /*-{
        if(jso.helper !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::helper = jso.helper[0];
        }
        if(jso.item !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::item = jso.item[0];
        }
        if(jso.placeholder !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::placeholder = jso.placeholder[0];
        }
        if(jso.sender !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::sender = jso.sender[0];
        }
        this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::setOffset(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.offset);
        this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::setOriginalPos(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.originalPosition);
        this.@nz.co.doltech.gwtjui.interactions.client.util.SortableHash::setPos(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.position);
    }-*/;
}
