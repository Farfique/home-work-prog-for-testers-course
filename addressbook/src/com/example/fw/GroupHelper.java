package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{
	

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupPage() {
		click(By.linkText("group page"));
	}

	public void fillGroupData(GroupData groupData) {
	    type(By.name("group_name"), groupData.groupname);
	    type(By.name("group_header"),groupData.header);
	    type(By.name("group_footer"), groupData.footer);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void deleteGroup(int i) {
		selectGroup(i);
		click(By.name("delete"));
		
	}

	public void selectGroup(int index) {
		click(By.xpath("//input[@name='selected[]']["+ index +"]"));
	}

	public void initEdit(int i) {
		selectGroup(i);
		click(By.name("edit"));
	}

	public void updateGroup() {
		click(By.name("update"));
		
	}

}
