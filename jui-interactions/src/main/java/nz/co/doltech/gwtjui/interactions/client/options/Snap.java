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

public class Snap implements MultiTypeOption {
    private Boolean autoSnap;
    private String selector;

    public Snap(Boolean autoSnap) {
        this.autoSnap = autoSnap;
    }

    public Snap(String selector) {
        this.selector = selector;
    }

    @Override
    public Object get() {
        return selector != null ? selector : autoSnap;
    }
}
