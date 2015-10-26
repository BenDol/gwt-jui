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
import nz.co.doltech.gwtjui.interactions.client.base.UsesMouseLayer;
import nz.co.doltech.gwtjui.interactions.client.events.SelectedEvent;
import nz.co.doltech.gwtjui.interactions.client.events.SelectedHandler;
import nz.co.doltech.gwtjui.interactions.client.events.SelectingEvent;
import nz.co.doltech.gwtjui.interactions.client.events.SelectingHandler;
import nz.co.doltech.gwtjui.interactions.client.events.UnselectedEvent;
import nz.co.doltech.gwtjui.interactions.client.events.UnselectedHandler;
import nz.co.doltech.gwtjui.interactions.client.events.UnselectingEvent;
import nz.co.doltech.gwtjui.interactions.client.events.UnselectingHandler;
import nz.co.doltech.gwtjui.interactions.client.events.hash.SelectableHash;

/**
 * jQuery UI Selectable
 * <ul>
 *   <li>Version: 1.11.4</li>
 *   <li>Website: http://jqueryui.com</li>
 *   <li>Docs: http://api.jqueryui.com/selectable/</li>
 * </ul>
 * The jQuery UI Selectable plugin allows for elements to be selected by dragging a box
 * (sometimes called a lasso) with the mouse over the elements. Elements can also be
 * selected via click or drag while holding the ctrl/meta key, allowing for multiple
 * (non-contiguous) selections.
 *
 * @author Ben Dol
 */
public class Selectable extends JuiWrapper implements UsesMouseLayer {

    public enum Tolerance implements Style.HasCssName {
        TOUCH {
            @Override
            public String getCssName() {
                return "touch";
            }
        },
        FIT {
            @Override
            public String getCssName() {
                return "fit";
            }
        };
        @Override
        public abstract String getCssName();

        public static Tolerance fromCssName(String cssName) {
            for(Tolerance t : values()) {
                if(t.getCssName().equals(cssName)) { return t; }
            }
            return null;
        }
    }

    private MouseLayer mouseLayer;

    public Selectable(Element element) {
        super(element);
        mouseLayer = new MouseLayer(element);
    }

    public Selectable(Widget widget) {
        super(widget);
        mouseLayer = new MouseLayer(widget);
    }

    // Options

    public String getAppendTo() {
        return getOption("appendTo");
    }

    /**
     * Which element the selection helper (the lasso) should be appended to.
     */
    public void setAppendTo(String appendTo) {
        setOption("appendTo", appendTo);
    }

    public boolean isAutoRefresh() {
        return getOption("autoRefresh");
    }

    /**
     * This determines whether to refresh (recalculate) the position and size of
     * each selectee at the beginning of each select operation. If you have many
     * items, you may want to set this to false and call the refresh() method manually.
     */
    public void setAutoRefresh(boolean autoRefresh) {
        setOption("autoRefresh", autoRefresh);
    }

    public String getCancel() {
        return getOption("cancel");
    }

    /**
     * Prevents selecting if you start on elements matching the selector.
     */
    public void setCancel(String cancel) {
        setOption("cancel", cancel);
    }

    public int getDelay() {
        return getOption("delay");
    }

    /**
     * Time in milliseconds to define when the selecting should start.
     * This helps prevent unwanted selections when clicking on an element.
     */
    public void setDelay(int delay) {
        setOption("delay", delay);
    }

    public boolean isDisabled() {
        return getOption("disabled");
    }

    /**
     * Disables the selectable if set to true.
     */
    public void setDisabled(boolean disabled) {
        setOption("disabled", disabled);
    }

    public double getDistance() {
        return getOption("distance");
    }

    /**
     * Tolerance, in pixels, for when selecting should start. If specified,
     * selecting will not start until the mouse has been dragged beyond the
     * specified distance.
     */
    public void setDistance(double distance) {
        setOption("distance", distance);
    }

    public String getFilter() {
        return getOption("filter");
    }

    /**
     * The matching child elements will be made selectees (able to be selected).
     */
    public void setFilter(String filter) {
        setOption("filter", filter);
    }

    public Tolerance getTolerance() {
        return Tolerance.fromCssName((String) getOption("tolerance"));
    }

    /**
     * Specifies which mode to use for testing whether the lasso should select an item. Possible values:
     * <ul>
     *   <li>"fit": Lasso overlaps the item entirely.</li>
     *   <li>"touch": Lasso overlaps the item by any amount.</li>
     * </ul>
     */
    public void setTolerance(Tolerance tolerance) {
        setOption("tolerance", tolerance);
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

    /**
     * Refresh the sortable items. Triggers the reloading of
     * all sortable items, causing new items to be recognized.
     */
    public void refresh() {
        command("refresh");
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
    public HandlerRegistration addCreateHandler(CreateHandler<Selectable, EmptyHash> handler) {
        return addHandler(handler, CreateEvent.getType());
    }

    private void onCreate(Event event, JavaScriptObject hash) {
        CreateEvent.fire(this, new EmptyHash(hash), event);
    }

    /**
     * Triggered at the end of the select operation,
     * on each element added to the selection.
     */
    public HandlerRegistration addSelectedHandler(SelectedHandler<Selectable, SelectableHash> handler) {
        return addHandler(handler, SelectedEvent.getType());
    }

    private void onSelected(Event event, JavaScriptObject hash) {
        SelectedEvent.fire(this, new SelectableHash(hash), event);
    }

    /**
     * Triggered during the select operation,
     * on each element added to the selection.
     */
    public HandlerRegistration addSelectingHandler(SelectingHandler<Selectable, SelectableHash> handler) {
        return addHandler(handler, SelectingEvent.getType());
    }

    private void onSelecting(Event event, JavaScriptObject hash) {
        SelectingEvent.fire(this, new SelectableHash(hash), event);
    }

    /**
     * This event is triggered when sorting starts.
     */
    public HandlerRegistration addStartHandler(StartHandler<Selectable, EmptyHash> handler) {
        return addHandler(handler, StartEvent.getType());
    }

    private void onStart(Event event, JavaScriptObject hash) {
        StartEvent.fire(this, new EmptyHash(hash), event);
    }

    /**
     * This event is triggered when sorting has stopped.
     */
    public HandlerRegistration addStopHandler(StopHandler<Selectable, EmptyHash> handler) {
        return addHandler(handler, StopEvent.getType());
    }

    private void onStop(Event event, JavaScriptObject hash) {
        StopEvent.fire(this, new EmptyHash(hash), event);
    }

    /**
     * Triggered at the end of the select operation,
     * on each element removed from the selection.
     */
    public HandlerRegistration addUnselectedHandler(UnselectedHandler<Selectable, SelectableHash> handler) {
        return addHandler(handler, UnselectedEvent.getType());
    }

    private void onUnselected(Event event, JavaScriptObject hash) {
        UnselectedEvent.fire(this, new SelectableHash(hash), event);
    }

    /**
     * Triggered during the select operation,
     * on each element removed from the selection.
     */
    public HandlerRegistration addUnselectingHandler(UnselectingHandler<Selectable, SelectableHash> handler) {
        return addHandler(handler, UnselectingEvent.getType());
    }

    private void onUnselecting(Event event, JavaScriptObject hash) {
        UnselectingEvent.fire(this, new SelectableHash(hash), event);
    }

    // Native Methods

    @Override
    protected native void initialize(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).selectable({
            create: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onCreate(*)(e, ui);
            },
            selected: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onSelected(*)(e, ui);
            },
            selecting: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onSelecting(*)(e, ui);
            },
            start: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onStart(*)(e, ui);
            },
            stop: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onStop(*)(e, ui);
            },
            unselected: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onUnselected(*)(e, ui);
            },
            unselecting: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Selectable::onUnselecting(*)(e, ui);
            }
        });
    }-*/;

    @Override
    protected native <I> I getOption(Element e, String option) /*-{
        return $wnd.jQuery(e).selectable("option", option);
    }-*/;

    @Override
    protected native void setOption(Element e, String option, Object value) /*-{
        $wnd.jQuery(e).selectable("option", option, value);
    }-*/;

    @Override
    protected native void command(Element e, Object command) /*-{
        $wnd.jQuery(e).selectable(command);
    }-*/;
}
