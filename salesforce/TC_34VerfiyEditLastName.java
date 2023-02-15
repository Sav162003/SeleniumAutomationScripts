package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_34VerfiyEditLastName extends BaseTest {

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
		WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		home.click();
		String homeTab = driver.getTitle();
		System.out.println("Page Title :"+homeTab);
		String expectedHomeTab =  "Salesforce - Developer Edition";
		if(homeTab.equalsIgnoreCase(expectedHomeTab))
		{
			System.out.println("Salesforce Page launched"); 
		}
		else {
			System.out.println("Salesforce Page not launched");
		}

		WebElement noThanks = driver.findElement(By.id("lexNoThanks"));
		noThanks.click();
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000);


		WebElement nameLink = driver.findElement(By.xpath("//span[@class='mruText'][normalize-space()='Savitha M']"));
		nameLink.click();

		String userHome = driver.getTitle();
		System.out.println("Page Title :"+userHome);
		String profileHome =  "User: Savitha M ~ Salesforce - Developer Edition";
		if(userHome.equalsIgnoreCase(profileHome))
		{
			System.out.println("User Page launched"); 
		}
		else {
			System.out.println("User Page not launched");
		}

		WebElement editUser = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		editUser.click();	

		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		driver.switchTo().frame(iframe);

		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		about.click();

		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.clear();
		lastName.click();
		lastName.sendKeys("Abcd");

		WebElement saveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveAll.click();

		String newUserHome = driver.getTitle();
		System.out.println("Page Title :"+userHome);
		String newProfileHome =  "User: Savitha Abcd ~ Salesforce - Developer Edition";
		if(newUserHome.equalsIgnoreCase(newProfileHome))
		{
			System.out.println("Changed Lastname User Page launched"); 
		}
		else {
			System.out.println("Changed Lastname User Page not launched");
		}

		driver.close();

	}
}
