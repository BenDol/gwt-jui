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
package nz.co.doltech.gwtjui.core.client.events;

import com.google.gwt.user.client.Event;
import nz.co.doltech.gwtjui.core.client.JuiWrapper;
import nz.co.doltech.gwtjui.core.client.base.EventHash;
import nz.co.doltech.gwtjui.core.client.base.JuiHashEvent;

/**
 * This event is triggered when sorting was stopped,
 * is propagated to all possible connected lists.
 *
 * @author Ben Dol
 */
@SuppressWarnings({"unchecked"})
public class DeactivateEvent<T extends JuiWrapper, H extends EventHash> extends JuiHashEvent<T, H, DeactivateHandler> {

    public static <T extends JuiWrapper, H extends EventHash> void fire(T source, H hash, Event nativeEvent) {
        source.fireEvent(new DeactivateEvent<T, H>(source, hash, nativeEvent));
    }

    private static final Type<DeactivateHandler> TYPE = new Type<>();

    public static Type<DeactivateHandler> getType() {
        return TYPE;
    }

    private DeactivateEvent(T source, H hash, Event nativeEvent) {
        super(source, hash, nativeEvent);
    }

    @Override
    public Type<DeactivateHandler> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(final DeactivateHandler handler) {
        handler.onDeactivate(this);
    }
}
