package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {

	@Test
	public void shouldCreateContactWithValidData() {
		Contact contact = new Contact().setFirstName("Tester").setLastName("Tester");
		app.getContactHelper().createContact(contact);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(createdContact, contact);
	}
}
