package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_26CreateNewViewContact extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Create New View Contact
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
		
		WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		newView.click();

		String viewPage = driver.getTitle();
		System.out.println("Contacts create new view page: "+viewPage);
		String expectedView = "Contacts: Create New View ~ Salesforce - Developer Edition";
		if(viewPage.equalsIgnoreCase(expectedView)) {
				System.out.println("Create new view page displayed");
			}
			else {
				System.out.println("Create new view page not displayed");
			}
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.click();
		viewName.sendKeys("VIEw Name");
		WebElement viewUnique = driver.findElement(By.xpath("//input[@id='devname']"));
		viewUnique.click();
		viewUnique.clear();
		viewUnique.sendKeys("VIEwUniqueName");
		WebElement save = driver.findElement(By.xpath("(//input[@title='Save'])[1]"));
		save.click();

		String actualHome = driver.getTitle();
		System.out.println("Page Title :"+actualHome);
		String contactHome = "Contacts ~ Salesforce - Developer Edition";
		if(actualHome.equalsIgnoreCase(contactHome)) {
			System.out.println("Contact Home launched");
		}
		else {
			System.out.println("Contact Home not launched");
		}

	driver.close();

	}
}
