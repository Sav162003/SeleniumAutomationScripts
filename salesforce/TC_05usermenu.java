package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TC_05usermenu extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// User Menu
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		
		
		String actual = driver.getTitle();
		System.out.println("Home Page Title : "+actual);
		String expectedContact = "Home Page ~ Salesforce - Developer Edition";
		if (actual.equalsIgnoreCase(expectedContact)) {
			System.out.println("Home page displayed");
		} else {
			System.out.println("Home page not displayed");
		}

		Thread.sleep(3000);
		WebElement user = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		if(user.isDisplayed()) {
		user.click();
		System.out.println("User is available");
		}
		else {
			System.out.println("User unavailable");
		}
		driver.close();
	
	}


}
