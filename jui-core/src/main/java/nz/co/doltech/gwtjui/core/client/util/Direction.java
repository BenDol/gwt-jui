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

import com.google.gwt.dom.client.Style;

/**
 * Enum for the float property.
 */
public enum Direction implements Style.HasCssName {
    LEFT {
        @Override
        public String getCssName() {
            return "left";
        }
    },
    RIGHT {
        @Override
        public String getCssName() {
            return "right";
        }
    },
    TOP {
        @Override
        public String getCssName() {
            return "top";
        }
    },
    BOTTOM {
        @Override
        public String getCssName() {
            return "bottom";
        }
    };
    @Override
    public abstract String getCssName();

    @Override
    public String toString() {
        return getCssName();
    }
}
