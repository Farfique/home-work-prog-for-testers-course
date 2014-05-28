package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBaseClass {
	
	@Test
	public void testEditGroup() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().selectGroup(1);
	    app.getGroupHelper().initEditGroup();
	    GroupData groupData = new GroupData();
	    groupData.groupname = "New name";
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	}
	
	@Test
	public void testEditNoGroup() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().initEditGroup();
	    GroupData groupData = new GroupData();
	    groupData.groupname = "Newname";
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	}
	@Test
	public void testEditFewGroups() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().selectGroup(1);
	    app.getGroupHelper().selectGroup(2);
	    app.getGroupHelper().initEditGroup();
	    GroupData groupData = new GroupData();
	    groupData.groupname = "Newname";
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	}

}
