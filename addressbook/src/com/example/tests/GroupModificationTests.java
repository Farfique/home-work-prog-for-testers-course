package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBaseClass {
	
	@Test
	public void testEditGroup() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().initEdit(1);
	    GroupData groupData = new GroupData();
	    groupData.groupname = "New name";
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	}
	

}
