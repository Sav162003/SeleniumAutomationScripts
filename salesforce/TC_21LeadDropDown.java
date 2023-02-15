package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_21LeadDropDown extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Lead Drop Down
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

		String leadsPage = driver.getTitle();
		System.out.println("Leads Home Page: "+leadsPage);
		String expected = "Leads: Home ~ Salesforce - Developer Edition";
		if(leadsPage.equalsIgnoreCase(expected)) {
			System.out.println("Leads page displayed");
		}
		else {
			System.out.println("Leads page not displayed");
		}
		WebElement leadDropDown = driver.findElement(By.id("fcf"));
		leadDropDown.click();
		Thread.sleep(3000);
		if(leadDropDown.isDisplayed()) {
				System.out.println("Drop down list visible");
			}
			else {
				System.out.println("Drop down list not visible");
			}
		//	driver.close();

	}
}
