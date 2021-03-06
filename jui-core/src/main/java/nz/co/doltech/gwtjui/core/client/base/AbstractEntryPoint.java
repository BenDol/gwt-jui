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
import com.google.gwt.user.client.Command;

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
            if(dependencies.contains(getDependency())) {
                throw new IllegalStateException("Cannot define itself as its own dependency: "
                    + getDependency().getName());
            }

            for(Dependency dependency : dependencies) {
                dependency.whenLoaded(new Dependency.WhenLoaded() {
                    @Override
                    public void onLoaded() {
                        if(dependencies.isReady()) {
                            AbstractEntryPoint.this.invokeLoad();
                        }
                    }
                });
            }
        } else {
            invokeLoad();
        }
    }

    @SuppressWarnings("unchecked")
    private void invokeLoad() {
        final Dependency<T> dependency = getDependency();
        if(!dependency.isLoaded()) {
            final T entryPoint = (T) AbstractEntryPoint.this;
            dependency.onLoad(entryPoint);
            load();

            Scheduler.get().scheduleDeferred(new Command() {
                @Override
                public void execute() {
                    dependency.onLoaded(entryPoint);
                }
            });
            logger.fine("Loaded JQueryUI dependency: " + dependency.getName());
        }
    }

    protected abstract void load();

    public abstract Dependency<T> getDependency();

    protected abstract DependencySet<T> setupDependencies();

    protected void inject(TextResource resource, boolean removeTag, boolean sourceUrl) {
        String text = resource.getText() +
            (sourceUrl ? "//# sourceURL="+resource.getName()+".js" : "");

        // Inject the script resource
        ScriptInjector.fromString(text)
            .setWindow(ScriptInjector.TOP_WINDOW)
            .setRemoveTag(removeTag)
            .inject();
    }

    public Logger getLogger() {
        return logger;
    }
}
