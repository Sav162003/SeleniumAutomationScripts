package com.feb04.salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_28CheckRecentContact extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Check Recent Contact
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		Thread.sleep(3000);

		WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
		contact.click();
		Thread.sleep(3000);
		WebElement noThanks = driver.findElement(By.id("lexNoThanks"));
		noThanks.click(); 
		WebElement close =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000); //img[@title='Contact']

		String contactTab = driver.getTitle();
		System.out.println("Contacts home Page: "+contactTab);
		String expectedTab = "Contacts: Home ~ Salesforce - Developer Edition";
		if (contactTab.equalsIgnoreCase(expectedTab)) {
			System.out.println("Contacts Home page displayed");
		} else {
			System.out.println("Contacts Home page not displayed");
		}

		WebElement viewContact = driver.findElement(By.name("fcf"));
		viewContact.click();
		Select ob = new Select(viewContact);
		ob.selectByVisibleText("My Contacts");
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_ENTER);
		if(viewContact.isDisplayed()) {
			System.out.println("My contacts are displayed");
		}
		else {
			System.out.println("My contacts are not displayed");
		}

		WebElement go = driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click();

		String actualContactsHome = driver.getTitle();
		System.out.println("Page Title :"+actualContactsHome);
		String contactHome =  "Contacts ~ Salesforce - Developer Edition";
		if(actualContactsHome.equalsIgnoreCase(contactHome))
		{
			System.out.println("Contacts Home launched"); 
		}
		else {
			System.out.println("Contacts Home not launched");
		}
		driver.close();

	}
}
