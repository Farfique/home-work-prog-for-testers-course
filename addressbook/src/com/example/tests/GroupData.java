package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	
	private String id;
	private String name;
	private String header;
	private String footer;

	public GroupData() {
		
		this.name = "";
		this.header = "";	
		this.footer = "";	
	}	
	
	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getHeader() {
		return header;
	}


	public String getFooter() {
		return footer;
	}


	public GroupData(String name, String header, String footer) {
		this.name = name;
		this.header = header;	
		this.footer = footer;			
	}
	
	public void updateData (GroupData another){
		if (!another.name.isEmpty()&&another.name != null)
			this.name = another.name;
		if (!another.header.isEmpty()&&another.header != null)
			this.header = another.header;
		if (!another.footer.isEmpty()&&another.footer != null)
			this.footer = another.footer;
	}

	@Override
	public String toString() {
		return "GroupData [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}

	public GroupData withName(String name) {
		this.name = name;
		return this;
	}

	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setHeader(String header) {
		this.header = header;
	}


	public void setFooter(String footer) {
		this.footer = footer;
	}
	
	

	
	
}