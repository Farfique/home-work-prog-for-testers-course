package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase{
	
	//private SortedListOf<GroupData> cachedGroups;
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	/*public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null)
		{
			rebuildCache();
		}
		return cachedGroups;
		
	} */
	
	public SortedListOf<GroupData> getUIGroups() {
		
		SortedListOf<GroupData> cachedGroups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withName(name));		
		}		
		return cachedGroups;
	} 
	
	public GroupHelper createGroup(GroupData myGroupData) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
	    fillGroupData(myGroupData);
	    submitGroupCreation();
	    returnToGroupPage();
	    //manager.getModel().addGroup(myGroupData);
	    //rebuildCache();	
		return this;
	}

	public GroupHelper modifyGroup(GroupData groupData, int index) {
		manager.navigateTo().groupsPage();
		selectGroup(index);
	    initEditGroup();
	    fillGroupData(groupData);
	    updateGroup();
	    returnToGroupPage();
	    //manager.getModel().removeGroup(index).addGroup(groupData);
	    //rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroups(int[] index) {
		manager.navigateTo().groupsPage();
		selectGroups(index);
		confirmGroupDeletion();
		returnToGroupPage();
		//manager.getModel().removeGroup(index);
		//rebuildCache();
		return this;
	}

	//...............................

	public GroupHelper returnToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper fillGroupData(GroupData groupData) {
	    type(By.name("group_name"), groupData.getName());
	    type(By.name("group_header"),groupData.getHeader());
	    type(By.name("group_footer"), groupData.getFooter());
		return this;
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper confirmGroupDeletion() {
		click(By.name("delete"));
		return this;
		
	}

	public GroupHelper selectGroups (int[] index) {
		for (int j = 0; j < index.length; j++) {
			if (index[j] >= 0 && !isIndexTheSame(index, j)){
				int i = index[j] + 1;
				click(By.xpath("//input[@name='selected[]']["+ i +"]"));
			}
		}
		return this;
	}
	
	public GroupHelper selectGroup(int index) {
			if (index >= 0 ){
				int i = index + 1;
				click(By.xpath("//input[@name='selected[]']["+ i +"]"));
			}
		return this;
	}
	
	public GroupHelper initEditGroup() {
		click(By.name("edit"));
		return this;
			
	}

	public GroupHelper updateGroup() {
		click(By.name("update"));
		return this;
		
	}

	

	
	

}
