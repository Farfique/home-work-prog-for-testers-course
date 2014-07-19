package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testEditGroup(GroupData groupData) throws Exception{
		
	    // save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUIGroups();
	    
	    // actions
	    int index = app.getGroupHelper().generateRandomIndex(oldList);
	    app.getGroupHelper().modifyGroup(groupData, index);
	    
	    //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUIGroups();
	    
	    // compare two states
	    oldList.get(index).updateData(groupData);
	   
	   assertThat(newList, equalTo(oldList.update()));
	}
	
	//@Test(dataProvider = "randomValidGroupGenerator")
	public void testEditNoGroup(GroupData groupData) throws Exception{
		
	    // save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUIGroups();
	    
	    // actions
	    app.getGroupHelper().modifyGroup(groupData, -1);
	    
	    //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUIGroups();
	    
	    // compare two states
	    assertThat(newList, equalTo(oldList));
	}

}
