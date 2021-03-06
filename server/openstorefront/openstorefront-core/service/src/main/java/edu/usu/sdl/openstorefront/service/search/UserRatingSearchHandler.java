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
package edu.usu.sdl.openstorefront.service.search;

import com.orientechnologies.orient.core.record.impl.ODocument;
import edu.usu.sdl.openstorefront.common.util.Convert;
import edu.usu.sdl.openstorefront.core.entity.ComponentReview;
import edu.usu.sdl.openstorefront.core.model.search.SearchElement;
import edu.usu.sdl.openstorefront.core.model.search.SearchOperation;
import edu.usu.sdl.openstorefront.validation.ValidationResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author dshurtleff
 */
public class UserRatingSearchHandler
		extends BaseSearchHandler
{

	public UserRatingSearchHandler(List<SearchElement> searchElements)
	{
		super(searchElements);
	}

	@Override
	protected ValidationResult internalValidate()
	{
		ValidationResult validationResult = new ValidationResult();

		for (SearchElement searchElement : searchElements) {
			if (StringUtils.isBlank(searchElement.getValue())) {
				validationResult.getRuleResults().add(getRuleResult("Value", "Required"));
			}
			if (StringUtils.isNumeric(searchElement.getValue()) == false) {
				validationResult.getRuleResults().add(getRuleResult("Value", "Must be a integer number"));
			}
		}

		return validationResult;
	}

	@Override
	public List<String> processSearch()
	{
		List<String> foundIds = new ArrayList<>();
		SearchOperation.MergeCondition mergeCondition = SearchOperation.MergeCondition.OR;
		for (SearchElement searchElement : searchElements) {

			String query = "select componentId, avg(rating) as rating from " + ComponentReview.class.getSimpleName() + " group by componentId ";

			Integer checkValue = Convert.toInteger(searchElement.getValue());
			if (checkValue == null) {
				checkValue = 0;
			}

			List<ODocument> queryResults = serviceProxy.getPersistenceService().query(query, new HashMap<>());
			List<String> results = new ArrayList<>();
			for (ODocument oDocument : queryResults) {
				Integer value = oDocument.field("rating");
				if (searchElement.getNumberOperation().pass(value, checkValue)) {
					results.add(oDocument.field("componentId"));
				}
			}
			foundIds = mergeCondition.apply(foundIds, results);
			mergeCondition = searchElement.getMergeCondition();
		}
		return foundIds;
	}

}
