package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseClass {

	protected static WebDriver driver;
	protected static String baseUrl;
	protected static boolean acceptNextAlert = true;
	protected static StringBuffer verificationErrors = new StringBuffer();

	@BeforeSuite
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@AfterSuite
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	protected void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	protected void fillGroupDataAndSubmit(GroupData groupData) {
		driver.findElement(By.name("new")).click();
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(groupData.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(groupData.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(groupData.footer);
	    driver.findElement(By.name("submit")).click();
	}

	protected void goToGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	protected void goToHomePage() {
		driver.get(baseUrl + "addressbookv4.1.4/");
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	protected void returnHomeFromNewContact() {
		driver.findElement(By.linkText("home page")).click();
	}

	protected void fillContactData(ContactData contactData) {
		//Name
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(contactData.contactName);
	    //Last name
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contactData.lastName);
	    //Home Address
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contactData.firstAddress);
	    //Phones
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contactData.firstHomePhone);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contactData.mobilePhone);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(contactData.workPhone);
	    //E-mails
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contactData.email);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(contactData.secondEmail);
	    //Birth date	    
	    if (contactData.day != null){
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.day);}
	    if (contactData.month != null){
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.month);}
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contactData.year);
	    //Alternative contacts
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contactData.secondAddress);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(contactData.secondHomePhone);
	    driver.findElement(By.name("submit")).click();
	}

	protected void goToNewContactPage() {
		driver.findElement(By.linkText("add new")).click();
	}

}
