package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_22ALeadDefaultView extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Lead Default View
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		Thread.sleep(3000);

		WebElement accountPlus = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		accountPlus.click();
		Thread.sleep(3000);

		String allTab = driver.getTitle();
		System.out.println("All Tabs Salesforce Page: "+allTab);
		String expectedAllTab = "All Tabs ~ Salesforce - Developer Edition";
		if (allTab.equalsIgnoreCase(expectedAllTab)) {
			System.out.println("All Tabs page displayed");
		} else {
			System.out.println("All Tabs page not displayed");
		}

		WebElement leads = driver.findElement(By.xpath	("//img[@title='Leads']"));
		leads.click();
		Thread.sleep(3000);
		WebElement noThanks = driver.findElement(By.id("lexNoThanks"));
		noThanks.click();
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000);

		String leadsHomePage = driver.getTitle();
		System.out.println("Leads Home Page: "+leadsHomePage);
		String expected = "Leads: Home ~ Salesforce - Developer Edition";
		if(leadsHomePage.equalsIgnoreCase(expected)) {
			System.out.println("Leads Home page displayed");
		}
		else {
			System.out.println("Leads Home page not displayed");
		}
		Thread.sleep(3000);
		WebElement go = driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click(); 
		WebElement profile = driver.findElement(By.id("userNavLabel"));
		profile.click(); 
		WebElement logout =	driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();

		driver.close();

	}
}
