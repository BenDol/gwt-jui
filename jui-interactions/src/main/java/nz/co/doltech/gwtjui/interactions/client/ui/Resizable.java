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
import nz.co.doltech.gwtjui.core.client.util.Easing;
import nz.co.doltech.gwtjui.interactions.client.events.ResizeEvent;
import nz.co.doltech.gwtjui.interactions.client.events.ResizeHandler;
import nz.co.doltech.gwtjui.interactions.client.events.hash.ResizableHash;
import nz.co.doltech.gwtjui.interactions.client.options.AlsoResize;
import nz.co.doltech.gwtjui.interactions.client.options.AnimateDuration;
import nz.co.doltech.gwtjui.interactions.client.options.AspectRatio;
import nz.co.doltech.gwtjui.interactions.client.options.Containment;

/**
 * jQuery UI Resizable
 * <ul>
 *   <li>Version: 1.11.4</li>
 *   <li>Website: http://jqueryui.com</li>
 *   <li>Docs: http://api.jqueryui.com/resizable/</li>
 * </ul>
 * Change the size of an element using the mouse.
 * <br/><br/>
 * The jQuery UI Resizable plugin makes selected elements resizable
 * (meaning they have draggable resize handles). You can specify one
 * or more handles as well as min and max width and height.
 *
 * @author Ben Dol
 */
public class Resizable extends JuiWrapper {

    public Resizable(Element element) {
        super(element);
    }

    public Resizable(Widget widget) {
        super(widget);
    }

    // Options

    public Object getAlsoResize() {
        return getOption("alsoResize");
    }

    /**
     * One or more elements to resize synchronously with the
     * resizable element.
     */
    public void setAlsoResize(AlsoResize alsoResize) {
        setOption("alsoResize", alsoResize);
    }

    public boolean getAnimate() {
        return getOption("animate");
    }

    /**
     * Animates to the final size after resizing.
     */
    public void setAnimate(boolean animate) {
        setOption("animate", animate);
    }

    public Object getAnimateDuration() {
        return getOption("animateDuration");
    }

    /**
     * How long to animate when using the animate option.
     */
    public void setAnimateDuration(AnimateDuration animateDuration) {
        setOption("animateDuration", animateDuration);
    }

    public String getAnimateEasing() {
        return getOption("animateEasing");
    }

    /**
     * Which easing to apply when using the animate option.
     */
    public void getAnimateEasing(Easing animateEasing) {
        setOption("animateEasing", animateEasing);
    }

    public Object getAspectRatio() {
        return getOption("aspectRatio");
    }

    /**
     * Whether the element should be constrained to a specific aspect ratio.
     * <ul>
     *   <li>Boolean: When set to true, the element will maintain its original aspect ratio.</li>
     *   <li>Number: Force the element to maintain a specific aspect ratio during resizing.</li>
     * </ul>
     */
    public void setAspectRatio(AspectRatio aspectRatio) {
        setOption("aspectRatio", aspectRatio);
    }

    public boolean getAutoHide() {
        return getOption("autoHide");
    }

    /**
     * Whether the handles should hide when the user is not hovering over the element.
     */
    public void setAutoHide(boolean autoHide) {
        setOption("autoHide", autoHide);
    }

    public String getCancel() {
        return getOption("cancel");
    }

    /**
     * Prevents resizing from starting on specified elements.
     */
    public void setCancel(String cancel) {
        setOption("cancel", cancel);
    }

    public Object getContainment() {
        return getOption("containment");
    }

    /**
     * Constrains resizing to within the bounds of the specified element or region.
     * <ul>
     *   <li>Selector: The resizable element will be contained to the bounding box of the first
     *   element found by the selector. If no element is found, no containment will be set.</li>
     *   <li>Element: The resizable element will be contained to the bounding box of this element.</li>
     *   <li>String: Possible values: "parent" and "document".</li>
     * </ul>
     */
    public void setContainment(Containment containment) {
        setOption("containment", containment);
    }

    public double getDelay() {
        return getOption("delay");
    }

    /**
     * Tolerance, in milliseconds, for when resizing should start. If specified, resizing
     * will not start until after mouse is moved beyond duration. This can help prevent
     * unintended resizing when clicking on an element.
     */
    public void setDelay(double delay) {
        setOption("delay", delay);
    }

    public boolean isDisabled() {
        return getOption("disabled");
    }

    /**
     * Disables the resizable if set to true.
     */
    public void setDisabled(boolean disabled) {
        setOption("disabled", disabled);
    }

    public double getDistance() {
        return getOption("distance");
    }

    /**
     * Tolerance, in pixels, for when resizing should start. If specified,
     * resizing will not start until after mouse is moved beyond distance.
     * This can help prevent unintended resizing when clicking on an element.
     */
    public void setDistance(double distance) {
        setOption("distance", distance);
    }

    public boolean isGhost() {
        return getOption("ghost");
    }

    /**
     * If set to true, a semi-transparent helper element is shown for resizing.
     */
    public void setGhost(boolean ghost) {
        setOption("ghost", ghost);
    }

    public JsArrayInteger getGrid() {
        return getOption("grid");
    }

    /**
     * Snaps the resizing element to a grid, every x and y pixels.
     * Array values: [ x, y ].
     */
    public void setGrid(JsArrayInteger grid) {
        setOption("grid", grid);
    }

    public String getHandles() {
        return getOption("handles");
    }

    /**
     * Which handles can be used for resizing.
     */
    public void setHandles(String handles) {
        setOption("handles", handles);
    }

    public String getHelper() {
        return getOption("helper");
    }

    /**
     * A class name that will be added to a proxy element to outline the resize
     * during the drag of the resize handle. Once the resize is complete, the
     * original element is sized.
     */
    public void setHelper(String helper) {
        setOption("helper", helper);
    }

    public double getMaxHeight() {
        return getOption("maxHeight");
    }

    /**
     * The maximum height the resizable should be allowed to resize to.
     */
    public void setMaxHeight(double maxHeight) {
        setOption("maxHeight", maxHeight);
    }

    public double getMaxWidth() {
        return getOption("maxWidth");
    }

    /**
     * The maximum width the resizable should be allowed to resize to.
     */
    public void setMaxWidth(double maxWidth) {
        setOption("maxWidth", maxWidth);
    }

    public double getMinHeight() {
        return getOption("minHeight");
    }

    /**
     * The minimum height the resizable should be allowed to resize to.
     */
    public void setMinHeight(double minHeight) {
        setOption("minHeight", minHeight);
    }

    public double getMinWidth() {
        return getOption("minWidth");
    }

    /**
     * The minimum width the resizable should be allowed to resize to.
     */
    public void setMinWidth(double minWidth) {
        setOption("minWidth", minWidth);
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

    // Events

    /**
     * Triggered when the selectable is created.
     */
    public HandlerRegistration addCreateHandler(CreateHandler<Resizable, EmptyHash> handler) {
        return addHandler(handler, CreateEvent.getType());
    }

    private void onCreate(Event event, JavaScriptObject hash) {
        CreateEvent.fire(this, new EmptyHash(hash), event);
    }

    /**
     * This event is triggered during the resize, on the drag of the resize handler.
     */
    public HandlerRegistration addResizeHandler(ResizeHandler<Resizable, ResizableHash> handler) {
        return addHandler(handler, ResizeEvent.getType());
    }

    private void onResize(Event event, JavaScriptObject hash) {
        ResizeEvent.fire(this, new ResizableHash(hash), event);
    }

    /**
     * This event is triggered at the start of a resize operation.
     */
    public HandlerRegistration addStartHandler(StartHandler<Resizable, ResizableHash> handler) {
        return addHandler(handler, StartEvent.getType());
    }

    private void onStart(Event event, JavaScriptObject hash) {
        StartEvent.fire(this, new ResizableHash(hash), event);
    }

    /**
     * This event is triggered at the end of a resize operation.
     */
    public HandlerRegistration addStopHandler(StopHandler<Resizable, ResizableHash> handler) {
        return addHandler(handler, StopEvent.getType());
    }

    private void onStop(Event event, JavaScriptObject hash) {
        StopEvent.fire(this, new ResizableHash(hash), event);
    }

    // Native Methods

    @Override
    protected native void initialize(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).resizable({
            create: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Resizable::onCreate(*)(e, ui);
            },
            resize: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Resizable::onResize(*)(e, ui);
            },
            start: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Resizable::onStart(*)(e, ui);
            },
            stop: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Resizable::onStop(*)(e, ui);
            }
        });
    }-*/;

    @Override
    protected native <I> I getOption(Element e, String option) /*-{
        return $wnd.jQuery(e).resizable("option", option);
    }-*/;

    @Override
    protected native void setOption(Element e, String option, Object value) /*-{
        $wnd.jQuery(e).resizable("option", option, value);
    }-*/;

    @Override
    protected native void command(Element e, Object command) /*-{
        $wnd.jQuery(e).resizable(command);
    }-*/;
}
