/*
 * Copyright 2014 Space Dynamics Laboratory - Utah State University Research Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.usu.sdl.openstorefront.web.rest.model;

import edu.usu.sdl.openstorefront.storage.model.XRefAttributeMap;
import edu.usu.sdl.openstorefront.storage.model.XRefAttributeType;
import java.util.List;

/**
 *
 * @author jlaw
 */
public class XRef
{
	private XRefAttributeType type;
	private List<XRefAttributeMap> map;

	public XRef(){
		
	}
	
	/**
	 * @return the type
	 */
	public XRefAttributeType getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(XRefAttributeType type)
	{
		this.type = type;
	}

	/**
	 * @return the map
	 */
	public List<XRefAttributeMap> getMap()
	{
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(List<XRefAttributeMap> map)
	{
		this.map = map;
	}
}
