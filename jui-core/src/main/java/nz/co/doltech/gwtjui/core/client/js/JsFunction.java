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
package nz.co.doltech.gwtjui.core.client.js;

import com.google.gwt.core.client.JavaScriptObject;
import nz.co.doltech.gwtjui.core.client.base.IsJavaScriptObject;

public class JsFunction implements IsJavaScriptObject {

    private JavaScriptObject func;

    private JsFunction() {}

    public JsFunction(final Runnable runnable) {
        this.func = toFunction(runnable);
    }

    public native JavaScriptObject toFunction(final Runnable runnable) /*-{
        return function() {
            runnable.@java.lang.Runnable::run()();
        }
    }-*/;

    public static JsFunction blank() {
        return new JsFunction();
    }

    @Override
    public JavaScriptObject asJavaScript() {
        return func;
    }
}
