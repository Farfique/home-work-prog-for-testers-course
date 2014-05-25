package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTest extends TestBaseClass {
	
	@Test
	public void deleteAnyGroup() throws Exception {
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupPage();
		
	}

}
