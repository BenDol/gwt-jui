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
package nz.co.doltech.gwtjui.interactions.client.events;

import com.google.gwt.event.shared.EventHandler;
import nz.co.doltech.gwtjui.core.client.JuiWrapper;
import nz.co.doltech.gwtjui.core.client.base.EventHash;

/**
 * Triggered during the select operation,
 * on each element removed from the selection.
 *
 * @author Ben Dol
 */
public interface UnselectingHandler<T extends JuiWrapper, H extends EventHash> extends EventHandler {
    void onUnselecting(UnselectingEvent<T, H> event);
}
