package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBaseClass {
	
	@Test
	public void deleteAnyGroup() throws Exception {
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().selectGroup(2);
		app.getGroupHelper().deleteGroup();
		app.getGroupHelper().returnToGroupPage();
		
	}
	@Test
	public void deleteFewGroups() throws Exception {
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().selectGroup(1);
	    app.getGroupHelper().selectGroup(2);
		app.getGroupHelper().deleteGroup();
		app.getGroupHelper().returnToGroupPage();
		
	}

}
