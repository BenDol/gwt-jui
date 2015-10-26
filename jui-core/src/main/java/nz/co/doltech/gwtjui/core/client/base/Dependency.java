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

import com.google.gwt.core.client.JavaScriptException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dependency<T extends AbstractEntryPoint> {

    private final static Logger logger = Logger.getLogger(Dependency.class.getName());

    public interface WhenLoaded {
        void onLoaded();
    }

    public interface LoadCheck<L extends AbstractEntryPoint> {
        boolean loadCheck();
        void onLoad(L entryPoint);
    }

    private final String name;
    private final LoadCheck<T> loadCheck;
    private final List<WhenLoaded> whenLoadeds;

    public Dependency(LoadCheck<T> loadCheck, String name) {
        this.loadCheck = loadCheck;
        this.name = name;
        this.whenLoadeds = new ArrayList<>();
    }

    public boolean isLoaded() {
        try {
            return loadCheck.loadCheck();
        } catch (JavaScriptException ex) {
            logger.log(Level.FINE, "Dependency load check threw: ", ex);
            return false;
        }
    }

    public void onLoad(T entry) {
        loadCheck.onLoad(entry);
    }

    public void onLoaded(T entry) {
        for(WhenLoaded whenLoaded : whenLoadeds) {
            whenLoaded.onLoaded();
        }
    }

    public LoadCheck<T> getLoadCheck() {
        return loadCheck;
    }

    public String getName() {
        return name;
    }

    public void whenLoaded(WhenLoaded whenLoaded) {
        if(isLoaded()) {
            whenLoaded.onLoaded();
        } else {
            if (!whenLoadeds.contains(whenLoaded)) {
                whenLoadeds.add(whenLoaded);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependency<?> that = (Dependency<?>) o;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
