package com.example.tests;

public class ContactDataParameter {
	public String _contactName;
	public String _lastName;
	public String _firstAddress;
	public String _firstHomePhone;
	public String _mobilePhone;
	public String _workPhone;
	public String _email;
	public String _secondEmail;
	public BirthDateParameter birthDate;
	public String _secondAddress;
	public String _secondHomePhone;
	
	public ContactDataParameter() {
	}
	
	public ContactDataParameter(BirthDateParameter birthDate) {
		this.birthDate = birthDate;
	}
	
	public ContactDataParameter(String _contactName, String _lastName,
			String _firstAddress, String _firstHomePhone, String _mobilePhone,
			String _workPhone, String _email, String _secondEmail,
			BirthDateParameter birthDate, String _secondAddress,
			String _secondHomePhone) {
		this._contactName = _contactName;
		this._lastName = _lastName;
		this._firstAddress = _firstAddress;
		this._firstHomePhone = _firstHomePhone;
		this._mobilePhone = _mobilePhone;
		this._workPhone = _workPhone;
		this._email = _email;
		this._secondEmail = _secondEmail;
		this.birthDate = birthDate;
		this._secondAddress = _secondAddress;
		this._secondHomePhone = _secondHomePhone;
	}
}