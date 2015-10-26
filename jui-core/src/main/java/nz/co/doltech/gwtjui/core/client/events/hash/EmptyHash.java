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
package nz.co.doltech.gwtjui.core.client.events.hash;

import com.google.gwt.core.client.JavaScriptObject;
import nz.co.doltech.gwtjui.core.client.base.EventHash;

public class EmptyHash implements EventHash {

    public EmptyHash(JavaScriptObject hash) {
        fromJavaScriptObject(hash);
    }

    @Override
    public void fromJavaScriptObject(JavaScriptObject jso) {}
}
