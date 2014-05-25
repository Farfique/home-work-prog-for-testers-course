package com.example.tests;

import org.testng.annotations.Test;

public class NewGroupTest extends TestBaseClass{
  @Test
  public void testAddNewGroupNonEmpty() throws Exception {
   	app.getNavigationHelper().goToHomePage();
    app.getNavigationHelper().goToGroupPage();
    GroupData myGroupData = new GroupData();
    myGroupData.groupname = "Group 1";
    myGroupData.header = "Header 1";
    myGroupData.footer = "Footer 1";
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupData(myGroupData);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
  
}
