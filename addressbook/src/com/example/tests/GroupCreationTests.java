package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBaseClass{
	
  @Test
  public void testAddNewGroupWithValidData() throws Exception {
   	app.getNavigationHelper().goToHomePage();
    app.getNavigationHelper().goToGroupPage();
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    // actions
    app.getGroupHelper().initGroupCreation();
    GroupData myGroupData = new GroupData("Group name", "New header", "Footer" );
    app.getGroupHelper().fillGroupData(myGroupData);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    // compare two states
    oldList.add(myGroupData);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  @Test
  public void testAddNewEmptyGroup() throws Exception {
   	app.getNavigationHelper().goToHomePage();
    app.getNavigationHelper().goToGroupPage();
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    // actions
    app.getGroupHelper().initGroupCreation();
    GroupData myGroupData = new GroupData();
    app.getGroupHelper().fillGroupData(myGroupData);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    // compare two states
    oldList.add(myGroupData);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
