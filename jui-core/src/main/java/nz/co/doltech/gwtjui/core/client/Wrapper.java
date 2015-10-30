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
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Wrapper extends Panel implements HasOneWidget {

    private class GhostWidget extends Widget {
        public GhostWidget(Element element) {
            setElement(element);
        }

        @Override
        public boolean isAttached() {
            return true;
        }
    }

    private Widget widget;

    protected Wrapper() {}

    public Wrapper(Element element) {
        setWidget(new GhostWidget(element));
    }

    public Wrapper(Widget widget) {
        setWidget(widget);
    }

    /**
     * Sets the widget to be wrapped by the wrapper. The wrapped widget must be
     * set before calling any {@link Widget} methods on this object, or adding it
     * to a panel. This method may only be called once for a given wrapper.
     *
     * @param widget the widget to be wrapped
     */
    @Override
    public void setWidget(Widget widget) {
        // Validate. Make sure the widget is not being set twice.
        if (this.widget != null) {
            throw new IllegalStateException("Wrapper.initWidget() may only be "
                + "called once.");
        }

        if (widget == null) {
            throw new NullPointerException("widget cannot be null");
        }

        // Use the contained widget's element as the composite's element,
        // effectively merging them within the DOM.
        setElement((Element) widget.getElement());

        // Logical attach.
        this.widget = widget;
        this.widget.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent event) {
                if(event.isAttached()) {
                    onLoad();
                } else {
                    onUnload();
                }
            }
        });

        if(widget.isAttached()) {
            // Forcefully invoke the wrapper load.
            // This can be the case when applying
            // an already attached widget.
            onLoad();
        }
    }

    @Override
    public void setWidget(IsWidget w) {
        setWidget(w.asWidget());
    }

    @Override
    public Widget getWidget() {
        return widget;
    }

    @Override
    public void add(Widget w) {
        if (getWidget() != null) {
            throw new IllegalStateException("Can only contain one child widget");
        }
        setWidget(w);
    }

    @Override
    public void add(IsWidget w) {
        add(w.asWidget());
    }

    @Override
    public boolean remove(Widget w) {
        return false;
    }

    @Override
    public boolean remove(IsWidget w) {
        return false;
    }

    @Override
    public void clear() {}

    @Override
    public Iterator<Widget> iterator() {
        // Return a simple iterator that enumerates the
        // 0 or 1 elements in this composite.
        return new Iterator<Widget>() {
            boolean hasElement = widget != null;
            Widget returned = null;

            public boolean hasNext() {
                return hasElement;
            }

            public Widget next() {
                if (!hasElement || (widget == null)) {
                    throw new NoSuchElementException();
                }
                hasElement = false;
                return (returned = widget);
            }

            public void remove() {
                if (returned != null) {
                    Wrapper.this.remove(returned);
                }
            }
        };
    }

    public String getId() {
        return getElement().getId();
    }

    public void setId(String id) {
        getElement().setId(id);
    }
}
