package com.example.tests;

import org.testng.annotations.Test;

public class NewGroupTest extends TestBaseClass{
  @Test
  public void testAddNewGroupNonEmpty() throws Exception {
    goToHomePage();
    goToGroupPage();
    GroupData myGroupData = new GroupData();
    myGroupData.groupname = "Group 1";
    myGroupData.header = "Header 1";
    myGroupData.footer = "Footer 1";
    fillGroupDataAndSubmit(myGroupData);
    returnToGroupPage();
  }
  
}
