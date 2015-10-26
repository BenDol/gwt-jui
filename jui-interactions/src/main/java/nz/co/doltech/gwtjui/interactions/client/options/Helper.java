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
package nz.co.doltech.gwtjui.interactions.client.options;

import nz.co.doltech.gwtjui.core.client.base.MultiTypeOption;
import nz.co.doltech.gwtjui.core.client.js.JsFunction;

public class Helper implements MultiTypeOption {
    private HelpType helpType;
    private JsFunction callback;

    public Helper(HelpType helpType) {
        this.helpType = helpType;
    }

    public Helper(JsFunction callback) {
        this.callback = callback;
    }

    @Override
    public Object get() {
        return callback != null ? callback : helpType;
    }
}
