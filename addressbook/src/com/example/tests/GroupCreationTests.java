package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase{
	@DataProvider
	public Iterator<Object[]> groupsFromCSVFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> groupsFromXMLFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	

	@Test(dataProvider = "groupsFromXMLFile")

  public void testAddNewGroupWithValidData(GroupData myGroupData) throws IOException {
   	
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
