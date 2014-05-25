package com.example.tests;

import org.testng.annotations.Test;

public class NewEmptyGroupTest extends TestBaseClass {
	
	@Test
	  public void testAddNewEmptyGroup() throws Exception {
	    app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    app.getGroupHelper().initGroupCreation();
	    app.getGroupHelper().fillGroupData(new GroupData());
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	  }
}
