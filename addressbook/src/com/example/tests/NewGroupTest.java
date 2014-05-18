package com.example.tests;

import org.testng.annotations.Test;

public class NewGroupTest extends NewGroupBaseClass{
  @Test
  public void testAddNewGroupNonEmpty() throws Exception {
    goToHomePage();
    goToGroupPage();
    GroupDataParameter myGroupData = new GroupDataParameter();
    myGroupData._groupname = "Group 1";
    myGroupData._header = "Header 1";
    myGroupData._footer = "Footer 1";
    fillGroupDataAndSubmit(myGroupData);
    returnToGroupPage();
  }
  
}
