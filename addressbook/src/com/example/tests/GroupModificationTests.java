package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBaseClass {
	
	@Test
	public void testEditGroup() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    int index = 0;
	    app.getGroupHelper().selectGroup(index);
	    app.getGroupHelper().initEditGroup();
	    GroupData groupData = new GroupData();
	    groupData.name = "New name";
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    oldList.remove(index);
	    oldList.add(groupData);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	//@Test
	public void testEditNoGroup() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    app.getGroupHelper().initEditGroup();
	    GroupData groupData = new GroupData();
	    groupData.name = "Newname";
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    assertEquals(newList, oldList);
	}

}
