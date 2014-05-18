package com.example.tests;

import org.testng.annotations.Test;

public class NewEmptyContactTest extends NewBaseClass{
  
  @Test
  public void testAddNewEmptyContact() throws Exception {
    goToHomePage();
    goToNewContactPage();
    BirthDateParameter birthDate = new BirthDateParameter();
    ContactDataParameter contactData = new ContactDataParameter(birthDate);
    fillContactData(contactData);
    returnHomeFromNewContact();
  }  
}