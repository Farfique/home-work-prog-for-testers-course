package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBaseClass{
	
	@Test(dataProvider = "randomValidGroupGenerator")

  public void testAddNewGroupWithValidData(GroupData myGroupData) throws Exception {
   	app.getNavigationHelper().goToHomePage();
    app.getNavigationHelper().goToGroupPage();
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    // actions
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupData(myGroupData);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().rebuildCache();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    // compare two states
    oldList.add(myGroupData);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
