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

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjui.core.client.base.IsJavaScriptObject;
import nz.co.doltech.gwtjui.core.client.base.MultiTypeOption;

public abstract class JuiWrapper extends JuiQuery {

    public JuiWrapper(Element element) {
        super(element);
    }

    public JuiWrapper(Widget widget) {
        super(widget);
    }

    protected abstract void initialize(Element element);

    protected abstract void remove(Element element);

    protected abstract void command(Element e, Object command);

    protected abstract <I> I getOption(Element e, String option);

    protected abstract void setOption(Element e, String option, Object value);

    protected void onLoad() {
        initialize();
    }

    protected void onUnload() {
        remove();
    }

    public void initialize() {
        initialize(getElement());
    }

    public void remove() {
        remove(getElement());
    }

    protected void command(Object command) {
        command(getElement(), command);
    }

    protected <I> I getOption(String option) {
        return getOption(getElement(), option);
    }

    protected void setOption(String option, Object value) {
        setOption(getElement(), option, value);
    }

    protected void setOption(String option, IsJavaScriptObject value) {
        setOption(getElement(), option, value.asJavaScript());
    }

    protected void setOption(String option, Style.HasCssName value) {
        setOption(getElement(), option, value.getCssName());
    }

    protected void setOption(String option, MultiTypeOption value) {
        setOption(getElement(), option, value.get());
    }

    // Core Methods

    /**
     * Disable selection of text content within the set of matched elements.
     */
    public void disableSelection() {
        disableSelection(getElement());
    }

    public native void disableSelection(Element e) /*-{
        $wnd.jQuery(e).disableSelection();
    }-*/;

    /**
     * Enable selection of text content within the set of matched elements.
     */
    public void enableSelection() {
        disableSelection(getElement());
    }

    public native void enableSelection(Element e) /*-{
        $wnd.jQuery(e).enableSelection();
    }-*/;

    /**
     * Selects elements which have data stored under the specified key.
     */
    public void data(String key, Object value) {
        data(getElement(), key, value);
    }

    public native void data(Element e, String key, Object value) /*-{
        $wnd.jQuery(e).data(key, value);
    }-*/;

    /**
     * Asynchronously set focus to an element.
     */
    public void focus(int delay) {
        focus(getElement(), delay);
    }

    public native void focus(Element e, int delay) /*-{
        $wnd.jQuery(e).focus();
    }-*/;

    /**
     * Remove ids that were set by .uniqueId() for the set of
     * matched elements.
     */
    public void removeUniqueId() {
        removeUniqueId(getElement());
    }

    public native void removeUniqueId(Element e) /*-{
        $wnd.jQuery(e).removeUniqueId();
    }-*/;

    /**
     * Get the closest ancestor element that is scrollable.
     */
    public void scrollParent() {
        scrollParent(getElement());
    }

    public native void scrollParent(Element e) /*-{
        $wnd.jQuery(e).scrollParent();
    }-*/;

    /**
     * Generate and apply a unique id for the set of matched elements.
     */
    public void uniqueId() {
        uniqueId(getElement());
    }

    public native void uniqueId(Element e) /*-{
        $wnd.jQuery(e).uniqueId();
    }-*/;

    /**
     * Get the z-index for an element.
     */
    public int zIndex() {
        return zIndex(getElement());
    }

    public native int zIndex(Element e) /*-{
        return $wnd.jQuery(e).zIndex();
    }-*/;

    /**
     * Set the z-index for an element.
     */
    public void zIndex(int zIndex) {
        zIndex(getElement(), zIndex);
    }

    public native void zIndex(Element e, int zIndex) /*-{
        $wnd.jQuery(e).zIndex(zIndex);
    }-*/;
}
