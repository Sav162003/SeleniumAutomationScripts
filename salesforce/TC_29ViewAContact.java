package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_29ViewAContact extends BaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// View Contact
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

		WebElement myContact = driver.findElement(By.xpath("//a[@title='[Alt+1]']//img[@title='Contact: Harsh']"));
		myContact.click();

		String actualContactsHome = driver.getTitle();
		System.out.println("Page Title :"+actualContactsHome);
		String contactHome =  "Account: Harsh ~ Salesforce - Developer Edition";
		if(actualContactsHome.equalsIgnoreCase(contactHome))
		{
			System.out.println("Contact Home launched"); 
		}
		else {
			System.out.println("Contact Home not launched");
		}
		driver.close();

	}
}
