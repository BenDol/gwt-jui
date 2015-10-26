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

import com.google.gwt.dom.client.Style;

public enum SnapMode implements Style.HasCssName {
    INNER {
        @Override
        public String getCssName() {
            return "inner";
        }
    },
    OUTER {
        @Override
        public String getCssName() {
            return "outer";
        }
    },
    BOTH {
        @Override
        public String getCssName() {
            return "both";
        }
    };
    @Override
    public abstract String getCssName();

    public static SnapMode fromCssName(String cssName) {
        for(SnapMode t : values()) {
            if(t.getCssName().equals(cssName)) { return t; }
        }
        return null;
    }
}