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

import java.util.Arrays;
import java.util.HashSet;

public class DependencySet<T extends AbstractEntryPoint> extends HashSet<Dependency> {

    private T entry;

    public DependencySet() {
    }

    public DependencySet(T entry) {
        this.entry = entry;
    }

    public DependencySet(T entry, Dependency... deps) {
        super(Arrays.asList(deps));
        this.entry = entry;
    }

    public T getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entry.getClass().getName();
    }

    public boolean isReady() {
        for (Dependency dependency : this) {
            if (!dependency.isLoaded()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "[ ";
        boolean useComma = false;
        for (Dependency dependency : this) {
            result += useComma ? ", " : "";
            result += dependency.getName();
            result += ": " + dependency.isLoaded();
            useComma = true;
        }
        result += " ]";
        return result;
    }
}
