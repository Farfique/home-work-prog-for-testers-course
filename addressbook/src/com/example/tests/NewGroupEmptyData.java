package com.example.tests;

import org.testng.annotations.Test;

public class NewGroupEmptyData extends NewGroupBaseClass {
	@Test
	  public void testAddNewGroupEmpty() throws Exception {
	    goToHomePage();
	    goToGroupPage();
	    fillGroupDataAndSubmit(new GroupDataParameter());
	    returnToGroupPage();
	  }
}
