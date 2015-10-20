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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ben Dol
 */
public class At {
    private Map<Direction, Movement> movements = new HashMap<>();

    public List<Movement> getMovements() {
        return new ArrayList<>(movements.values());
    }

    public Movement getMovement(Direction direction) {
        return movements.get(direction);
    }

    public void setLeft(Movement.Left left) {
        assert left.getDirection().equals(Direction.LEFT) : "Move is not left";
        movements.put(Direction.LEFT, left);
    }

    public void setRight(Movement.Right right) {
        assert right.getDirection().equals(Direction.RIGHT) : "Move is not right";
        movements.put(Direction.RIGHT, right);
    }

    public void setTop(Movement.Top top) {
        assert top.getDirection().equals(Direction.TOP) : "Move is not top";
        movements.put(Direction.TOP, top);
    }

    public void setBottom(Movement.Bottom bottom) {
        assert bottom.getDirection().equals(Direction.BOTTOM) : "Move is not bottom";
        movements.put(Direction.BOTTOM, bottom);
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
        if(!new Double(left).isNaN()) {
            at.setLeft(new Movement.Left(left, Style.Unit.PX));
        }
        if(!new Double(right).isNaN()) {
            at.setRight(new Movement.Right(right, Style.Unit.PX));
        }
        if(!new Double(top).isNaN()) {
            at.setTop(new Movement.Top(top, Style.Unit.PX));
        }
        if(!new Double(bottom).isNaN()) {
            at.setBottom(new Movement.Bottom(bottom, Style.Unit.PX));
        }
        return at;
    }

    @Override
    public String toString() {
        String result = "{";
        boolean useComma = false;
        for(Movement movement : movements.values()) {
            result += (useComma ? ", " : "") + movement.toString();
            useComma = true;
        }
        return result + "}";
    }
}
