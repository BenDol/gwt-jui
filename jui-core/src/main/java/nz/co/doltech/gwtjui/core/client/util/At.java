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
package nz.co.doltech.gwtjui.core.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben Dol
 */
public class At {
    private List<Movement> movements = new ArrayList<>();

    public At(Movement... movements) {
        if (movements != null) {
            for (Movement movement : movements) {
                addMovement(movement);
            }
        }
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void addMovement(Movement movement) {
        if (!movements.contains(movement)) {
            movements.add(movement);
        } else {
            throw new RuntimeException(
                "Cannot add multiple " + movement.getDirection() + " directions.");
        }
    }

    public native static At fromJavaScriptObject(JavaScriptObject jso) /*-{
        if(jso !== undefined) {
            return @nz.co.doltech.gwtjui.core.client.util.At::newInstance(*)(jso.left, jso.right, jso.top, jso.bottom);
        } else {
            return null;
        }
    }-*/;

    protected static At newInstance(double left, double right, double top, double bottom) {
        At at = new At();
        at.addMovement(new Movement(Direction.LEFT, left, Style.Unit.PX));
        at.addMovement(new Movement(Direction.RIGHT, right, Style.Unit.PX));
        at.addMovement(new Movement(Direction.TOP, top, Style.Unit.PX));
        at.addMovement(new Movement(Direction.BOTTOM, bottom, Style.Unit.PX));
        return at;
    }

    @Override
    public String toString() {
        String result = "{";
        boolean useComma = false;
        for(Movement movement : movements) {
            result += (useComma ? ", " : "") + movement.toString();
            useComma = true;
        }
        return result + "}";
    }
}
