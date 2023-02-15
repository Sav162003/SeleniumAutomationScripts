package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_35CustomizeTabs extends BaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		Thread.sleep(3000);

		String loginHome = driver.getTitle();
		System.out.println("Page Title :"+loginHome);
		String expectedHome =  "Home Page ~ Salesforce - Developer Edition";
		if(loginHome.equalsIgnoreCase(expectedHome))
		{
			System.out.println("Home Page launched"); 
		}
		else {
			System.out.println("Home Page not launched");
		}

		Thread.sleep(3000);	

		WebElement plusSign = driver.findElement(By.xpath("//img[@title='All Tabs']"));
		plusSign.click();
		String plusTab = driver.getTitle();
		System.out.println("Page Title :"+plusTab);
		String expectedPlusTab =  "All Tabs ~ Salesforce - Developer Edition";
		if(plusTab.equalsIgnoreCase(expectedPlusTab))
		{
			System.out.println("All Tabs Salesforce Page launched"); 
		}
		else {
			System.out.println("All Tabs Salesforce Page not launched");
		}

		WebElement customize = driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
		customize.click();
		String customTab = driver.getTitle();
		System.out.println("Page Title :"+customTab);
		String expectedCustomTab =  "Customize My Tabs ~ Salesforce - Developer Edition";
		if(customTab.equalsIgnoreCase(expectedCustomTab))
		{
			System.out.println("Customize My Tabs Salesforce Page launched"); 
		}
		else {
			System.out.println("Customize MySalesforce Page not launched");
		}
		
		/*
		 * WebElement userMenu =
		 * driver.findElement(By.xpath("//span[@id='userNavLabel']")); userMenu.click();
		 * WebElement logout = driver.findElement(By.cssSelector("a[title='Logout']"));
		 * logout.click();
		 */Thread.sleep(3000);
		driver.close();
		


	}
}
