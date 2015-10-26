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

/**
 * A mapping of key code descriptions to their numeric values.
 */
public enum KeyCode {
    BACKSPACE(8),
    COMMA(188),
    DELETE(46),
    DOWN(40),
    END(35),
    ENTER(13),
    ESCAPE(27),
    HOME(36),
    LEFT(37),
    PAGE_DOWN(34),
    PAGE_UP(33),
    PERIOD(190),
    RIGHT(39),
    SPACE(32),
    TAB(9),
    UP(38);

    int code;
    KeyCode(int code) { this.code = code; }
}
