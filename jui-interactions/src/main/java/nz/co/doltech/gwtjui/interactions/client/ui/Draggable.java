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
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjui.core.client.JuiWrapper;
import nz.co.doltech.gwtjui.core.client.events.CreateEvent;
import nz.co.doltech.gwtjui.core.client.events.CreateHandler;
import nz.co.doltech.gwtjui.core.client.events.StartEvent;
import nz.co.doltech.gwtjui.core.client.events.StartHandler;
import nz.co.doltech.gwtjui.core.client.events.StopEvent;
import nz.co.doltech.gwtjui.core.client.events.StopHandler;
import nz.co.doltech.gwtjui.core.client.events.hash.EmptyHash;
import nz.co.doltech.gwtjui.core.client.util.At;
import nz.co.doltech.gwtjui.core.client.util.Axis;
import nz.co.doltech.gwtjui.core.client.util.CursorUtil;
import nz.co.doltech.gwtjui.interactions.client.base.UsesMouseLayer;
import nz.co.doltech.gwtjui.interactions.client.events.DragEvent;
import nz.co.doltech.gwtjui.interactions.client.events.DragHandler;
import nz.co.doltech.gwtjui.interactions.client.events.hash.DraggableHash;
import nz.co.doltech.gwtjui.interactions.client.options.Handle;
import nz.co.doltech.gwtjui.interactions.client.options.HelpType;
import nz.co.doltech.gwtjui.interactions.client.options.Helper;
import nz.co.doltech.gwtjui.interactions.client.options.IFrameFix;
import nz.co.doltech.gwtjui.interactions.client.options.Revert;
import nz.co.doltech.gwtjui.interactions.client.options.Snap;
import nz.co.doltech.gwtjui.interactions.client.options.SnapMode;

/**
 * jQuery UI Draggable
 * <ul>
 *   <li>Version: 1.11.4</li>
 *   <li>Website: http://jqueryui.com</li>
 *   <li>Docs: http://api.jqueryui.com/draggable/</li>
 * </ul>
 * Allow elements to be moved using the mouse.
 *
 * @author Ben Dol
 */
public class Draggable extends JuiWrapper implements UsesMouseLayer {

    private MouseLayer mouseLayer;

    public Draggable(Element element) {
        super(element);
        mouseLayer = new MouseLayer(element);
    }

    public Draggable(Widget widget) {
        super(widget);
        mouseLayer = new MouseLayer(widget);
    }

    // Options

    public boolean getAddClasses() {
        return getOption("addClasses");
    }

    /**
     * If set to false, will prevent the ui-draggable class from being added.
     * This may be desired as a performance optimization when calling .draggable()
     * on hundreds of elements.
     */
    public void setAddClasses(boolean addClasses) {
        setOption("addClasses", addClasses);
    }

    /**
     * Which element the draggable helper should be appended to while dragging.<br/>
     * <b>Note:</b> The appendTo option only works when the helper option is set to
     * not use the original element.
     */
    public Object getAppendTo() {
        return getOption("appendTo");
    }

    public Axis getAxis() {
        return Axis.fromCssName((String) getOption("axis"));
    }

    /**
     * Constrains dragging to either the horizontal (x) or
     * vertical (y) axis. Possible values: "x", "y".
     */
    public void setAxis(Axis axis) {
        setOption("axis", axis);
    }

    public String getCancel() {
        return getOption("cancel");
    }

    /**
     * Prevents dragging from starting on specified elements.
     */
    public void setCancel(String cancel) {
        setOption("cancel", cancel);
    }

    public String getConnectToSortable() {
        return getOption("connectToSortable");
    }

    /**
     * Allows the draggable to be dropped onto the specified sortables.
     * If this option is used, a draggable can be dropped onto a sortable
     * list and then becomes part of it. Note: The helper option must be
     * set to "clone" in order to work flawlessly. Requires the jQuery UI
     * Sortable plugin to be included.
     */
    public void setConnectToSortable(String connectToSortable) {
        setOption("connectToSortable", connectToSortable);
    }

    public Element getContainment(){
        return getOption("containment");
    }

    /**
     * Constrains dragging to within the bounds of the specified
     * element or region.
     */
    public void setContainment(Element containment) {
        setOption("containment", containment);
    }

    public Style.Cursor getCursor() {
        return CursorUtil.fromCssName((String)getOption("cursor"));
    }

    /**
     * The CSS cursor during the drag operation.
     */
    public void setCursor(Style.Cursor cursor) {
        setOption("cursor", cursor);
    }

    public At getCursorAt() {
        return ((JavaScriptObject)getOption("cursorAt")).cast();
    }

    /**
     * Sets the offset of the dragging helper relative to the mouse cursor.
     * Coordinates can be given as a hash using a combination of one or two
     * keys: { top, left, right, bottom }.
     */
    public void setCursorAt(At cursorAt) {
        setOption("cursorAt", cursorAt);
    }

    public double getDelay() {
        return getOption("delay");
    }

    /**
     * Time in milliseconds after mousedown until dragging should start.
     * This option can be used to prevent unwanted drags when clicking
     * on an element.
     */
    public void setDelay(double delay) {
        setOption("delay", delay);
    }

    public boolean getDisabled() {
        return getOption("disabled");
    }

    /**
     * Disables the draggable if set to true.
     */
    public void setDisabled(boolean disabled) {
        setOption("disabled", disabled);
    }

    public double getDistance() {
        return getOption("distance");
    }

    /**
     * Distance in pixels after mousedown the mouse must move before
     * dragging should start. This option can be used to prevent unwanted
     * drags when clicking on an element.
     */
    public void setDistance(double distance) {
        setOption("distance", distance);
    }

    public JsArrayInteger getGrid() {
        return getOption("grid");
    }

    /**
     * Snaps the dragging helper to a grid, every x and y pixels.
     * The array must be of the form [ x, y ].
     */
    public void setGrid(JsArrayInteger grid) {
        setOption("grid", grid);
    }

    public Object getHandle() {
        return getOption("handle");
    }

    /**
     * If specified, restricts dragging from starting unless the mousedown
     * occurs on the specified element(s). Only elements that descend from
     * the draggable element are permitted.
     */
    public void setHandle(Handle handle) {
        setOption("handle", handle);
    }

    public Object getHelper() {
        return getOption("helper");
    }

    /**
     * Allows for a helper element to be used for dragging display.<br/>
     * Default: {@link HelpType#ORIGINAL}.
     */
    public void setHelper(Helper helper) {
        setOption("helper", helper);
    }

    public Object getIframeFix() {
        return getOption("iframeFix");
    }

    /**
     * Prevent iframes from capturing the mousemove events during a drag.
     * Useful in combination with the cursorAt option, or in any case where
     * the mouse cursor may not be over the helper.
     * Multiple types supported:
     * <ul>
     *   <li>Boolean: When set to true, transparent overlays will be placed
     *   over all iframes on the page.</li>
     *   <li>Selector: Any iframes matching the selector will be covered by
     *   transparent overlays.</li>
     * </ul>
     */
    public void setIframeFix(IFrameFix iframeFix) {
        setOption("iframeFix", iframeFix);
    }

    public double getOpacity() {
        return getOption("opacity");
    }

    /**
     * Opacity for the helper while being dragged.
     */
    public void setOpacity(double opacity) {
        assert opacity <= 1 && opacity >= 0 : "Opacity must be within 0.0 to 1.0";
        setOption("opacity", opacity);
    }

    public boolean getRefreshPositions() {
        return getOption("refreshPositions");
    }

    /**
     * If set to true, all droppable positions are calculated on every mousemove.
     * Caution: This solves issues on highly dynamic pages, but dramatically
     * decreases performance.
     */
    public void setRefreshPositions(boolean refreshPositions) {
        setOption("refreshPositions", refreshPositions);
    }

    public Object getRevert() {
        return getOption("revert");
    }

    /**
     * Whether the element should revert to its start position when dragging stops.
     * <ul>
     *   <li>Boolean: If set to true the element will always revert.</li>
     *   <li>String: If set to "invalid", revert will only occur if the
     *   draggable has not been dropped on a droppable. For "valid", it's
     *   the other way around.</li>
     *   <li>Function: A function to determine whether the element should
     *   revert to its start position. The function must return true to
     *   revert the element.</li>
     * </ul>
     */
    public void setRevert(Revert revert) {
        setOption("revert", revert);
    }

    public double getRevertDuration() {
        return getOption("revertDuration");
    }

    /**
     * The duration of the revert animation, in milliseconds.
     * Ignored if the revert option is false.
     */
    public void setRevertDuration(double revertDuration) {
        setOption("revertDuration", revertDuration);
    }

    public String getScope() {
        return getOption("scope");
    }

    /**
     * Used to group sets of draggable and droppable items, in addition to
     * droppable's accept option. A draggable with the same scope value as
     * a droppable will be accepted by the droppable.
     */
    public void setScope(String scope) {
        setOption("scope", scope);
    }

    public boolean getScroll() {
        return getOption("scroll");
    }

    /**
     * If set to true, container auto-scrolls while dragging.
     */
    public void setScroll(boolean scroll) {
        setOption("scroll", scroll);
    }

    public double getScrollSensitivity() {
        return getOption("scrollSensitivity");
    }

    /**
     * Distance in pixels from the edge of the viewport after which the viewport
     * should scroll. Distance is relative to pointer, not the draggable.
     * Ignored if the scroll option is false.
     */
    public void setScrollSensitivity(double scrollSensitivity) {
        setOption("scrollSensitivity", scrollSensitivity);
    }

    public double getScrollSpeed() {
        return getOption("scrollSpeed");
    }

    /**
     * The speed at which the window should scroll once the mouse pointer gets within
     * the scrollSensitivity distance. Ignored if the scroll option is false.
     */
    public void setScrollSpeed(double scrollSpeed) {
        setOption("scrollSpeed", scrollSpeed);
    }

    public Object getSnap() {
        return getOption("snap");
    }

    /**
     * Whether the element should snap to other elements.
     */
    public void setSnap(Snap snap) {
        setOption("snap", snap);
    }

    public SnapMode getSnapMode() {
        return SnapMode.fromCssName((String) getOption("snapMode"));
    }

    /**
     * Determines which edges of snap elements the draggable
     * will snap to. Ignored if the snap option is false.
     */
    public void setSnapMode(SnapMode snapMode) {
        setOption("snapMode", snapMode);
    }

    public double getSnapTolerance() {
        return getOption("snapTolerance");
    }

    /**
     * The distance in pixels from the snap element edges at which
     * snapping should occur. Ignored if the snap option is false.
     */
    public void setSnapTolerance(double snapTolerance) {
        setOption("snapTolerance", snapTolerance);
    }

    public String getStack() {
        return getOption("stack");
    }

    /**
     * Controls the z-index of the set of elements that match the selector,
     * always brings the currently dragged item to the front. Very useful
     * in things like window managers.
     */
    public void setStack(String stack) {
        setOption("stack", stack);
    }

    public double getzIndex() {
        return getOption("zIndex");
    }

    /**
     * Z-index for the helper while being dragged.
     */
    public void setzIndex(double zIndex) {
        setOption("zIndex", zIndex);
    }

    // Methods

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

    @Override
    protected void remove(Element e) {
        destroy();
    }

    @Override
    public MouseLayer getMouseLayer() {
        return mouseLayer;
    }

    // Events

    /**
     * Triggered when the selectable is created.
     */
    public HandlerRegistration addCreateHandler(CreateHandler<Draggable, EmptyHash> handler) {
        return addHandler(handler, CreateEvent.getType());
    }

    private void onCreate(Event event, JavaScriptObject hash) {
        CreateEvent.fire(this, new EmptyHash(hash), event);
    }

    /**
     * Triggered while the mouse is moved during the
     * dragging, immediately before the current move happens.
     */
    public HandlerRegistration addDragHandler(DragHandler<Draggable, DraggableHash> handler) {
        return addHandler(handler, DragEvent.getType());
    }

    private void onDrag(Event event, JavaScriptObject hash) {
        DragEvent.fire(this, new DraggableHash(hash), event);
    }

    /**
     * This event is triggered when sorting starts.
     */
    public HandlerRegistration addStartHandler(StartHandler<Draggable, DraggableHash> handler) {
        return addHandler(handler, StartEvent.getType());
    }

    private void onStart(Event event, JavaScriptObject hash) {
        StartEvent.fire(this, new DraggableHash(hash), event);
    }

    /**
     * This event is triggered when sorting has stopped.
     */
    public HandlerRegistration addStopHandler(StopHandler<Draggable, DraggableHash> handler) {
        return addHandler(handler, StopEvent.getType());
    }

    private void onStop(Event event, JavaScriptObject hash) {
        StopEvent.fire(this, new DraggableHash(hash), event);
    }

    // Native Methods

    @Override
    protected native void initialize(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).draggable({
            create: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Draggable::onCreate(*)(e, ui);
            },
            drag: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Draggable::onDrag(*)(e, ui);
            },
            start: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Draggable::onStart(*)(e, ui);
            },
            stop: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Draggable::onStop(*)(e, ui);
            }
        });
    }-*/;

    @Override
    protected native <I> I getOption(Element e, String option) /*-{
        return $wnd.jQuery(e).draggable("option", option);
    }-*/;

    @Override
    protected native void setOption(Element e, String option, Object value) /*-{
        $wnd.jQuery(e).draggable("option", option, value);
    }-*/;

    @Override
    protected native void command(Element e, Object command) /*-{
        $wnd.jQuery(e).draggable(command);
    }-*/;
}
