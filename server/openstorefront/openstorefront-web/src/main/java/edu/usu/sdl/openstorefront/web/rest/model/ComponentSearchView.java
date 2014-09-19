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

import edu.usu.sdl.openstorefront.service.ServiceProxy;
import edu.usu.sdl.openstorefront.storage.model.Component;
import edu.usu.sdl.openstorefront.storage.model.ComponentTag;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jlaw
 */
public class ComponentSearchView
{

	private String componentId;
	private String name;
	private String description;
	private String parentComponentId;
	private String guid;
	private String organization;
	private Date releaseDate;
	private String version;
	private String approvalState;
	private String approvedUser;
	private Date approvedDts;
	private Date lastActivityDts;
	private List<ComponentTag> tags;

	private String activeStatus;
	private String createUser;
	private Date createDts;
	private String updateUser;
	private Date updateDts;

	private List<ComponentAttributeView> attributes;

	public ComponentSearchView()
	{
	}

	public static ComponentSearchView toView(Component component)
	{
		ServiceProxy service = new ServiceProxy();
		ComponentSearchView view = new ComponentSearchView();
		view.setComponentId(component.getComponentId());
		view.setName(component.getName());
		view.setDescription(component.getDescription());
		view.setParentComponentId(component.getParentComponentId());
		view.setGuid(component.getGuid());
		view.setApprovalState(component.getActiveStatus());
		view.setApprovedDts(component.getApprovedDts());
		view.setApprovedUser(component.getApprovedUser());
		view.setLastActivityDts(component.getLastActivityDts());
		view.setOrganization(component.getOrganization());
		view.setReleaseDate(component.getReleaseDate());
		view.setVersion(component.getVersion());
		view.setTags(service.getComponentService().getBaseComponent(ComponentTag.class, component.getComponentId()));

		view.setActiveStatus(component.getActiveStatus());
		view.setCreateUser(component.getCreateUser());
		view.setUpdateDts(component.getUpdateDts());
		view.setCreateDts(component.getCreateDts());
		view.setUpdateUser(component.getUpdateUser());

		return view;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getParentComponentId()
	{
		return parentComponentId;
	}

	public void setParentComponentId(String parentComponentId)
	{
		this.parentComponentId = parentComponentId;
	}

	public String getGuid()
	{
		return guid;
	}

	public void setGuid(String guid)
	{
		this.guid = guid;
	}

	public String getOrganization()
	{
		return organization;
	}

	public void setOrganization(String organization)
	{
		this.organization = organization;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getApprovalState()
	{
		return approvalState;
	}

	public void setApprovalState(String approvalState)
	{
		this.approvalState = approvalState;
	}

	public String getApprovedUser()
	{
		return approvedUser;
	}

	public void setApprovedUser(String approvedUser)
	{
		this.approvedUser = approvedUser;
	}

	public Date getApprovedDts()
	{
		return approvedDts;
	}

	public void setApprovedDts(Date approvedDts)
	{
		this.approvedDts = approvedDts;
	}

	public Date getLastActivityDts()
	{
		return lastActivityDts;
	}

	public void setLastActivityDts(Date lastActivityDts)
	{
		this.lastActivityDts = lastActivityDts;
	}

	public Date getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public String getComponentId()
	{
		return componentId;
	}

	public void setComponentId(String componentId)
	{
		this.componentId = componentId;
	}

	/**
	 * @return the attributes
	 */
	public List<ComponentAttributeView> getAttributes()
	{
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<ComponentAttributeView> attributes)
	{
		this.attributes = attributes;
	}

	/**
	 * @return the activeStatus
	 */
	public String getActiveStatus()
	{
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(String activeStatus)
	{
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the createUser
	 */
	public String getCreateUser()
	{
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser)
	{
		this.createUser = createUser;
	}

	/**
	 * @return the createDts
	 */
	public Date getCreateDts()
	{
		return createDts;
	}

	/**
	 * @param createDts the createDts to set
	 */
	public void setCreateDts(Date createDts)
	{
		this.createDts = createDts;
	}

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser()
	{
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser)
	{
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateDts
	 */
	public Date getUpdateDts()
	{
		return updateDts;
	}

	/**
	 * @param updateDts the updateDts to set
	 */
	public void setUpdateDts(Date updateDts)
	{
		this.updateDts = updateDts;
	}

	/**
	 * @return the tags
	 */
	public List<ComponentTag> getTags()
	{
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<ComponentTag> tags)
	{
		this.tags = tags;
	}

}