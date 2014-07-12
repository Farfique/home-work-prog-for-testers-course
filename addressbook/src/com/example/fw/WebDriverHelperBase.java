package com.example.fw;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverHelperBase extends HelperBase {

	
	protected WebDriver driver;
	public boolean acceptNextAlert = true;
	private WebDriverWait wait;
	
	public WebDriverHelperBase(ApplicationManager manager){
		super(manager);
		this.driver = manager.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
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
	
	public void type(By locator, String text) {
		if (text.length() != 0 && text!=null){
		driver.findElement(locator).clear();
	    driver.findElement(locator).sendKeys(text);
		}
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void select(By locator, String text) {
		if (text != null){
			new Select(driver.findElement(locator)).selectByVisibleText(text);
	    }
	}
	public List<WebElement> getListInSelection(By locator){
		Select selection = new Select(driver.findElement(locator));
		List<WebElement> options = selection.getOptions();
		return options;
	}

	public void selectElementByIndex(By locator, int index) {
		new Select(driver.findElement(locator)).selectByIndex(index);		
	}
	
	public <T> int generateRandomQuantity(List<T> list){
		int qty;
		qty = generateRandomIndex(list) + 1;
		return qty;
		}

	public boolean isIndexTheSame(int[] index, int item){
		boolean same = false;
		for (int j = 0; j<item; j++){
			if (index[item]== index[j]){
				same = true;
			}	
		}
		return same;
	}
	
	public <T> int generateRandomIndex(List<T> list){
		Random rnd = new Random();
		int index = 0;
		if (list.size() >= 1){
			index = rnd.nextInt(list.size()-1);
		}
		else
			index = -1;
		return index;
	}
	
	public <T> int[] generateFewIndexes(List<T> list){
		int quantity = generateRandomQuantity(list);
	    int[] index = new int[quantity];
	    for (int i = 0; i< quantity; i++){
	    	do
	    	index[i] = generateRandomIndex(list);
	    	while (isIndexTheSame(index, i));
	    }
	    return index;
	}	
}
