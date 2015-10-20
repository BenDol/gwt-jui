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
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public abstract class Wrapper extends Widget implements IsWidget {

    private class GhostWidget extends Widget {
        public GhostWidget(Element element) {
            setElement(element);
        }
    }

    private Widget widget;

    public Wrapper(Element element) {
        setupWidget(new GhostWidget(element));
    }

    public Wrapper(Widget widget) {
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
}
