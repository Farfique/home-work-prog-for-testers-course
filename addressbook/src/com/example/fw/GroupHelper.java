package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{
	

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupPage() {
		click(By.linkText("group page"));
	}

	public void fillGroupData(GroupData groupData) {
	    type(By.name("group_name"), groupData.name);
	    type(By.name("group_header"),groupData.header);
	    type(By.name("group_footer"), groupData.footer);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void deleteGroup() {
		click(By.name("delete"));
		
	}

	public void selectGroup(int index) {
		int i = index + 1;
		click(By.xpath("//input[@name='selected[]']["+ i +"]"));
	}

	public void initEditGroup() {
		click(By.name("edit"));
			
	}

	public void updateGroup() {
		click(By.name("update"));
		
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);		
		}
		return groups;
	}

}
