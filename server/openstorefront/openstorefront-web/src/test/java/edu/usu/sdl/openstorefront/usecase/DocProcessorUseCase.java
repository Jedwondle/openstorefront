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
package edu.usu.sdl.openstorefront.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.usu.sdl.openstorefront.common.util.StringProcessor;
import edu.usu.sdl.openstorefront.core.view.UserProfileView;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author dshurtleff
 */
public class DocProcessorUseCase
{

	@Test
	public void testProcessor() throws JsonProcessingException
	{
		Set<String> fields = new HashSet<>();
		fields.add("username");

		String json = StringProcessor.stripeFieldJSON(StringProcessor.defaultObjectMapper().writeValueAsString(new UserProfileView()), fields);
		System.out.println(json);
	}

}
