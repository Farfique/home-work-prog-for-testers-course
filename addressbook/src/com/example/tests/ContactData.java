package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	
	private String id;
	private String contactName;
	private String lastName;
	private String firstAddress;
	private String firstHomePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String secondEmail;
	private String day;
	private String month;
	private String year;
	private String secondAddress;
	private String secondHomePhone;
	
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
	
	public String getId() {
		return id;
	}

	public String getContactName() {
		return contactName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstAddress() {
		return firstAddress;
	}

	public String getFirstHomePhone() {
		return firstHomePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmail() {
		return email;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public String getDay() {
		return this.day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getSecondAddress() {
		return secondAddress;
	}

	public String getSecondHomePhone() {
		return secondHomePhone;
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
	public void updateContactData(ContactData another){
		if (!another.contactName.isEmpty() && another.contactName != null){
			this.contactName = another.contactName;
		}
		if (!another.lastName.isEmpty() && another.lastName != null){
			this.lastName = another.lastName;
		}
		if (!another.email.isEmpty() && another.email != null){
			this.email = another.email;
		}
		if (!another.firstHomePhone.isEmpty() && another.firstHomePhone != null){
			this.firstHomePhone = another.firstHomePhone;
		}
		if (!another.firstAddress.isEmpty() && another.firstAddress != null){
			this.firstAddress = another.firstAddress;
		}
		if (!another.mobilePhone.isEmpty() && another.mobilePhone != null){
			this.mobilePhone = another.mobilePhone;
		}
		if (!another.secondHomePhone.isEmpty() && another.secondHomePhone != null){
			this.secondHomePhone = another.secondHomePhone;
		}
		if (!another.secondEmail.isEmpty() && another.secondEmail != null){
			this.secondEmail = another.secondEmail;
		}
		if (!another.secondAddress.isEmpty() && another.secondAddress != null){
			this.secondAddress = another.secondAddress;
		}
		if (!another.workPhone.isEmpty() && another.workPhone != null){
			this.workPhone = another.workPhone;
		}
		if (!another.day.isEmpty() && another.day != null){
			this.day = another.day;
		}
		if (!another.month.isEmpty() && another.month != null){
			this.month = another.month;
		}
		if (!another.year.isEmpty() && another.year != null){
			this.year = another.year;
		}
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
				if ((this.firstHomePhone.toLowerCase().compareTo(other.firstHomePhone.toLowerCase()) == 0)
						||((this.firstHomePhone.equals("")||this.firstHomePhone == null)&&(this.mobilePhone.toLowerCase().compareTo(other.firstHomePhone.toLowerCase()) == 0))
						||((other.firstHomePhone.equals("")||other.firstHomePhone == null)&&(this.firstHomePhone.toLowerCase().compareTo(other.mobilePhone.toLowerCase()) == 0)))
				{
					if (this.email.toLowerCase().compareTo(other.email.toLowerCase()) == 0)
						return this.email.toLowerCase().compareTo(other.email.toLowerCase());
					else if((this.email.equals("")||this.email == null)&&(this.secondEmail.toLowerCase().compareTo(other.email.toLowerCase()) == 0)){
						return this.secondEmail.toLowerCase().compareTo(other.email.toLowerCase());
					}
					else if ((other.email.equals("")||other.email==null)&&(this.email.toLowerCase().compareTo(other.secondEmail.toLowerCase()) == 0)){
						return this.email.toLowerCase().compareTo(other.secondEmail.toLowerCase());
					} 
					else {
						return this.email.toLowerCase().compareTo(other.email.toLowerCase());
					}
						
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
		if ((email == null||email.isEmpty()) && !(other.email == null||other.email.isEmpty())){
				if (!secondEmail.equals(other.email))
					return false;
		}
		else if ((other.email == null||other.email.isEmpty()) && !(email == null)||email.isEmpty()){
				if (!email.equals(other.secondEmail))
					return false;
		}
		else if (!email.equals(other.email))
			return false;
		if ((firstHomePhone == null||firstHomePhone.isEmpty())&& !(other.firstHomePhone == null||other.firstHomePhone.isEmpty())) {
			if (!mobilePhone.equals(other.firstHomePhone))
				return false;
		} else if (!((firstHomePhone == null)||firstHomePhone.isEmpty()) && (other.firstHomePhone == null||other.firstHomePhone.isEmpty())) {
			if (!firstHomePhone.equals(other.mobilePhone))
				return false;
		}
		else if (!firstHomePhone.equals(other.firstHomePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public ContactData withContactName(String name) {
		contactName = name;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
		return this;
	}

	public ContactData withFirstHomePhone(String firstHomePhone) {
		this.firstHomePhone = firstHomePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.day = birthDay;
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.month = birthMonth;
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		year = birthYear;
		return this;
	}

	public ContactData withSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
		return this;
	}

	public ContactData withSecondHomePhone(String secondHomePhone) {
		this.secondHomePhone = secondHomePhone;
		return this;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
	}

	public void setFirstHomePhone(String firstHomePhone) {
		this.firstHomePhone = firstHomePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}

	public void setSecondHomePhone(String secondHomePhone) {
		this.secondHomePhone = secondHomePhone;
	}

}