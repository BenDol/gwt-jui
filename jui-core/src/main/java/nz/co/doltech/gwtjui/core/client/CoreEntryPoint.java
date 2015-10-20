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

import nz.co.doltech.gwtjui.core.client.base.AbstractEntryPoint;
import nz.co.doltech.gwtjui.core.client.base.Dependency;
import nz.co.doltech.gwtjui.core.client.base.DependencySet;

import java.util.logging.Logger;

public class CoreEntryPoint extends AbstractEntryPoint<CoreEntryPoint> {

    private static final Dependency<CoreEntryPoint> dependency = new Dependency<>(
            new Dependency.LoadCheck<CoreEntryPoint>() {
        @Override
        public boolean loadCheck() {
            return isJQueryUiLoaded();
        }
        @Override
        public void onLoad(CoreEntryPoint entryPoint) {}
    }, "Core");

    public CoreEntryPoint() {
        super(Logger.getLogger(CoreEntryPoint.class.getName()));
    }

    @Override
    public void load() {
        inject(CoreClientBundle.INSTANCE.juiCore(), true, false);
    }

    @Override
    protected DependencySet<CoreEntryPoint> setupDependencies() {
        return new DependencySet<>(this,
            WithJQueryEntryPoint.asDependency()
        );
    }

    @Override
    public Dependency<CoreEntryPoint> getDependency() {
        return asDependency();
    }

    public static Dependency<CoreEntryPoint> asDependency() {
        return dependency;
    }

    /**
     * Check to see if jQuery is loaded already
     *
     * @return true is jQuery is loaded, false otherwise
     */
    protected static native boolean isJQueryUiLoaded() /*-{
        return (typeof $wnd['jQuery'].ui !== 'undefined');
    }-*/;
}
