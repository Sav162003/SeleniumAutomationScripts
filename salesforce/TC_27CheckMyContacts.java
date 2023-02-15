package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_27CheckMyContacts extends BaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Check My Contacts
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

		WebElement recentlyCreated = driver.findElement(By.id("hotlist_mode"));
		recentlyCreated.click();
		Select ob = new Select(recentlyCreated);
		ob.selectByVisibleText("Recently Created");

		if(recentlyCreated.isDisplayed()) {
			System.out.println("Drop down list visible");
		}
		else {
			System.out.println("Drop down list not visible");
		}

		driver.close();
	}
}
