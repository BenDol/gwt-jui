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
package nz.co.doltech.gwtjui.interactions.client;

import nz.co.doltech.gwtjui.core.client.CoreEntryPoint;
import nz.co.doltech.gwtjui.core.client.base.AbstractEntryPoint;
import nz.co.doltech.gwtjui.core.client.base.Dependency;
import nz.co.doltech.gwtjui.core.client.base.DependencySet;

public class InteractionsEntryPoint extends AbstractEntryPoint<InteractionsEntryPoint> {

    private static final Dependency<InteractionsEntryPoint> dependency = new Dependency<>(
            new Dependency.LoadCheck<InteractionsEntryPoint>() {
        @Override
        public boolean loadCheck() {
            return isInteractionsLoaded();
        }
        @Override
        public void onLoad(InteractionsEntryPoint entryPoint) {}
    });

    @Override
    protected void load() {
        inject(InteractionsClientBundle.INSTANCE.jqueryUi(), false);
    }

    @Override
    protected DependencySet<InteractionsEntryPoint> setupDependencies() {
        return new DependencySet<>(this,
            CoreEntryPoint.asDependency()
        );
    }

    @Override
    public Dependency<InteractionsEntryPoint> getDependency() {
        return asDependency();
    }

    public static Dependency<InteractionsEntryPoint> asDependency() {
        return dependency;
    }

    /**
     * Check to see if jQuery is loaded already
     *
     * @return true is jQuery is loaded, false otherwise
     */
    protected static native boolean isInteractionsLoaded() /*-{
        return (typeof $wnd['jQuery'].ui.draggable !== 'undefined')
            && (typeof $wnd['jQuery'].ui.resizable !== 'undefined')
            && (typeof $wnd['jQuery'].ui.selectable !== 'undefined')
            && (typeof $wnd['jQuery'].ui.sortable !== 'undefined');
    }-*/;
}
