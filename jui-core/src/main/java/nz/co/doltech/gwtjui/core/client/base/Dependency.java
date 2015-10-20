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

public class Dependency<T extends AbstractEntryPoint> {

    public interface LoadCheck<L extends AbstractEntryPoint> {
        boolean loadCheck();
        void onLoad(L entryPoint);
    }

    private final String name;
    private final LoadCheck<T> loadCheck;

    public Dependency(LoadCheck<T> loadCheck, String name) {
        this.loadCheck = loadCheck;
        this.name = name;
    }

    public boolean isLoaded() {
        return loadCheck.loadCheck();
    }

    public void onLoad(T entry) {
        loadCheck.onLoad(entry);
    }

    public LoadCheck<T> getLoadCheck() {
        return loadCheck;
    }

    public String getName() {
        return name;
    }
}
