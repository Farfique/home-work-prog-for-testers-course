package com.example.tests;

import org.testng.annotations.Test;

public class NewEmptyGroupTest extends TestBaseClass {
	@Test
	  public void testAddNewEmptyGroup() throws Exception {
	    goToHomePage();
	    goToGroupPage();
	    fillGroupDataAndSubmit(new GroupData());
	    returnToGroupPage();
	  }
}
