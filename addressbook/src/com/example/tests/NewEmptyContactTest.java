package com.example.tests;

import org.testng.annotations.Test;

public class NewEmptyContactTest extends TestBaseClass{
  
  @Test
  public void testAddNewEmptyContact() throws Exception {
    goToHomePage();
    goToNewContactPage();
    ContactData contactData = new ContactData();
    fillContactData(contactData);
    returnHomeFromNewContact();
  }  
}