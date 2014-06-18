package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	private List<ContactData> cachedContacts;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildContactsCache();
		}
		return cachedContacts;
	}

	public void rebuildContactsCache() {
		cachedContacts = new ArrayList<ContactData>();
		
		WebElement myTable = driver.findElement(By.id("maintable"));
		List<WebElement> myTableRows = myTable.findElements(By.tagName("tr"));
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			int row = checkboxes.indexOf(checkbox) + 1;
			List<WebElement> myTableCells = myTableRows.get(row).findElements(By.tagName("td"));
			
			ContactData contact = new ContactData();
			contact.contactName = myTableCells.get(2).getText();
			contact.lastName = myTableCells.get(1).getText();
			contact.email = myTableCells.get(3).getText();
			contact.firstHomePhone = myTableCells.get(4).getText();
			
			/*contact.contactName = driver.findElement(By.xpath("//*[@id='maintable']//tr[" + row + "]/td[3]")).getText();
			contact.lastName = driver.findElement(By.xpath("//*[@id='maintable']//tr[" + row + "]/td[2]")).getText();
			contact.email = driver.findElement(By.xpath("//*[@id='maintable']//tr[" + row + "]/td[4]")).getText();
			contact.firstHomePhone = driver.findElement(By.xpath("//*[@id='maintable']//tr[" + row + "]/td[5]")).getText();*/
			cachedContacts.add(contact);	
			}
		
	}

	public void fillContactData(ContactData contactData) {
		//Name
		type(By.name("firstname"),contactData.contactName);
	    //Last name
		type(By.name("lastname"),contactData.lastName);
	    //Home Address
		type(By.name("address"),contactData.firstAddress);
	    //Phones
		type(By.name("home"),contactData.firstHomePhone);
	    type(By.name("mobile"),contactData.mobilePhone);
	    type(By.name("work"),contactData.workPhone);
	    //E-mails
	    type(By.name("email"),contactData.email);
	    type(By.name("email2"),contactData.secondEmail);
	    //Birth date	    
	    select(By.name("bday"), contactData.day);
	    select(By.name("bmonth"), contactData.month);
	    type(By.name("byear"),contactData.year);
	    //Group
	    //select(By.name("new_group"), "group 1");
	    //Alternative contacts
	    type(By.name("address2"),contactData.secondAddress);
	    type(By.name("phone2"),contactData.secondHomePhone);
	}

	public void submitContact() {
		click(By.name("submit"));
	}

	public void goToNewContactPage() {
		click(By.linkText("add new"));
	}

	public void returnHomeFromNewContact() {
		click(By.linkText("home page"));
	}
	
	public void selectContact(int index) {
		int i = index + 2;
		click(By.xpath("//*[@id='maintable']/tbody/tr["+ i +"]/td[1]/*[@type='checkbox']"));
	}
	
	public void initEditContact(int index) {
		int i = index + 2;
		click(By.xpath("//*[@id='maintable']/tbody/tr["+ i +"]/td[7]/a"));
	}
	
	public void updateContact() {
		click(By.cssSelector("[value='Update']"));
	}
	public void deleteContact() {
		click(By.cssSelector("[value='Delete']"));	
	}

	public void openContactDetails(int index) {
		int i = index + 2;
		click(By.xpath("//*[@id='maintable']/tbody/tr["+ i +"]/td[6]/a"));
	}
	public void modifyContactOnDetails() {
		click(By.name("modifiy"));	
	}
	public void addGroupToContact(){
		click(By.name("add"));
	}
	public void selectGroupByIndex(int index) {
		selectElementByIndex(By.name("to_group"), index);		
	}
	
}
