/**
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
package nz.co.doltech.gwtjui.core.client;

import nz.co.doltech.gwtjui.core.client.base.Dependency;

public class WithJQueryEntryPoint extends CoreEntryPoint {

    private static final Dependency<CoreEntryPoint> dependency = new Dependency<>(
            new Dependency.LoadCheck<CoreEntryPoint>() {
        @Override
        public boolean loadCheck() {
            return isJQueryLoaded();
        }
        @Override
        public void onLoad(CoreEntryPoint entryPoint) {}
    }, "JQuery");

    @Override
    public void onModuleLoad() {
        if(!isJQueryLoaded()) {
            inject(WithJQueryClientBundle.INSTANCE.jquery(), true, false);
        }

        super.onModuleLoad();
    }

    public static Dependency<CoreEntryPoint> asDependency() {
        return dependency;
    }

    /**
     * Check to see if jQuery is loaded already
     *
     * @return true is jQuery is loaded, false otherwise
     */
    public static native boolean isJQueryLoaded() /*-{
        return (typeof $wnd['jQuery'] !== 'undefined');
    }-*/;
}
