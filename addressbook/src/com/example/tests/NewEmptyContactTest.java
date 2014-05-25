package com.example.tests;

import org.testng.annotations.Test;

public class NewEmptyContactTest extends TestBaseClass{
  
  @Test
  public void testAddNewEmptyContact() throws Exception {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().goToNewContactPage();
    ContactData contactData = new ContactData();
    app.getContactHelper().fillContactData(contactData);
    app.getContactHelper().submitContact();
    app.getContactHelper().returnHomeFromNewContact();
  }  
}