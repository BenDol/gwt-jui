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
package nz.co.doltech.gwtjui.interactions.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjui.core.client.JuiWrapper;
import nz.co.doltech.gwtjui.core.client.js.JsFunction;
import nz.co.doltech.gwtjui.core.client.util.At;
import nz.co.doltech.gwtjui.core.client.util.Axis;
import nz.co.doltech.gwtjui.core.client.js.JsPoint;
import nz.co.doltech.gwtjui.core.client.events.ActivateEvent;
import nz.co.doltech.gwtjui.core.client.events.ActivateHandler;
import nz.co.doltech.gwtjui.core.client.events.BeforeStopEvent;
import nz.co.doltech.gwtjui.core.client.events.BeforeStopHandler;
import nz.co.doltech.gwtjui.core.client.events.ChangeEvent;
import nz.co.doltech.gwtjui.core.client.events.ChangeHandler;
import nz.co.doltech.gwtjui.core.client.events.CreateEvent;
import nz.co.doltech.gwtjui.core.client.events.CreateHandler;
import nz.co.doltech.gwtjui.core.client.events.DeactivateEvent;
import nz.co.doltech.gwtjui.core.client.events.DeactivateHandler;
import nz.co.doltech.gwtjui.core.client.events.OutEvent;
import nz.co.doltech.gwtjui.core.client.events.OutHandler;
import nz.co.doltech.gwtjui.core.client.events.OverEvent;
import nz.co.doltech.gwtjui.core.client.events.OverHandler;
import nz.co.doltech.gwtjui.core.client.events.ReceiveEvent;
import nz.co.doltech.gwtjui.core.client.events.ReceiveHandler;
import nz.co.doltech.gwtjui.core.client.events.RemoveEvent;
import nz.co.doltech.gwtjui.core.client.events.RemoveHandler;
import nz.co.doltech.gwtjui.core.client.events.SortEvent;
import nz.co.doltech.gwtjui.core.client.events.SortHandler;
import nz.co.doltech.gwtjui.core.client.events.StartEvent;
import nz.co.doltech.gwtjui.core.client.events.StartHandler;
import nz.co.doltech.gwtjui.core.client.events.StopEvent;
import nz.co.doltech.gwtjui.core.client.events.StopHandler;
import nz.co.doltech.gwtjui.core.client.events.UpdateEvent;
import nz.co.doltech.gwtjui.core.client.events.UpdateHandler;
import nz.co.doltech.gwtjui.interactions.client.util.HelpType;
import nz.co.doltech.gwtjui.interactions.client.util.Helper;
import nz.co.doltech.gwtjui.interactions.client.util.SortableHash;
import nz.co.doltech.gwtjui.interactions.client.util.Tolerance;

/**
 * Wraps: jQuery UI Sortable
 * Version: 1.11.4
 * Website: http://jqueryui.com
 * Docs: http://api.jqueryui.com/sortable/
 *
 * @author Ben Dol
 */
public class Sortable extends JuiWrapper {

    // Options
    private Element appendTo;
    private Axis axis;
    private String cancel;
    private boolean refreshPositions;
    private String connectWith;
    private Element containment;
    private Cursor cursor;
    private At cursorAt;
    private int delay;
    private boolean disabled;
    private double distance;
    private boolean dropOnEmpty;
    private boolean forceHelperSize;
    private boolean forcePlaceholderSize;
    private JsPoint grid;
    private Element handle;
    private Helper helper;
    private String items;
    private double opacity;
    private String placeholder;
    private double revert;
    private boolean scroll;
    private double scrollSensitivity;
    private double scrollSpeed;
    private Tolerance tolerance;
    private int zIndex;

    public Sortable(Element element) {
        super(element);
    }

    public Sortable(Widget widget) {
        super(widget);
    }

    public Sortable(Widget widget, UIObject appendTo) {
        super(widget);

        this.appendTo = appendTo.getElement();
    }

    // Setters/Getters

    public Element getAppendTo() {
        return appendTo;
    }

    /**
     * Defines where the helper that moves with the mouse is being
     * appended to during the drag (for example, to resolve overlap/zIndex issues).
     * @param appendTo parent {@link Element} to append to.
     */
    public void setAppendTo(Element appendTo) {
        this.appendTo = appendTo;
        setOption("appendTo", appendTo);
    }

    public Axis getAxis() {
        return axis;
    }

    /**
     * If defined, the items can be dragged only horizontally
     * or vertically. Possible values: "x", "y".
     */
    public void setAxis(Axis axis) {
        this.axis = axis;
        setOption("axis", axis);
    }

    public String getCancel() {
        return cancel;
    }

    /**
     * Prevents sorting if you start on elements matching the selector.<br/>
     * Default: "input,textarea,button,select,option"
     * @param cancel selector text.
     */
    public void setCancel(String cancel) {
        this.cancel = cancel;
        setOption("cancel", cancel);
    }

    public boolean getRefreshPositions() {
        return refreshPositions;
    }

    /**
     * Refresh the cached positions of the sortable items.
     * Calling this method refreshes the cached item positions of all sortables.
     */
    public void setRefreshPositions(boolean refreshPositions) {
        this.refreshPositions = refreshPositions;
        setOption("refreshPositions", refreshPositions);
    }

    public String getConnectWith() {
        return connectWith;
    }

    /**
     * A selector of other sortable elements that the items from this list
     * should be connected to. This is a one-way relationship, if you want
     * the items to be connected in both directions, the connectWith option
     * must be set on both sortable elements.
     * @param connectWith selector text.
     */
    public void setConnectWith(String connectWith) {
        this.connectWith = connectWith;
        setOption("cancel", connectWith);
    }

    public Element getContainment() {
        return containment;
    }

    /**
     * Defines a bounding box that the sortable items are constrained to while dragging.
     * <br/><br/>
     * Note: The element specified for containment must have a calculated width and height
     * (though it need not be explicit). For example, if you have float: left sortable children
     * and specify containment: "parent" be sure to have float: left on the sortable/parent
     * container as well or it will have height: 0, causing undefined behavior.
     * @param containment containment {@link Element}.
     */
    public void setContainment(Element containment) {
        this.containment = containment;
        setOption("containment", containment);
    }

    public Cursor getCursor() {
        return cursor;
    }

    /**
     * Defines the cursor that is being shown while sorting.<br/>
     * Default: {@link Cursor#AUTO}.
     * @param cursor cursor type.
     */
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        setOption("cursor", cursor);
    }

    public At getCursorAt() {
        return cursorAt;
    }

    /**
     * Moves the sorting element or helper so the cursor always appears to
     * drag from the same position. Coordinates can be given as a hash using
     * a combination of one or two keys: { top, left, right, bottom }.
     * @param cursorAt positional {@link At} movements.
     */
    public void setCursorAt(At cursorAt) {
        this.cursorAt = cursorAt;
        setOption("cursorAt", cursorAt);
    }

    public int getDelay() {
        return delay;
    }

    /**
     * Time in milliseconds to define when the sorting should start.
     * Adding a delay helps preventing unwanted drags when clicking
     * on an element.<br/> Default: 0
     * @param delay interval in milliseconds.
     */
    public void setDelay(int delay) {
        this.delay = delay;
        setOption("delay", delay);
    }

    public boolean isDisabled() {
        return disabled;
    }

    /**
     * Disables the sortable if set to true.<br/>
     * Default: false.
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
        setOption("disabled", disabled);
    }

    public double getDistance() {
        return distance;
    }

    /**
     * Tolerance, in pixels, for when sorting should start. If specified,
     * sorting will not start until after mouse is dragged beyond distance.
     * Can be used to allow for clicks on elements within a handle.
     * Default: 1
     */
    public void setDistance(double distance) {
        this.distance = distance;
        setOption("distance", distance);
    }

    public boolean isDropOnEmpty() {
        return dropOnEmpty;
    }

    /**
     * If false, items from this sortable can't be dropped on an empty connect
     * sortable (see the connectWith option.<br/>
     * Default: true
     */
    public void setDropOnEmpty(boolean dropOnEmpty) {
        this.dropOnEmpty = dropOnEmpty;
        setOption("dropOnEmpty", dropOnEmpty);
    }

    public boolean isForceHelperSize() {
        return forceHelperSize;
    }

    /**
     * If true, forces the helper to have a size.
     */
    public void setForceHelperSize(boolean forceHelperSize) {
        this.forceHelperSize = forceHelperSize;
        setOption("forceHelperSize", forceHelperSize);
    }

    public boolean isForcePlaceholderSize() {
        return forcePlaceholderSize;
    }

    /**
     * If true, forces the placeholder to have a size.
     */
    public void setForcePlaceholderSize(boolean forcePlaceholderSize) {
        this.forcePlaceholderSize = forcePlaceholderSize;
        setOption("forcePlaceholderSize", forcePlaceholderSize);
    }

    public JsPoint getGrid() {
        return grid;
    }

    /**
     * Snaps the sorting element or helper to a grid, every x and y pixels.
     * Array values: [ x, y ].<br/>
     * Default: false
     * @param grid an x,y {@link JsPoint}.
     */
    public void setGrid(JsPoint grid) {
        this.grid = grid;
        setOption("grid", grid);
    }

    public Element getHandle() {
        return handle;
    }

    /**
     * Restricts sort start click to the specified element.
     * @param handle handler {@link Element}.
     */
    public void setHandle(Element handle) {
        this.handle = handle;
        setOption("handle", handle);
    }

    public Helper getHelper() {
        return helper;
    }

    /**
     * Allows for a helper element to be used for dragging display.<br/>
     * Default: {@link HelpType#ORIGINAL}.
     */
    public void setHelper(HelpType helpType) {
        this.helper = new Helper(helpType);
        setOption("helper", helpType);
    }

    /**
     * Allows for a helper element to be used for dragging display.<br/>
     * Default: {@link HelpType#ORIGINAL}.
     */
    public void setHelper(JsFunction helper) {
        this.helper = new Helper(helper);
        setOption("helper", helper);
    }

    public String getItems() {
        return items;
    }

    /**
     * Specifies which items inside the element should be sortable.<br/>
     * Default: "> *"
     */
    public void setItems(String items) {
        this.items = items;
        setOption("items", items);
    }

    public double getOpacity() {
        return opacity;
    }

    /**
     * Defines the opacity of the helper while sorting. From 0.01 to 1.
     */
    public void setOpacity(double opacity) {
        this.opacity = opacity;
        setOption("opacity", opacity);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * A class name that gets applied to the otherwise white space.
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        setOption("placeholder", placeholder);
    }

    public double getRevert() {
        return revert;
    }

    /**
     * Whether the sortable items should revert to their new positions
     * using a smooth animation.<br/>
     * Default: false
     */
    public void setRevert(double revert) {
        this.revert = revert;
        setOption("revert", revert);
    }

    public boolean isScroll() {
        return scroll;
    }

    /**
     * If set to true, the page scrolls when coming to an edge.<br/>
     * Default: true
     */
    public void setScroll(boolean scroll) {
        this.scroll = scroll;
        setOption("scroll", scroll);
    }

    public double getScrollSensitivity() {
        return scrollSensitivity;
    }

    /**
     * Defines how near the mouse must be to an edge to start scrolling.<br/>
     * Default: 20
     */
    public void setScrollSensitivity(double scrollSensitivity) {
        this.scrollSensitivity = scrollSensitivity;
        setOption("scrollSensitivity", scrollSensitivity);
    }

    public double getScrollSpeed() {
        return scrollSpeed;
    }

    /**
     * The speed at which the window should scroll once the mouse pointer
     * gets within the scrollSensitivity distance.<br/>
     * Default: 20
     */
    public void setScrollSpeed(double scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
        setOption("scrollSpeed", scrollSpeed);
    }

    public Tolerance getTolerance() {
        return tolerance;
    }

    /**
     * Specifies which mode to use for testing whether the item being
     * moved is hovering over another item.<br/>
     * Default: {@link Tolerance#INTERSECT}
     */
    public void setTolerance(Tolerance tolerance) {
        this.tolerance = tolerance;
        setOption("tolerance", tolerance);
    }

    public int getzIndex() {
        return zIndex;
    }

    /**
     * Z-index for element/helper while being sorted.<br/>
     * Default: 1000
     */
    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
        setOption("zIndex", zIndex);
    }

    // Methods

    /**
     * Cancels a change in the current sortable and reverts it
     * to the state prior to when the current sort was started.
     * Useful in the stop and receive callback functions.
     */
    public void cancel() {
        command("cancel");
    }

    /**
     * Removes the sortable functionality completely.
     * This will return the element back to its pre-init state.
     */
    public void destroy() {
        command("destroy");
    }

    /**
     * Disables the sortable.
     */
    public void disable() {
        command("disable");
    }

    /**
     * Enables the sortable.
     */
    public void enable() {
        command("enable");
    }

    /**
     * Refresh the sortable items. Triggers the reloading of
     * all sortable items, causing new items to be recognized.
     */
    public void refresh() {
        command("refresh");
    }

    /**
     * Refresh the cached positions of the sortable items.
     * Calling this method refreshes the cached item positions
     * of all sortables.
     */
    public void refreshPositions() {
        command("refreshPositions");
    }

    @Override
    protected void remove(Element e) {
        destroy();
    };

    // Events

    /**
     * This event is triggered when using connected lists,
     * every connected list on drag start receives it.
     */
    public HandlerRegistration addActivateHandler(ActivateHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, ActivateEvent.getType());
    }

    private void onActivate(Event event, JavaScriptObject hash) {
        ActivateEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when sorting stops, but when
     * the placeholder/helper is still available.
     */
    public HandlerRegistration addBeforeStopHandler(BeforeStopHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, BeforeStopEvent.getType());
    }

    private void onBeforeStop(Event event, JavaScriptObject hash) {
        BeforeStopEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered during sorting, but only when
     * the DOM position has changed.
     */
    public HandlerRegistration addChangeHandler(ChangeHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, ChangeEvent.getType());
    }

    private void onChange(Event event, JavaScriptObject hash) {
        ChangeEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * Triggered when the sortable is created.
     */
    public HandlerRegistration addCreateHandler(CreateHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, CreateEvent.getType());
    }

    private void onCreate(Event event, JavaScriptObject hash) {
        CreateEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when sorting was stopped,
     * is propagated to all possible connected lists.
     */
    public HandlerRegistration addDeactivateHandler(DeactivateHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, DeactivateEvent.getType());
    }

    private void onDeactivate(Event event, JavaScriptObject hash) {
        DeactivateEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when a sortable item
     * is moved away from a sortable list.
     */
    public HandlerRegistration addOutHandler(OutHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, OutEvent.getType());
    }

    private void onOut(Event event, JavaScriptObject hash) {
        OutEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when a sortable item
     * is moved into a sortable list.
     */
    public HandlerRegistration addOverHandler(OverHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, OverEvent.getType());
    }

    private void onOver(Event event, JavaScriptObject hash) {
        OverEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when an item from a connected
     * sortable list has been dropped into another list.
     * The latter is the event target.
     */
    public HandlerRegistration addReceiveHandler(ReceiveHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, ReceiveEvent.getType());
    }

    private void onReceive(Event event, JavaScriptObject hash) {
        ReceiveEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when a sortable item
     * from the list has been dropped into another.
     * The former is the event target.
     */
    public HandlerRegistration addRemoveHandler(RemoveHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, RemoveEvent.getType());
    }

    private void onRemove(Event event, JavaScriptObject hash) {
        RemoveEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered during sorting.
     */
    public HandlerRegistration addSortHandler(SortHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, SortEvent.getType());
    }

    private void onSort(Event event, JavaScriptObject hash) {
        SortEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when sorting starts.
     */
    public HandlerRegistration addStartHandler(StartHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, StartEvent.getType());
    }

    private void onStart(Event event, JavaScriptObject hash) {
        StartEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when sorting has stopped.
     */
    public HandlerRegistration addStopHandler(StopHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, StopEvent.getType());
    }

    private void onStop(Event event, JavaScriptObject hash) {
        StopEvent.fire(this, new SortableHash(hash), event);
    }

    /**
     * This event is triggered when the user stopped
     * sorting and the DOM position has changed.
     */
    public HandlerRegistration addUpdateHandler(UpdateHandler<Sortable, SortableHash> handler) {
        return addHandler(handler, UpdateEvent.getType());
    }

    private void onUpdate(Event event, JavaScriptObject hash) {
        UpdateEvent.fire(this, new SortableHash(hash), event);
    }

    // Native Methods

    @Override
    protected native void initialize(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).sortable({
            activate: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onActivate(*)(e, ui);
            },
            beforeStop: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onBeforeStop(*)(e, ui);
            },
            change: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onChange(*)(e, ui);
            },
            deactivate: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onDeactivate(*)(e, ui);
            },
            out: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onOut(*)(e, ui);
            },
            over: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onOver(*)(e, ui);
            },
            receive: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onReceive(*)(e, ui);
            },
            remove: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onRemove(*)(e, ui);
            },
            sort: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onSort(*)(e, ui);
            },
            start: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onStart(*)(e, ui);
            },
            stop: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onStop(*)(e, ui);
            },
            update: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Sortable::onUpdate(*)(e, ui);
            }
        });
    }-*/;

    @Override
    protected native String getOption(Element e, String option) /*-{
        return $wnd.jQuery(e).sortable("option", option);
    }-*/;

    @Override
    protected native void setOption(Element e, String option, Object value) /*-{
        $wnd.jQuery(e).sortable("option", option, value);
    }-*/;

    @Override
    protected native void command(Element e, Object command) /*-{
        $wnd.jQuery(e).sortable(command);
    }-*/;
}
