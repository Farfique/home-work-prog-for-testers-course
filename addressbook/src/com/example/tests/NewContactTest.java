package com.example.tests;

import org.testng.annotations.Test;

public class NewContactTest extends TestBaseClass{
  
  @Test
  public void testAddNewFullContact() throws Exception {
    goToHomePage();
    goToNewContactPage();
    ContactData contactData = new ContactData();
    contactData.contactName = "TestName";
    contactData.lastName = "Rabinovich";
    contactData.firstAddress = "Energeticheskaya, 20";
    contactData.firstHomePhone = "22-22-22";
    contactData.mobilePhone = "8-921-222-22-22";
    contactData.workPhone = "33-33-33";
    contactData.email = "test@test.ru";
    contactData.secondEmail = "test2@test.ru";
    contactData.day = "13";
    contactData.month = "September";
    contactData.year = "1987";
    contactData.secondAddress = "Energeticheskaya, 40";
    contactData.secondHomePhone = "322-22-22";
    fillContactData(contactData);
    returnHomeFromNewContact();
  }

  
}