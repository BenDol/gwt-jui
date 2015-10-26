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

public enum Easing implements Style.HasCssName {
    LINEAR {
        @Override
        public String getCssName() {
            return "linear";
        }
    },
    SWING {
        @Override
        public String getCssName() {
            return "swing";
        }
    },
    EASE_IN_QUAD {
        @Override
        public String getCssName() {
            return "easeInQuad";
        }
    },
    EASE_OUT_QUAD {
        @Override
        public String getCssName() {
            return "easeOutQuad";
        }
    },
    EASE_IN_OUT_QUAD {
        @Override
        public String getCssName() {
            return "easeInOutQuad";
        }
    },
    EASE_IN_CUBIC {
        @Override
        public String getCssName() {
            return "easeInCubic";
        }
    },
    EASE_OUT_CUBIC {
        @Override
        public String getCssName() {
            return "easeOutCubic";
        }
    },
    EASE_IN_OUT_CUBIC {
        @Override
        public String getCssName() {
            return "easeInOutCubic";
        }
    },
    EASE_IN_QUART {
        @Override
        public String getCssName() {
            return "easeInQuart";
        }
    },
    EASE_OUT_QUART {
        @Override
        public String getCssName() {
            return "easeOutQuart";
        }
    },
    EASE_IN_OUT_QUART {
        @Override
        public String getCssName() {
            return "easeInOutQuart";
        }
    },
    EASE_IN_QUINT {
        @Override
        public String getCssName() {
            return "easeInQuint";
        }
    },
    EASE_OUT_QUINT {
        @Override
        public String getCssName() {
            return "easeOutQuint";
        }
    },
    EASE_IN_OUT_QUINT {
        @Override
        public String getCssName() {
            return "easeInOutQuint";
        }
    },
    EASE_IN_EXPO {
        @Override
        public String getCssName() {
            return "easeInExpo";
        }
    },
    EASE_OUT_EXPO {
        @Override
        public String getCssName() {
            return "easeOutExpo";
        }
    },
    EASE_IN_OUT_EXPO {
        @Override
        public String getCssName() {
            return "easeInOutExpo";
        }
    },
    EASE_IN_SINE {
        @Override
        public String getCssName() {
            return "easeInSine";
        }
    },
    EASE_OUT_SINE {
        @Override
        public String getCssName() {
            return "easeOutSine";
        }
    },
    EASE_IN_OUT_SINE {
        @Override
        public String getCssName() {
            return "easeInOutSine";
        }
    },
    EASE_IN_CIRC {
        @Override
        public String getCssName() {
            return "easeInCirc";
        }
    },
    EASE_OUT_CIRC {
        @Override
        public String getCssName() {
            return "easeOutCirc";
        }
    },
    EASE_IN_OUT_CIRC {
        @Override
        public String getCssName() {
            return "easeInOutCirc";
        }
    },
    EASE_IN_ELASTIC {
        @Override
        public String getCssName() {
            return "easeInElastic";
        }
    },
    EASE_OUT_ELASTIC {
        @Override
        public String getCssName() {
            return "easeOutElastic";
        }
    },
    EASE_IN_OUT_ELASTIC {
        @Override
        public String getCssName() {
            return "easeInOutElastic";
        }
    },
    EASE_IN_BACK {
        @Override
        public String getCssName() {
            return "easeInBack";
        }
    },
    EASE_OUT_BACK {
        @Override
        public String getCssName() {
            return "easeOutBack";
        }
    },
    EASE_IN_OUT_BACK {
        @Override
        public String getCssName() {
            return "easeInOutBack";
        }
    },
    EASE_IN_BOUNCE {
        @Override
        public String getCssName() {
            return "easeInBounce";
        }
    },
    EASE_OUT_BOUNCE {
        @Override
        public String getCssName() {
            return "easeOutBounce";
        }
    },
    EASE_IN_OUT_BOUNCE {
        @Override
        public String getCssName() {
            return "easeInOutBounce";
        }
    };
    @Override
    public abstract String getCssName();

    @Override
    public String toString() {
        return getCssName();
    }
}
