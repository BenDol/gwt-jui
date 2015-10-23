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
package nz.co.doltech.gwtjui.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjui.core.client.js.JsArrayUtil;
import nz.co.doltech.gwtjui.core.client.js.JsFunction;

import java.util.Arrays;
import java.util.List;

public class JuiQuery extends Wrapper {

    public JuiQuery(Element element) {
        super(element);
    }

    public JuiQuery(Widget widget) {
        super(widget);
    }

    public static JuiQuery $(Element e) {
        return new JuiQuery(e);
    }

    public static JuiQuery $(UIObject uiObject) {
        return new JuiQuery(uiObject.getElement());
    }

    public static JuiQuery $(String selector) {
        return new JuiQuery(select(selector));
    }

    private native static Element select(String selector) /*-{
        return $wnd.jQuery(selector);
    }-*/;

    /**
     * Search for a given element from among the matched elements.
     */
    public int index() {
        return index(getElement());
    }

    protected native int index(Element e) /*-{
        return $wnd.jQuery(e).index();
    }-*/;

    /**
     * Iterate over a jQuery object, executing a function for
     * each matched element.
     */
    public JuiQuery each(Runnable runnable) {
        return each(new JsFunction(runnable));
    }

    /**
     * Iterate over a jQuery object, executing a function for
     * each matched element.
     */
    public JuiQuery each(JsFunction jsFunc) {
        each(getElement(), jsFunc.asJavaScript());
        return this;
    }

    protected native void each(Element e, JavaScriptObject jso) /*-{
        return $wnd.jQuery(e).each(jso);
    }-*/;

    /**
     * Bind an event handler to the "blur" JavaScript event,
     * or trigger that event on an element.
     */
    public JuiQuery blur() {
        return blur(JsFunction.blank());
    }

    /**
     * Bind an event handler to the "blur" JavaScript event,
     * or trigger that event on an element.
     */
    public JuiQuery blur(JsFunction jsFunc) {
        blur(getElement(), jsFunc.asJavaScript());
        return this;
    }

    protected native void blur(Element e, JavaScriptObject jso) /*-{
        if(jso !== null) {
            $wnd.jQuery(e).blur(jso);
        } else {
            $wnd.jQuery(e).blur();
        }
    }-*/;

    /**
     * Get the computed style properties for the first element
     * in the set of matched elements.
     */
    public List<String> css(String... props) {
        return JsArrayUtil.toList(
            css(getElement(), JsArrayUtil.fromStrings(Arrays.asList(props)))
        );
    }

    protected native JsArrayString css(Element e, JsArrayString props) /*-{
        return $wnd.jQuery(e).css(props);
    }-*/;

    /**
     * Remove all child nodes of the set of matched elements from the DOM.
     */
    public JuiQuery empty() {
        empty(getElement());
        return this;
    }

    protected native void empty(Element e) /*-{
        $wnd.jQuery(e).empty();
    }-*/;

    /**
     * Set a timer to delay execution of subsequent items in the queue.
     */
    public JuiQuery delay(int millis) {
        delay(getElement(), millis);
        return this;
    }

    protected native void delay(Element e, int millis) /*-{
        $wnd.jQuery(e).delay(millis);
    }-*/;

    /**
     * Display the matched elements by fading them to opaque.
     */
    public JuiQuery fadeIn(int millis) {
        return fadeIn(millis, JsFunction.blank());
    }

    /**
     * Display the matched elements by fading them to opaque.
     */
    public JuiQuery fadeIn(int millis, JsFunction jsFunc) {
        fadeIn(getElement(), millis, jsFunc.asJavaScript());
        return this;
    }

    protected native void fadeIn(Element e, int millis, JavaScriptObject jso) /*-{
        $wnd.jQuery(e).fadeIn(millis, jso);
    }-*/;

    /**
     * Hide the matched elements by fading them to transparent.
     */
    public JuiQuery fadeOut(int millis) {
        return fadeOut(millis, JsFunction.blank());
    }

    /**
     * Hide the matched elements by fading them to transparent.
     */
    public JuiQuery fadeOut(int millis, JsFunction jsFunc) {
        fadeOut(getElement(), millis, jsFunc.asJavaScript());
        return this;
    }

    protected native void fadeOut(Element e, int millis, JavaScriptObject jso) /*-{
        $wnd.jQuery(e).fadeOut(millis, jso);
    }-*/;

    /**
     * Adjust the opacity of the matched elements.
     */
    public JuiQuery fadeTo(int millis, double opacity) {
        return fadeTo(millis, opacity, JsFunction.blank());
    }

    /**
     * Adjust the opacity of the matched elements.
     */
    public JuiQuery fadeTo(int millis, double opacity, JsFunction jsFunc) {
        fadeTo(getElement(), millis, opacity, jsFunc.asJavaScript());
        return this;
    }

    protected native void fadeTo(Element e, int millis, double opacity, JavaScriptObject jso) /*-{
        $wnd.jQuery(e).fadeTo(millis, opacity, jso);
    }-*/;

    /**
     * Display or hide the matched elements by animating their opacity.
     */
    public JuiQuery fadeToggle(int millis) {
        return fadeToggle(millis, "swing");
    }

    /**
     * Display or hide the matched elements by animating their opacity.
     */
    public JuiQuery fadeToggle(int millis, String easing) {
        return fadeToggle(millis, easing, JsFunction.blank());
    }

    /**
     * Display or hide the matched elements by animating their opacity.
     */
    public JuiQuery fadeToggle(int millis, String easing, JsFunction jsFunc) {
        fadeToggle(getElement(), millis, easing, jsFunc.asJavaScript());
        return this;
    }

    protected native void fadeToggle(Element e, int millis, String easing, JavaScriptObject jso) /*-{
        $wnd.jQuery(e).fadeToggle(millis, easing, jso);
    }-*/;

    /**
     * The number of elements in the jQuery object.
     */
    public int length() {
        return length(getElement());
    }

    protected native int length(Element e) /*-{
        return $wnd.jQuery(e).length;
    }-*/;

    /**
     * Get the current value of the first element in the set
     * of matched elements.
     */
    public int val() {
        return val(getElement());
    }

    protected native int val(Element e) /*-{
        return $wnd.jQuery(e).val();
    }-*/;

    /**
     * Return a number representing the current time.
     */
    public static native void now() /*-{
        return $wnd.jQuery.now();
    }-*/;

    /**
     * Remove the whitespace from the beginning and end of a string.
     */
    public static native String trim(String str) /*-{
        return $wnd.jQuery.trim(str);
    }-*/;

    /**
     * Set one or more attributes for the set of matched elements.
     */
    public Element attr(String attr) {
        return attr(getElement(), attr);
    }

    /**
     * Get the value of an attribute for the first element in the set of matched elements.
     */
    public native Element attr(Element e, String attr) /*-{
        return $wnd.jQuery(e).attr(attr);
    }-*/;

    /**
     * Set one or more attributes for the set of matched elements.
     */
    public JuiQuery attr(String attr, String value) {
        attr(getElement(), attr, value);
        return this;
    }

    /**
     * Set one or more attributes for the set of matched elements.
     */
    public native void attr(Element e, String attr, String value) /*-{
        $wnd.jQuery(e).attr(attr, value);
    }-*/;

    /**
     * Remove an attribute from each element in the set of matched elements.
     */
    public JuiQuery removeAttr(String attr) {
        removeAttr(getElement(), attr);
        return this;
    }

    /**
     * Remove an attribute from each element in the set of matched elements.
     */
    public native void removeAttr(Element e, String attr) /*-{
        $wnd.jQuery(e).removeAttr(attr);
    }-*/;

    /**
     * Remove a property for the set of matched elements.
     */
    public JuiQuery removeProp(String propertyName) {
        removeProp(getElement(), propertyName);
        return this;
    }

    /**
     * Remove a property for the set of matched elements.
     */
    public native void removeProp(Element e, String propertyName) /*-{
        $wnd.jQuery(e).removeProp(propertyName);
    }-*/;

    /**
     * Bind an event handler to the "submit" JavaScript event,
     * or trigger that event on an element.
     */
    public JuiQuery submit() {
        return submit(JsFunction.blank());
    }

    /**
     * Bind an event handler to the "submit" JavaScript event,
     * or trigger that event on an element.
     */
    public JuiQuery submit(JsFunction jsFunction) {
        submit(getElement(), jsFunction.asJavaScript());
        return this;
    }

    /**
     * Bind an event handler to the "submit" JavaScript event,
     * or trigger that event on an element.
     */
    public native void submit(Element e, JavaScriptObject jso) /*-{
        $wnd.jQuery(e).submit(jso);
    }-*/;
}
