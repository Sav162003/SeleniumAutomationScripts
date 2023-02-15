package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_24NewTodaysLead extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// New Todays Lead
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
		WebElement newLead = driver.findElement(By.xpath("//input[@title='New']"));
		newLead.click();
		Thread.sleep(3000);

		String leadsNewPage = driver.getTitle();
		System.out.println("Leads New Page: "+leadsNewPage);
		String expectedNewPage = "Lead Edit: New Lead ~ Salesforce - Developer Edition";
		if(leadsNewPage.equalsIgnoreCase(expectedNewPage)) {
			System.out.println("New Lead Home page displayed");
		}
		else {
			System.out.println("New Lead Home page not displayed");
		}
		WebElement lastName = driver.findElement(By.id("name_lastlea2"));
		lastName.click();
		lastName.sendKeys("ABCD");
		WebElement companyName = driver.findElement(By.id("lea3"));
		companyName.click();
		companyName.sendKeys("ABCD");
		WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		save.click();
		String leadUserPage = driver.getTitle();
		System.out.println("Leads User Page :"+leadUserPage);
		String expectedUserPage = "Lead: ABCD ~ Salesforce - Developer Edition";
		if(leadUserPage.equalsIgnoreCase(expectedUserPage)) {
			System.out.println("Leads User page displayed");
		}
		else {
			System.out.println("Leads User page not displayed");
		}
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.id("userNavLabel"));
		profile.click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();

		driver.close();

	}
}
