package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBaseClass {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testEditGroup(GroupData groupData) throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    int index = generateRandomIndex(oldList);
	    
	    app.getGroupHelper().selectGroup(index);
	    app.getGroupHelper().initEditGroup();
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	    app.getGroupHelper().rebuildCache();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    oldList.get(index).updateData(groupData);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	//@Test(dataProvider = "randomValidGroupGenerator")
	public void testEditNoGroup(GroupData groupData) throws Exception{
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    app.getGroupHelper().initEditGroup();
	    app.getGroupHelper().fillGroupData(groupData);
	    app.getGroupHelper().updateGroup();
	    app.getGroupHelper().returnToGroupPage();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    assertEquals(newList, oldList);
	}

}
