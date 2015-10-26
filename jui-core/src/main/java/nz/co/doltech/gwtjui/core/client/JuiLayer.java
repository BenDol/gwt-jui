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

public abstract class JuiLayer extends JuiQuery {

    public JuiLayer(Element element) {
        super(element);
    }

    public JuiLayer(Widget widget) {
        super(widget);
    }

    protected abstract void remove(Element element);

    protected abstract <I> I getOption(Element e, String option);

    protected abstract void setOption(Element e, String option, Object value);

    public void remove() {
        remove(getElement());
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
}
