package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_22LeadDefaultView extends BaseTest{

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
			System.out.println("Leads page displayed");
		}
		else {
			System.out.println("Leads page not displayed");
		}
		WebElement leadDropDown = driver.findElement(By.id("fcf"));
		leadDropDown.click();
		Thread.sleep(3000);
		Select ob = new Select(leadDropDown);
		ob.selectByVisibleText("My Unread Leads");


		WebElement profile = driver.findElement(By.id("userNavLabel"));
		profile.click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		Thread.sleep(2000);
		String salesLogin = driver.getTitle();
		System.out.println("Login Salesforce Page: "+salesLogin);
		String expectedLogin = "Login | Salesforce";
		if (salesLogin.equalsIgnoreCase(expectedLogin)) {
			System.out.println("Login page displayed");
		} else {
			System.out.println("Login page not displayed");
		}

		driver.close();

	}
}
