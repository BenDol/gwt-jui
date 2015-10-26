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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjui.core.client.JuiLayer;

/**
 * jQuery UI Mouse Layer
 * <ul>
 *   <li>Version: 1.11.4</li>
 *   <li>Website: http://jqueryui.com</li>
 *   <li>Docs: http://api.jqueryui.com/mouse/</li>
 * </ul>
 * Similar to jQuery.Widget, the mouse interaction is not intended to be used directly.
 * It is purely a base layer for other widgets to inherit from. This page only documents
 * what is added to jQuery.Widget, but it does include internal methods that are not
 * intended to be overwritten.<br/><br/>
 *
 * The intended public API is _mouseStart(), _mouseDrag(), _mouseStop(), and _mouseCapture().
 * @author Ben Dol
 */
public final class MouseLayer extends JuiLayer {

    public MouseLayer(Element element) {
        super(element);
    }

    public MouseLayer(Widget widget) {
        super(widget);
    }

    // Options

    public String getCancel() {
        return getOption("cancel");
    }

    /**
     * Prevents interactions from starting on specified elements.
     */
    public void setCancel(String cancel) {
        setOption("cancel", cancel);
    }

    public double getDelay() {
        return getOption("delay");
    }

    /**
     * Time in milliseconds after mousedown until the interaction should start.
     * This option can be used to prevent unwanted interactions when clicking
     * on an element.
     */
    public void setDelay(double delay) {
        setOption("delay", delay);
    }

    public double getDistance() {
        return getOption("distance");
    }

    /**
     * Distance in pixels after mousedown the mouse must move before the interaction
     * should start. This option can be used to prevent unwanted interactions when
     * clicking on an element.
     */
    public void setDistance(double distance) {
        setOption("distance", distance);
    }

    // Methods

    /**
     * Determines whether an interaction should start based on
     * event target of the interaction. The default implementation
     * always returns true.
     */
    public native boolean capture(Element e) /*-{
        return $wnd.jQuery(e).mouse( "_mouseCapture" );
    }-*/;

    /**
     * Determines whether the delay option has been met for the
     * current interaction.
     */
    public native boolean delayMet(Element e) /*-{
        return $wnd.jQuery(e).mouse( "_mouseDelayMet" );
    }-*/;

    /**
     * Destroys the interaction event handlers.
     */
    public native void destroy(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseDestroy" );
    }-*/;

    /**
     * Determines whether the distance option has been met for the
     * current interaction.
     */
    public native boolean distanceMet(Element e) /*-{
        return $wnd.jQuery(e).mouse( "_mouseDistanceMet" );
    }-*/;

    /**
     * Handles the beginning of an interaction. Verifies that the event is associated
     * with the primary mouse button and ensures that the delay and distance options
     * are met prior to starting the interaction. When the interaction is ready to start,
     * invokes the _mouseStart() method for the extending widget to handle.
     */
    public native void down(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseDown" );
    }-*/;

    /**
     * The extending widget should implement a _mouseDrag() method to handle each
     * movement of an interaction. This method will receive the mouse event
     * associated with the movement.
     */
    public native void drag(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseDrag" );
    }-*/;

    /**
     * Initializes the interaction event handlers. This must be called from the
     * extending widget's _create() method.
     */
    public native void init(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseInit" );
    }-*/;

    /**
     * Handles each movement of the interaction. Invokes the mouseDrag() method
     * for the extending widget to handle.
     */
    public native void move(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseMove" );
    }-*/;

    /**
     * The extending widget should implement a _mouseStart() method to handle the beginning
     * of an interaction. This method will receive the mouse event associated with the start
     * of the interaction.
     */
    public native void start(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseStart" );
    }-*/;

    /**
     * The extending widget should implement a _mouseStop() method to handle the end of an
     * interaction. This method will receive the mouse event associated with the end of the
     * interaction.
     */
    public native void stop(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseStop" );
    }-*/;

    /**
     * Handles the end of the interaction. Invokes the mouseStop() method for the extending
     * widget to handle.
     */
    public native void up(Element e) /*-{
        $wnd.jQuery(e).mouse( "_mouseUp" );
    }-*/;

    @Override
    protected void remove(Element element) {
        destroy(element);
    }

    @Override
    protected native <I> I getOption(Element e, String option) /*-{
        return $wnd.jQuery(e).mouse("option", option);
    }-*/;

    @Override
    protected native void setOption(Element e, String option, Object value) /*-{
        $wnd.jQuery(e).mouse("option", option, value);
    }-*/;
}
