# Introduction

This is a library to make it easy to serialize specific Java objects to and from JSON.

The library is developed as a support for [BitPipeline](http://www.bitpipeline.eu/)'s projects so it will not try to be generic, extensible or maintain back compatibility.

# Usage

Simply use the provided jar as a library in your project.

You can then extend any class you want to serialise to and from JSON by making it extend the JSONEntity class.

## Example

Given the class:

	class Entity extends JSONEntity {
		boolean aBoolean;
		byte aByte;
		char aChar;
		short aShort;
		int aInt;
		long aLong;
		float aFloat;
		double aDouble;

		String aString;
		Map<String, String> aMap;
		Map<String, List<String>> aMapOfLists;

		transient int transientValue;

		public Entity () {
			super ();
		}

		/** You must always have this constructor in JSONEntities. */
		public Entity (JSONObject json) throws JSONMappingException {
			super (json);
		}

		public Entity (String source) throws JSONMappingException, JSONException {
			super (source);
		}

	}

You can now de-serialize into this object by doing:

	String jsonString = /* read the JSON string from somewhere */
	Entity entity = new Entity (jsonString);

And you can serialize it with:

	String serialization = entity.toString ();

or, if you want a pretty print:

	String prettySerialization = entity.toString (4);

where the integer parameter to the method `toString` is the number of spaces to
use for indentation.

## Rules

### Must have constructor
The classes that extend the `JSONEntity` must have a constructor with a single `JSONObject` type argument. Without this constructor it will be possible to serialize to a JSONObject but not _from_ a JSONObject.

### Initialization of fields
`JSONEntity` based classes _must_ not initialize their fields in their declaration. As far as I can see the subclass initialization takes place after the call to the `super` constructor and overides the values set by it.

### Transient fields
Fields marked as transient are not (des)serialized. In the example `Entity` class the field  `transientValue` will not be kept.

### Maps
For now all maps must have `String` as the key type.

## Examples

The test class `EquipmentTest` has a rather more complex data type being (un)serialized. It's a object that contains arrays of other JSONEntities, enumarations, and a special case of serialization (look at `AbstractEquipment` class) where customize the mechanism of (un)serialization.


# License

Copyright 2012 J. Miguel P. Tavares

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.