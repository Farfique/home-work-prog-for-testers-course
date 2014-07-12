package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);

	}

	public void homePage() {
		if (!onHomePage()){
		driver.get(manager.baseUrl);
		}
	}

	private boolean onHomePage() {
		return driver.findElements(By.id("Maintable")).size() > 0;
	}

	public void groupsPage() {
		if (!onGroupsPage()){
		click(By.linkText("groups"));
		}
	}
	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/groups.php") && driver.findElements(By.cssSelector("input[name='new']")).size() > 0){
			return true;
		}
		else
			return false;
	}

	public void goToAGroupPage(){
		click(By.xpath("//*[@id='content']/div/i/a"));
	}
}
