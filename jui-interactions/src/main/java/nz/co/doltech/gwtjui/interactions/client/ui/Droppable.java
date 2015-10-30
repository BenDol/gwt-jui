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
import nz.co.doltech.gwtjui.core.client.events.ActivateEvent;
import nz.co.doltech.gwtjui.core.client.events.ActivateHandler;
import nz.co.doltech.gwtjui.core.client.events.CreateEvent;
import nz.co.doltech.gwtjui.core.client.events.CreateHandler;
import nz.co.doltech.gwtjui.core.client.events.DeactivateEvent;
import nz.co.doltech.gwtjui.core.client.events.DeactivateHandler;
import nz.co.doltech.gwtjui.core.client.events.OutEvent;
import nz.co.doltech.gwtjui.core.client.events.OutHandler;
import nz.co.doltech.gwtjui.core.client.events.OverEvent;
import nz.co.doltech.gwtjui.core.client.events.OverHandler;
import nz.co.doltech.gwtjui.core.client.events.hash.EmptyHash;
import nz.co.doltech.gwtjui.interactions.client.events.DropEvent;
import nz.co.doltech.gwtjui.interactions.client.events.DropHandler;
import nz.co.doltech.gwtjui.interactions.client.events.hash.DroppableHash;
import nz.co.doltech.gwtjui.interactions.client.options.Accept;

/**
 * jQuery UI Droppable
 * <ul>
 *   <li>Version: 1.11.4</li>
 *   <li>Website: http://jqueryui.com</li>
 *   <li>Docs: http://api.jqueryui.com/droppable/</li>
 * </ul>
 * Create targets for draggable elements.
 * <br/><br/>
 * The jQuery UI Droppable plugin makes selected elements droppable
 * (meaning they accept being dropped on by draggables). You can specify
 * which draggables each will accept.
 *
 * @author Ben Dol
 */
public class Droppable extends JuiWrapper {

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
        },
        INTERSECT {
            @Override
            public String getCssName() {
                return "intersect";
            }
        },
        POINTER {
            @Override
            public String getCssName() {
                return "pointer";
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

    protected Droppable() {}

    public Droppable(Element element) {
        super(element);
    }

    public Droppable(Widget widget) {
        super(widget);
    }

    // Options

    public Object getAccept() {
        return getOption("accept");
    }

    /**
     * Controls which draggable elements are accepted by the droppable.
     */
    public void setAccept(Accept accept) {
        setOption("accept", accept);
    }

    public String getActiveClass() {
        return getOption("activeClass");
    }

    /**
     * If specified, the class will be added to the droppable while
     * an acceptable draggable is being dragged.
     */
    public void setActiveClass(String activeClass) {
        setOption("activeClass", activeClass);
    }

    public boolean getAddClasses() {
        return getOption("addClasses");
    }

    /**
     * If set to false, will prevent the ui-droppable class from being
     * added. This may be desired as a performance optimization when
     * calling .droppable() init on hundreds of elements.
     */
    public void setAddClasses(boolean addClasses) {
        setOption("addClasses", addClasses);
    }

    public boolean getDisabled() {
        return getOption("disabled");
    }

    /**
     * Disables the droppable if set to true.
     */
    public void setDisabled(boolean disabled) {
        setOption("disabled", disabled);
    }

    public boolean isGreedy() {
        return getOption("greedy");
    }

    /**
     * By default, when an element is dropped on nested droppables, each
     * droppable will receive the element. However, by setting this option
     * to true, any parent droppables will not receive the element. The
     * drop event will still bubble normally, but the event.target can
     * be checked to see which droppable received the draggable element.
     */
    public void setGreedy(boolean greedy) {
        setOption("greedy", greedy);
    }

    public String getHoverClass() {
        return getOption("hoverClass");
    }

    /**
     * If specified, the class will be added to the droppable while an
     * acceptable draggable is being hovered over the droppable.
     */
    public void setHoverClass(String hoverClass) {
        setOption("hoverClass", hoverClass);
    }

    public String getScope() {
        return getOption("scope");
    }

    /**
     * Used to group sets of draggable and droppable items, in addition
     * to the accept option. A draggable with the same scope value as a
     * droppable will be accepted.
     */
    public void getScope(String scope) {
        setOption("scope", scope);
    }

    public Tolerance getTolerance() {
        return Tolerance.fromCssName((String)getOption("tolerance"));
    }

    /**
     * Specifies which mode to use for testing whether a draggable
     * is hovering over a droppable.
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

    @Override
    protected void remove(Element e) {
        destroy();
    }

    // Events

    /**
     * Triggered when the selectable is created.
     */
    public HandlerRegistration addCreateHandler(CreateHandler<Droppable, EmptyHash> handler) {
        return addHandler(handler, CreateEvent.getType());
    }

    private void onCreate(Event event, JavaScriptObject hash) {
        CreateEvent.fire(this, new EmptyHash(hash), event);
    }

    /**
     * Triggered when an accepted draggable starts dragging.
     * This can be useful if you want to make the droppable
     * "light up" when it can be dropped on.
     */
    public HandlerRegistration addActivateHandler(ActivateHandler<Droppable, DroppableHash> handler) {
        return addHandler(handler, ActivateEvent.getType());
    }

    private void onActivate(Event event, JavaScriptObject hash) {
        ActivateEvent.fire(this, new DroppableHash(hash), event);
    }

    /**
     * Triggered when an accepted draggable stops dragging.
     */
    public HandlerRegistration addDeactivateHandler(DeactivateHandler<Droppable, DroppableHash> handler) {
        return addHandler(handler, DeactivateEvent.getType());
    }

    private void onDeactivate(Event event, JavaScriptObject hash) {
        DeactivateEvent.fire(this, new DroppableHash(hash), event);
    }

    /**
     * Triggered when an accepted draggable is dropped on
     * the droppable (based on thetolerance option).
     */
    public HandlerRegistration addDropHandler(DropHandler<Droppable, DroppableHash> handler) {
        return addHandler(handler, DropEvent.getType());
    }

    private void onDrop(Event event, JavaScriptObject hash) {
        DropEvent.fire(this, new DroppableHash(hash), event);
    }

    /**
     * Triggered when an accepted draggable is dragged out
     * of the droppable (based on thetolerance option).
     */
    public HandlerRegistration addOutHandler(OutHandler<Droppable, DroppableHash> handler) {
        return addHandler(handler, OutEvent.getType());
    }

    private void onOut(Event event, JavaScriptObject hash) {
        OutEvent.fire(this, new DroppableHash(hash), event);
    }

    /**
     * Triggered when an accepted draggable is dragged
     * over the droppable (based on the tolerance option).
     */
    public HandlerRegistration addOverHandler(OverHandler<Droppable, DroppableHash> handler) {
        return addHandler(handler, OverEvent.getType());
    }

    private void onOver(Event event, JavaScriptObject hash) {
        OverEvent.fire(this, new DroppableHash(hash), event);
    }

    // Native Methods

    @Override
    protected native void initialize(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).droppable({
            create: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Droppable::onCreate(*)(e, ui);
            },
            activate: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Droppable::onActivate(*)(e, ui);
            },
            deactivate: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Droppable::onDeactivate(*)(e, ui);
            },
            drop: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Droppable::onDrop(*)(e, ui);
            },
            out: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Droppable::onOut(*)(e, ui);
            },
            over: function(e, ui) {
                that.@nz.co.doltech.gwtjui.interactions.client.ui.Droppable::onOver(*)(e, ui);
            }
        });
    }-*/;

    @Override
    protected native <I> I getOption(Element e, String option) /*-{
        return $wnd.jQuery(e).droppable("option", option);
    }-*/;

    @Override
    protected native void setOption(Element e, String option, Object value) /*-{
        $wnd.jQuery(e).droppable("option", option, value);
    }-*/;

    @Override
    protected native void command(Element e, Object command) /*-{
        $wnd.jQuery(e).droppable(command);
    }-*/;
}
