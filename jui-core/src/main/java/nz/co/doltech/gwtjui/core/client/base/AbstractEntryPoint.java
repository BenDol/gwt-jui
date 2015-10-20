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
package nz.co.doltech.gwtjui.core.client.base;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.TextResource;

import java.util.logging.Logger;

public abstract class AbstractEntryPoint<T extends AbstractEntryPoint> implements EntryPoint {

    private Logger logger;

    public AbstractEntryPoint(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void onModuleLoad() {
        final DependencySet<T> dependencies = setupDependencies();
        if(dependencies != null) {
            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                private int tries = 0;
                @Override
                public boolean execute() {
                    tries++;
                    if(tries > 100) {
                        logger.warning("Dependencies are taking an abnormally " +
                            "long time to load: " + dependencies);
                    }

                    boolean ready = dependencies.isReady();
                    if(ready) {
                        AbstractEntryPoint.this.invokeLoad();
                    }
                    return ready;
                }
            }, 400);
        } else {
            invokeLoad();
        }
    }

    @SuppressWarnings("unchecked")
    private void invokeLoad() {
        Dependency<T> dependency = getDependency();
        if(!dependency.isLoaded()) {
            dependency.onLoad((T) this);
            load();
        }
    }

    protected abstract void load();

    public abstract Dependency<T> getDependency();

    protected abstract DependencySet<T> setupDependencies();

    protected void inject(TextResource resource, boolean removeTag) {
        ScriptInjector.fromString(resource.getText())
            .setWindow(ScriptInjector.TOP_WINDOW)
            .setRemoveTag(removeTag)
            .inject();
    }
}
