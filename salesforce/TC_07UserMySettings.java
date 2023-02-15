package com.feb04.salesforce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_07UserMySettings extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// User My Settings
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();		WebElement user = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		user.click();
		Thread.sleep(3000);

		WebElement mySettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		mySettings.click();
		Thread.sleep(3000);
		String userSettings= driver.getTitle();
		System.out.println("My Settings Salesforce Page: "+userSettings );
		String expectedUserSettings  = "Hello, Savitha M! ~ Salesforce - Developer Edition";
		if (userSettings.equalsIgnoreCase(expectedUserSettings)) {
			System.out.println("User Account Settings page displayed");
		} else {
			System.out.println("User Account Settings page not displayed");
		}

		WebElement personal = driver.findElement(By.id("PersonalInfo"));
		personal.click();
		Thread.sleep(3000);

		WebElement logHistory = driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		logHistory.click();
		String loginHistory= driver.getTitle();
		System.out.println("Login History Salesforce Page: "+loginHistory );
		String expectedLoginHistory  = "Login History ~ Salesforce - Developer Edition";
		if (loginHistory.equalsIgnoreCase(expectedLoginHistory)) {
			System.out.println("Login History page displayed");
		} else {
			System.out.println("Login History page not displayed");
		}
		
		WebElement download = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		download.click();
		System.out.println("The csv file is downloaded for the login history");
		
		WebElement dislay = driver.findElement(By.id("DisplayAndLayout"));
		dislay.click();
		Thread.sleep(3000);
		WebElement custMyTabs = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		custMyTabs.click();
		Thread.sleep(3000);
		
		String custTab= driver.getTitle();
		System.out.println("Customize my Tabs Salesforce Page: "+custTab );
		String expectedCustTab  = "Customize My Tabs ~ Salesforce - Developer Edition";
		if (custTab.equalsIgnoreCase(expectedCustTab)) {
			System.out.println("Customize My Tabs page displayed");
		} else {
			System.out.println("Customize My Tabs page not displayed");
		}

		WebElement custom = driver.findElement(By.id("p4"));
		Select ob = new Select(custom);
		ob.selectByVisibleText("Salesforce Chatter");
		WebElement tabs = driver.findElement(By.id("duel_select_0"));
		Select tab = new Select(tabs);
		tab.selectByVisibleText("Reports");
		WebElement add = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
		add.click();
		
		WebElement emailButton = driver.findElement(By.id("EmailSetup_font"));
		emailButton.click();
				
		WebElement myEmailSet = driver.findElement(By.id("EmailSettings_font"));
		myEmailSet.click();
		Thread.sleep(3000);
		
		String emailpg= driver.getTitle();
		System.out.println("Email Settings Salesforce Page: "+emailpg );
		String expectedEmailpg  = "My Email Settings ~ Salesforce - Developer Edition";
		if (emailpg.equalsIgnoreCase(expectedEmailpg)) {
			System.out.println("My Email Settings page displayed");
		} else {
			System.out.println("My Email Settings page not displayed");
		}
		
		WebElement emailName = driver.findElement(By.xpath("//input[@id='sender_name']"));
		emailName.clear();
		emailName.sendKeys("Tom Cruise");
		WebElement emailadd = driver.findElement(By.xpath("//input[@id='sender_email']"));
		emailadd.clear();
		emailadd.sendKeys("savi_s16@yahoo.com");
		Thread.sleep(3000);
		
		String emailpg2= driver.getTitle();
		System.out.println("Email Settings Salesforce Page: "+emailpg2 );
		String expectedEmailpg2  = "My Email Settings ~ Salesforce - Developer Edition";
		if (emailpg2.equalsIgnoreCase(expectedEmailpg2)) {
			System.out.println("My Email Settings page displayed");
		} else {
			System.out.println("My Email Settings page not displayed");
		}
				
		WebElement radioBcc = driver.findElement(By.id("auto_bcc1"));
		radioBcc.click();
		WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']|//input[@title = 'Save']"));
		save.click();
		System.out.println("Settings successfully saved");
		Thread.sleep(3000);
				
		WebElement calReminder = driver.findElement(By.id("CalendarAndReminders_font"));
		calReminder.click();
		Thread.sleep(3000);
		
		WebElement activityreminder = driver.findElement(By.id("Reminders_font"));
		activityreminder.click();
		String reminder= driver.getTitle();
		System.out.println("Activity Reminders Salesforce Page: "+reminder );
		String expectedReminder  = "Activity Reminders ~ Salesforce - Developer Edition";
		if (reminder.equalsIgnoreCase(expectedReminder)) {
			System.out.println("Activity Reminders page displayed");
		} else {
			System.out.println("Activity Reminders page not displayed");
		}
		WebElement reminderTest = driver.findElement(By.id("testbtn"));
		reminderTest.click();
		System.out.println("Reminders popup displayed");
		
		String mainWindow =driver.getWindowHandle();
		Set<String>allWindowHandle=driver.getWindowHandles();
		for(String handle:allWindowHandle) {
			if(!mainWindow.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		WebElement dismissAll = driver.findElement(By.xpath("//input[@id ='dismiss_all' and @class = 'btn']"));
		dismissAll.click();
		

		
				
		//driver.close();



	}
}
