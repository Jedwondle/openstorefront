/*
 * Copyright 2015 Space Dynamics Laboratory - Utah State University Research Foundation.
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
package edu.usu.sdl.openstorefront.validation;

import edu.usu.sdl.openstorefront.service.ServiceProxy;
import edu.usu.sdl.openstorefront.storage.model.GeneralMedia;
import java.lang.reflect.Field;

/**
 *
 * @author dshurtleff
 */
public class GeneralMediaUniqueHandler
		implements BaseUniqueHandler
{

	@Override
	public boolean isUnique(Field field, Object value)
	{
		boolean unique = true;
		ServiceProxy serviceProxy = new ServiceProxy();

		GeneralMedia generalMediaExample = new GeneralMedia();
		generalMediaExample.setName((String) value);

		GeneralMedia media = serviceProxy.getPersistenceService().queryOneByExample(GeneralMedia.class, generalMediaExample);
		if (media != null) {
			unique = false;
		}

		return unique;
	}

}
