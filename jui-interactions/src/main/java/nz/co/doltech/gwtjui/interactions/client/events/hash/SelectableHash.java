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

public class SelectableHash implements EventHash {

    private Element selected;

    public SelectableHash(JavaScriptObject hash) {
        fromJavaScriptObject(hash);
    }

    public Element getSelected() {
        return selected;
    }

    public void setSelected(Element selected) {
        this.selected = selected;
    }

    @Override
    public native void fromJavaScriptObject(JavaScriptObject jso) /*-{
        if(jso.selected !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.SelectableHash::selected = jso.selected[0];
        } else if(jso.selecting !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.SelectableHash::selected = jso.selecting[0];
        } else if(jso.unselected !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.SelectableHash::selected = jso.unselected[0];
        } else if(jso.unselecting !== null) {
            this.@nz.co.doltech.gwtjui.interactions.client.events.hash.SelectableHash::selected = jso.unselecting[0];
        }
    }-*/;
}
