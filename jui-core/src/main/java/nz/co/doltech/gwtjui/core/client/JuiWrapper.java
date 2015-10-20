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
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import nz.co.doltech.gwtjui.core.client.base.IsJavaScriptObject;

public abstract class JuiWrapper extends UIObject implements IsWidget {

    private class GhostWidget extends Widget {
        public GhostWidget(Element element) {
            setElement(element);
        }
    }

    private Widget widget;

    public JuiWrapper(Element element) {
        setupWidget(new GhostWidget(element));
    }

    public JuiWrapper(Widget widget) {
        setupWidget(widget);
    }

    private void setupWidget(Widget widget) {
        this.widget = widget;
        setElement((Element) this.widget.getElement());

        widget.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent event) {
                if(event.isAttached()) {
                    onLoad();
                } else {
                    onUnload();
                }
            }
        });
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    protected abstract void initialize(Element element);

    protected abstract void remove(Element element);

    protected abstract void command(Element e, Object command);

    protected abstract String getOption(Element e, String option);

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

    protected String getOption(String option) {
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
}
