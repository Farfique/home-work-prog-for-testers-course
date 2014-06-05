package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	
		public String contactName;
	public String lastName;
	public String firstAddress;
	public String firstHomePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String secondEmail;
	public String day;
	public String month;
	public String year;
	public String secondAddress;
	public String secondHomePhone;
	
	public ContactData() {
		this.contactName = "";
		this.lastName = "";
		this.firstAddress = "";
		this.firstHomePhone = "";
		this.mobilePhone = "";
		this.workPhone = "";
		this.email = "";
		this.secondEmail = "";
		this.year = "";
		this.secondAddress = "";
		this.secondHomePhone = "";
	}
	
	public ContactData(String contactName, String lastName,
			String firstAddress, String firstHomePhone, String mobilePhone,
			String workPhone, String email, String secondEmail,
			String day, String month, String year, String secondAddress,
			String secondHomePhone) {
		this.contactName = contactName;
		this.lastName = lastName;
		this.firstAddress = firstAddress;
		this.firstHomePhone = firstHomePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.secondEmail = secondEmail;
		this.day = day;
		this.month = month;
		this.year = year;
		this.secondAddress = secondAddress;
		this.secondHomePhone = secondHomePhone;
	}
	
	@Override
	public String toString() {
		return "ContactData [contactName=" + contactName + ", lastName="
				+ lastName + ", firstHomePhone =" + firstHomePhone + ", email="
				+ email + "]";
	}
	
	@Override
	public int compareTo(ContactData other) {
		if (this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase()) == 0)
		{
			if (this.contactName.toLowerCase().compareTo(other.contactName.toLowerCase()) == 0)
			{
				if (this.firstHomePhone.toLowerCase().compareTo(other.firstHomePhone.toLowerCase()) == 0)
				{
					if (this.email.toLowerCase().compareTo(other.email.toLowerCase()) == 0)
						return this.email.toLowerCase().compareTo(other.email.toLowerCase());
				}
				else
					return this.firstHomePhone.toLowerCase().compareTo(other.firstHomePhone.toLowerCase());
				
			}
			else
				return this.contactName.toLowerCase().compareTo(other.contactName.toLowerCase());
		}
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		
	}
	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		/*result = prime * result
				+ ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstHomePhone == null) ? 0 : firstHomePhone.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());*/
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
		ContactData other = (ContactData) obj;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstHomePhone == null) {
			if (other.firstHomePhone != null)
				return false;
		} else if (!firstHomePhone.equals(other.firstHomePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


}