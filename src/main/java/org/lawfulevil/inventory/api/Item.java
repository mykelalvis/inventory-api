/*
 * Copyright © 2019 admin (admin@infrastructurebuilder.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lawfulevil.inventory.api;

import java.util.Optional;
import java.util.Set;

import org.infrastructurebuilder.util.core.Identified;
import org.infrastructurebuilder.util.core.NameDescribed;
import org.infrastructurebuilder.util.core.Timestamped;
import org.infrastructurebuilder.util.vertx.JsonOutputEnabled;

import io.vertx.codegen.annotations.DataObject;

/**
 * Inventory is made of Item objects
 *
 * Any given Item can be a container for other Item objects, as well as an object itself
 *
 * Item objects have the following properties
 *
 * <ul>
 * <li>A unique id that cannot change over time</li>
 * <li>A non-null name and possibly a display name (but probably not)</li>
 * <li>A timestamp that is the last-updated time</li>
 * </ul>
 * @author mykel
 *
 */
@DataObject
public interface Item extends Identified, NameDescribed, Timestamped, JsonOutputEnabled {

  @Override
  default Optional<String> getDisplayName() {
    return Optional.ofNullable(getName());
  }

  /**
   * The type of the object is the indicator of which subsystem will process any
   * requests for it.  This is a simple string switch within event processing.
   *
   * The default value for "Generic Object" is InventoryConstants.DEFAULT_TYPE ( "_" )
   * @return
   */
   String getType() ;

  /**
   *
   * Optional collections are weird, but in this case it means something.  If this item has no
   * contained items, it's not a container.
   *
   * @return
   */
  Optional<Set<Item>> getContainedItems();

  default boolean isContainer() {
    return getContainedItems().isPresent();
  }

}
