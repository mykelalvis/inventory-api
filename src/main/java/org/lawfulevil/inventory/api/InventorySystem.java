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

import java.util.List;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Future;

@VertxGen
@ProxyGen
public interface InventorySystem {


  /**
   * Fetch every item from the system
   * @return
   */
  Future<List<Item>> getAllItems();

  Future<List<Item>> getItemsOfType(String type);

  Future<Item> createItem(String name, String displayName, String type);

  Future<Boolean> updateItem(Item item);
}
