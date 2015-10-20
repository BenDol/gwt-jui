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
package nz.co.doltech.gwtjui.core.client.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsArrayUtil {

    public static JsArrayString fromStrings(Collection<String> collection) {
        JsArrayString array = JsArrayString.createArray().cast();
        for(String item : collection) {
            array.push(item);
        }
        return array;
    }

    public static JsArrayInteger fromIntegers(Collection<Integer> collection) {
        JsArrayInteger array = JsArrayInteger.createArray().cast();
        for(Integer item : collection) {
            array.push(item);
        }
        return array;
    }

    public static JsArrayBoolean fromBooleans(Collection<Boolean> collection) {
        JsArrayBoolean array = JsArrayBoolean.createArray().cast();
        for(Boolean item : collection) {
            array.push(item);
        }
        return array;
    }

    public static JsArrayNumber fromDoubles(Collection<Double> collection) {
        JsArrayNumber array = JsArrayNumber.createArray().cast();
        for(Double item : collection) {
            array.push(item);
        }
        return array;
    }

    public static List<String> toList(JsArrayString array) {
        List<String> list = new ArrayList<>();
        if(array != null) {
            for (int i = 0; i < array.length(); i++) {
                list.add(array.get(i));
            }
        }
        return list;
    }

    public static List<Double> toList(JsArrayNumber array) {
        List<Double> list = new ArrayList<>();
        if(array != null) {
            for (int i = 0; i < array.length(); i++) {
                list.add(array.get(i));
            }
        }
        return list;
    }

    public static List<Integer> toList(JsArrayInteger array) {
        List<Integer> list = new ArrayList<>();
        if(array != null) {
            for (int i = 0; i < array.length(); i++) {
                list.add(array.get(i));
            }
        }
        return list;
    }

    public static List<Boolean> toList(JsArrayBoolean array) {
        List<Boolean> list = new ArrayList<>();
        if(array != null) {
            for (int i = 0; i < array.length(); i++) {
                list.add(array.get(i));
            }
        }
        return list;
    }
}
