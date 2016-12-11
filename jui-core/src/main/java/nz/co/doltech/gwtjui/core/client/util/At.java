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
package nz.co.doltech.gwtjui.core.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import nz.co.doltech.gwtjui.core.client.js.Js;

/**
 * @author Ben Dol
 */
public class At extends JavaScriptObject {

    protected At() {}

    public native final void setLeft(double left) /*-{
        this.left = left;
    }-*/;

    public native final void setRight(double right) /*-{
        this.right = right;
    }-*/;

    public native final void setTop(double top) /*-{
        this.top = top;
    }-*/;

    public native final void setBottom(double bottom) /*-{
        this.bottom = bottom;
    }-*/;

    public native static At fromJavaScriptObject(JavaScriptObject jso) /*-{
        if(jso !== undefined) {
            return @nz.co.doltech.gwtjui.core.client.util.At::createAt(*)(
                jso.left, jso.right, jso.top, jso.bottom);
        } else {
            return null;
        }
    }-*/;

    protected static At createAt(double left, double right, double top, double bottom) {
        At at = JavaScriptObject.createObject().cast();
        if(!Js.isUndefinedOrNull(left)) {
            at.setLeft(left);
        }
        if(!Js.isUndefinedOrNull(right)) {
            at.setRight(right);
        }
        if(!Js.isUndefinedOrNull(top)) {
            at.setTop(top);
        }
        if(!Js.isUndefinedOrNull(bottom)) {
            at.setBottom(bottom);
        }
        return at;
    }
}
