package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBaseClass {
	@Test
	public void deleteGroups() throws Exception {
		app.getNavigationHelper().goToHomePage();
	    app.getNavigationHelper().goToGroupPage();
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    // actions
	    int quantity = generateRandomQuantity(oldList);
	    int[] index = new int[quantity];
	    
	    for (int i = 0; i< quantity; i++){
	    	index[i] = generateRandomIndex(oldList);
	    	//Not to uncheck the same item
	    	boolean same = isIndexTheSame(index, i);
	    	if (!same)
	    		app.getGroupHelper().selectGroup(index[i]);
	    }
		app.getGroupHelper().deleteGroup();
		app.getGroupHelper().returnToGroupPage();
		app.getGroupHelper().rebuildCache();
		
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    // compare two states
	    Arrays.sort(index);
	    for(int i = quantity-1; i>=0; i--){
	    	boolean same = isIndexTheSame(index, i);
	    	if (!same)
	    		oldList.remove(index[i]);
	    }
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
