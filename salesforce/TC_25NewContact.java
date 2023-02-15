package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_25NewContact extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// New Contact
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

		WebElement contactNew = driver.findElement(By.xpath("//input[@title='New']"));
		contactNew.click();
		String newContact = driver.getTitle();
		System.out.println("Contact New home Page: "+newContact);
		String expectedNew = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		if (newContact.equalsIgnoreCase(expectedNew)) {
			System.out.println("Contact New page displayed");
		} else {
			System.out.println("Contact New page not displayed");
		}

		WebElement lastName = driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
		lastName.click();
		lastName.sendKeys("Harsh");
		WebElement accName = driver.findElement(By.xpath("//input[@id='con4']"));
		accName.click();
		accName.sendKeys("Shreeya");
		//td[@id='topButtonRow']//input[@title='Save']
		WebElement save = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		save.click();
		String contactName = driver.getTitle();
		System.out.println("New Contact home Page: "+contactName);
		String expectedName = "Contact: Harsh ~ Salesforce - Developer Edition";
		if (contactName.equalsIgnoreCase(expectedName)) {
			System.out.println(" New Contact page displayed");
		} else {
			System.out.println("New Contact page not displayed");
		}
		//*[@id="contactHeaderRow"]/div[2]/h2

		driver.close();

	}
}
