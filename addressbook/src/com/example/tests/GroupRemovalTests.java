package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {
	@Test
	public void deleteGroups() throws Exception {
		
	    // save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
	    int[] index = app.getGroupHelper().generateFewIndexes(oldList);
	    app.getGroupHelper().deleteGroups(index);
		
	    //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare two states
	    Arrays.sort(index);
	    assertThat(newList, equalTo(oldList.without(index)));
	}

}
