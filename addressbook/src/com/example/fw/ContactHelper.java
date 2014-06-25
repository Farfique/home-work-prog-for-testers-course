package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	private List<ContactData> cachedContacts;
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	public static enum WHERE {HOME, CONTACT_CREATION_PAGE};
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildContactsCache();
		}
		return cachedContacts;
	}

	public ContactHelper rebuildContactsCache() {
		cachedContacts = new ArrayList<ContactData>();
		manager.navigateTo().homePage();
		/*List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for(WebElement row : rows){
			String contactName = row.findElement(By.xpath("/td[2]")).getText();
			String lastName = row.findElement(By.xpath("/td[1]")).getText();
			String email = row.findElement(By.xpath("/td[3]")).getText();
			String firstHomePhone = row.findElement(By.xpath("/td[4]")).getText();*/
		WebElement myTable = driver.findElement(By.id("maintable"));
		List<WebElement> myTableRows = myTable.findElements(By.cssSelector("tr[name='entry']"));
		for (WebElement row : myTableRows) {
			List<WebElement> myTableCells = row.findElements(By.tagName("td"));
			String contactName = myTableCells.get(2).getText();
			String lastName = myTableCells.get(1).getText();
			String email = myTableCells.get(3).getText();
			String firstHomePhone = myTableCells.get(4).getText();
			ContactData contact = new ContactData()
			.withContactName(contactName)
			.withLastName(lastName)
			.withEmail(email)
			.withFirstHomePhone(firstHomePhone);
			cachedContacts.add(contact);	
			}
		return this;
		
	}
	public ContactHelper createNewContact(ContactData contactData) {
		manager.navigateTo().homePage();
		goToNewContactPage();
	    fillContactData(contactData, CREATION);
	    submitContact();
	    returnHomeFromNewContact();
	    rebuildContactsCache();
		return this;
	}
	
	public ContactHelper modifyContact(ContactData contactData, int index) {
		manager.navigateTo().homePage();
		initEditContact(index);
	    fillContactData(contactData, MODIFICATION);
	    updateContact();
	    returnHomeFromNewContact();
	    rebuildContactsCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().homePage();
		initEditContact(index);
		confirmContactDeletion();
	    returnHomeFromNewContact();
	    rebuildContactsCache();
		return this;
	}
	public int rndGroupIndex(WHERE where) throws Exception {
		return generateRandomIndex(getGroupsList(where));
	}

	public ContactHelper attributeGroupToOneContact(int index, int groupIndex) {
		
		selectContact(index);
		selectGroupByIndex(groupIndex);
		addGroupToContact();
		manager.navigateTo().goToAGroupPage();
		return this;
	}

	public ContactHelper attributeGroupToFewContacts(int[] index, int groupIndex) {
		
		selectContacts(index);
		selectGroupByIndex(groupIndex);
		addGroupToContact();
		manager.navigateTo().goToAGroupPage();
		return this;
	}

	public ContactHelper modifyContactByDetails(int index, ContactData contactData) {
		openContactDetails(index);
		modifyContactOnDetails();
	    fillContactData(contactData, MODIFICATION);
	    updateContact();
	    returnHomeFromNewContact();
	    rebuildContactsCache();
		return this;
	}
	//............................................

	public ContactHelper fillContactData(ContactData contactData, boolean formType) {
		//Name
		type(By.name("firstname"),contactData.getContactName());
	    //Last name
		type(By.name("lastname"),contactData.getLastName());
	    //Home Address
		type(By.name("address"),contactData.getFirstAddress());
	    //Phones
		type(By.name("home"),contactData.getFirstHomePhone());
	    type(By.name("mobile"),contactData.getMobilePhone());
	    type(By.name("work"),contactData.getWorkPhone());
	    //E-mails
	    type(By.name("email"),contactData.getEmail());
	    type(By.name("email2"),contactData.getSecondEmail());
	    //Birth date	    
	    select(By.name("bday"), contactData.getDay());
	    select(By.name("bmonth"), contactData.getMonth());
	    type(By.name("byear"),contactData.getYear());
	    if (formType){
	    //Group
	    //select(By.name("new_group"), "group 1");
	    //Alternative contacts
	    }
	    type(By.name("address2"),contactData.getSecondAddress());
	    type(By.name("phone2"),contactData.getSecondHomePhone());
	    return this;
	}

	public ContactHelper submitContact() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper goToNewContactPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper returnHomeFromNewContact() {
		click(By.linkText("home page"));
		return this;
	}
	
	public ContactHelper selectContact(int index) {
		int i = index + 2;
		click(By.xpath("//*[@id='maintable']/tbody/tr["+ i +"]/td[1]/*[@type='checkbox']"));
		return this;
	}
	
	public ContactHelper selectContacts (int[] index) {
		for (int j = 0; j < index.length; j++) {
			if (index[j] >= 0 && !isIndexTheSame(index, j)){
				selectContact(index[j]);
			}
		}
		return this;
	}
	
	public ContactHelper initEditContact(int index) {
		int i = index + 2;
		click(By.xpath("//*[@id='maintable']/tbody/tr["+ i +"]/td[7]/a"));
		return this;
	}
	
	public ContactHelper updateContact() {
		click(By.cssSelector("[value='Update']"));
		return this;
	}
	public ContactHelper confirmContactDeletion() {
		click(By.cssSelector("[value='Delete']"));	
		return this;
	}

	public ContactHelper openContactDetails(int index) {
		int i = index + 2;
		click(By.xpath("//*[@id='maintable']/tbody/tr["+ i +"]/td[6]/a"));
		return this;
	}
	public ContactHelper modifyContactOnDetails() {
		click(By.name("modifiy"));	
		return this;
	}
	public ContactHelper addGroupToContact(){
		click(By.name("add"));
		return this;
	}
	public ContactHelper selectGroupByIndex(int index) {
		selectElementByIndex(By.name("to_group"), index);	
		return this;
	}

	public List<WebElement> getGroupsList(WHERE where) throws Exception{
		if (where == WHERE.HOME){
			return getListInSelection(By.name("to_group"));
		}
		else if (where == WHERE.CONTACT_CREATION_PAGE)
			return getListInSelection(By.name("new_group"));
		else {
			throw new Exception("Can't get groups list");
		}
	}
	
	
	

	
	
}
