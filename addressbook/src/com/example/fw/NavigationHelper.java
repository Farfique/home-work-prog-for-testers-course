package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);

	}

	public void goToHomePage() {
		driver.get(manager.baseUrl + "addressbookv4.1.4/");
	}

	public void goToGroupPage() {
		click(By.linkText("groups"));
	}

}
