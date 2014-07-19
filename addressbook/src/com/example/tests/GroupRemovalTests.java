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
		SortedListOf<GroupData> oldBDList = app.getHibernateHelper().listGroups();
	    
	    // actions
	    int[] index = app.getGroupHelper().generateFewIndexes(oldBDList);
	    app.getGroupHelper().deleteGroups(index);
		
	    //save new state
	    SortedListOf<GroupData> newUIList = app.getGroupHelper().getUIGroups();
	    SortedListOf<GroupData> newBDList = app.getHibernateHelper().listGroups();
	    
	    // compare two states
	    Arrays.sort(index);
	    assertThat(newBDList, equalTo(oldBDList.without(index)));
	    assertThat(newUIList, equalTo(newBDList));
	}

}
