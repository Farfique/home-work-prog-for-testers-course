package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBaseClass {
	
	@Test
	public void deleteAnyGroup() throws Exception {
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    int index = 1;
	    app.getGroupHelper().selectGroup(index);
		app.getGroupHelper().deleteGroup();
		app.getGroupHelper().returnToGroupPage();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	@Test
	public void deleteFewGroups() throws Exception {
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    int index1 = 1;
	    int index2 = 2;
	    app.getGroupHelper().selectGroup(index1);
	    app.getGroupHelper().selectGroup(index2);
		app.getGroupHelper().deleteGroup();
		app.getGroupHelper().returnToGroupPage();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    oldList.remove(index2);
	    oldList.remove(index1);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
