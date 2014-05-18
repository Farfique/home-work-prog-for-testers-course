package com.example.tests;

import org.testng.annotations.Test;

public class NewContactTest1 extends NewBaseClass{
  
  @Test
  public void testAddNewFullContact() throws Exception {
    goToHomePage();
    goToNewContactPage();
    BirthDateParameter birthDate1 = new BirthDateParameter("13", "September", "1987");
    ContactDataParameter contactData = new ContactDataParameter();
    contactData._contactName = "TestName";
    contactData._lastName = "Rabinovich";
    contactData._firstAddress = "Energeticheskaya, 20";
    contactData._firstHomePhone = "22-22-22";
    contactData._mobilePhone = "8-921-222-22-22";
    contactData._workPhone = "33-33-33";
    contactData._email = "test@test.ru";
    contactData._secondEmail = "test2@test.ru";
    contactData.birthDate = birthDate1;
    contactData._secondAddress = "Energeticheskaya, 40";
    contactData._secondHomePhone = "322-22-22";
    fillContactData(contactData);
    returnHomeFromNewContact();
  }

  
}