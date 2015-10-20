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

import com.google.gwt.dom.client.Style;

public class Movement {
    private Direction direction;
    private double amount;
    private Style.Unit unit;

    public Movement(Direction direction, double amount, Style.Unit unit) {
        this.direction = direction;
        this.amount = amount;
        this.unit = unit;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Style.Unit getUnit() {
        return unit;
    }

    public void setUnit(Style.Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movement movement = (Movement) o;

        return direction == movement.direction;
    }

    @Override
    public int hashCode() {
        return direction.hashCode();
    }

    @Override
    public String toString() {
        return direction.getCssName() + ":" + amount + unit.getType();
    }
}
