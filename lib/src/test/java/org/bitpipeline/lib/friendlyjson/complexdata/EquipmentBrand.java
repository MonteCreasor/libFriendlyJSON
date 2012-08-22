/**
 * Copyright 2012 J. Miguel P. Tavares <mtavares@bitpipeline.eu>
 *         BitPipeline
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package org.bitpipeline.lib.friendlyjson.complexdata;

import java.util.Map;

import org.bitpipeline.lib.friendlyjson.JSONMappingException;
import org.json.JSONObject;

public class EquipmentBrand extends AbstractEquipment {
	public EquipmentBrand (JSONObject json) throws JSONMappingException {
		super (json);
	}

	public EquipmentBrand (String name, String imageUrl, String description, Map<String, String> info) {
		super (name, imageUrl, description, info);
	}

	public EquipmentBrand (String name, String imageUrl, String description) {
		super (name, imageUrl, description);
	}
}