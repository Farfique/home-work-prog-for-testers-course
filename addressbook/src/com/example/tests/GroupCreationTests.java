package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")

  public void testAddNewGroupWithValidData(GroupData myGroupData) throws Exception {
   	
    // save old state
    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().createGroup(myGroupData);
    
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare two states
    assertThat(newList, equalTo(oldList.withAdded(myGroupData)));
  }
}
