package com.feb04.salesforce;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_37BlockingEventWeekly extends BaseTest {

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


		WebElement dateLink = driver.findElement(By.xpath("//a[contains(text(),'Tuesday February 14, 2023')]"));
		dateLink.click();

		String userHome = driver.getTitle();
		System.out.println("Page Title :"+userHome);
		String profileHome =  "Calendar for Savitha Abcd ~ Salesforce - Developer Edition";
		if(userHome.equalsIgnoreCase(profileHome))
		{
			System.out.println("Calendar for User Page launched"); 
		}
		else {
			System.out.println("Calendar for User Page not launched");
		}

		WebElement time = driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
		time.click();
		String newEvent = driver.getTitle();
		System.out.println("Page Title :"+newEvent);
		String expectedNewEvent =  "Calendar: New Event ~ Salesforce - Developer Edition";
		if(newEvent.equalsIgnoreCase(expectedNewEvent))
		{
			System.out.println("Calendar New Event Page launched"); 
		}
		else {
			System.out.println("Calendar New Event Page not launched");
		}
		
		/*
		 * WebElement iframe =
		 * driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		 * driver.switchTo().frame(iframe);
		 */
		WebElement comboBox = driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
		comboBox.click();
		Thread.sleep(4000);
		String popup =driver.getWindowHandle();
		driver.switchTo().window(popup);
		Thread.sleep(6000);
		/*
		 * WebElement other = driver.findElement(By.xpath("//li[@class='listItem4']"));
		 * other.click();
		 */
		WebElement endTime = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		endTime.click();
		Thread.sleep(3000);
		
		WebElement timePick = driver.findElement(By.xpath("//div[@id='timePickerItem_42']"));
		timePick.click();
		Thread.sleep(3000);
	
    	WebElement save = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		save.click();
		Thread.sleep(3000);

		String calendarHome = driver.getTitle();
		System.out.println("Page Title :"+calendarHome);
		String expected =  "User: Savitha Abcd ~ Salesforce - Developer Edition";
		if(calendarHome.equalsIgnoreCase(expected))
		{
			System.out.println("Calendar for user Page launched"); 
		}
		else {
			System.out.println("Calendar for User Page not launched");
		}

		driver.close();

	}
}
