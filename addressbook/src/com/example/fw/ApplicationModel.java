package com.example.fw;

import java.util.Arrays;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
import com.google.common.collect.Lists;

public class ApplicationModel {

	private SortedListOf<GroupData> groups;
	public SortedListOf<GroupData> getGroups(){
		return groups;
	};
	public void setGroups(SortedListOf<GroupData> groups){
		this.groups = new SortedListOf<GroupData>(groups);
	}
	public ApplicationModel addGroup(GroupData myGroupData) {
		groups.add(myGroupData);
		return this;
	}
	public ApplicationModel removeGroup(int[] index) {
		Arrays.sort(index);
		for(int i = index.length-1; i>=0; i--){
			groups.list.remove(index[i]);
		}
		return this;
	}
	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}
}
