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

import com.google.gwt.dom.client.Element;
import nz.co.doltech.gwtjui.core.client.base.MultiTypeOption;
import nz.co.doltech.gwtjui.core.client.util.Container;

public class Containment implements MultiTypeOption {
    private String selector;
    private Element element;
    private Container container;

    public Containment(String selector) {
        this.selector = selector;
    }

    public Containment(Element element) {
        this.element = element;
    }

    public Containment(Container container) {
        this.container = container;
    }

    @Override
    public Object get() {
        if(selector != null) {
            return selector;
        } else if(element != null) {
            return element;
        } else {
            return container;
        }
    }
}
