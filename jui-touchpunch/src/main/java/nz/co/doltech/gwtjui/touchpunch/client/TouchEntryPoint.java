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
package nz.co.doltech.gwtjui.touchpunch.client;

import nz.co.doltech.gwtjui.core.client.base.AbstractEntryPoint;
import nz.co.doltech.gwtjui.core.client.base.Dependency;
import nz.co.doltech.gwtjui.core.client.base.DependencySet;
import nz.co.doltech.gwtjui.interactions.client.InteractionsEntryPoint;

import java.util.logging.Logger;

public class TouchEntryPoint extends AbstractEntryPoint<TouchEntryPoint> {

    private static boolean loaded;

    private static final Dependency<TouchEntryPoint> dependency = new Dependency<>(
            new Dependency.LoadCheck<TouchEntryPoint>() {
        @Override
        public boolean loadCheck() {
            return loaded;
        }
        @Override
        public void onLoad(TouchEntryPoint entryPoint) {}
    }, "TouchPunch");

    public TouchEntryPoint() {
        super(Logger.getLogger(TouchEntryPoint.class.getName()));
    }

    @Override
    public void load() {
        inject(TouchClientBundle.INSTANCE.touchPunch(), true, false);
        loaded = true;
    }

    @Override
    protected DependencySet<TouchEntryPoint> setupDependencies() {
        return new DependencySet<>(this,
            InteractionsEntryPoint.asDependency()
        );
    }

    @Override
    public Dependency<TouchEntryPoint> getDependency() {
        return asDependency();
    }

    public static Dependency<TouchEntryPoint> asDependency() {
        return dependency;
    }
}
