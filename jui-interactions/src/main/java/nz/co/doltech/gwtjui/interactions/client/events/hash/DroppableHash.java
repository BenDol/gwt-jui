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

public class DroppableHash implements EventHash {

    private Element draggable;
    private Element helper;
    private At offset;
    private At pos;

    public DroppableHash(JavaScriptObject hash) {
        fromJavaScriptObject(hash);
    }

    public Element getHelper() {
        return helper;
    }

    public void setHelper(Element helper) {
        this.helper = helper;
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
        if(jso.draggable !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.DroppableHash::draggable = jso.draggable[0];
        }
        if(jso.helper !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.DroppableHash::helper = jso.helper[0];
        }
        this.@nz.co.doltech.gwtjui.interactions.client.events.hash.DroppableHash::setOffset(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.offset);
        this.@nz.co.doltech.gwtjui.interactions.client.events.hash.DroppableHash::setPos(Lcom/google/gwt/core/client/JavaScriptObject;)(jso.position);
    }-*/;
}
