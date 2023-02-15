package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_11CreateView extends BaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Create a View
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
				
		Thread.sleep(3000);
		WebElement accounts = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		accounts.click();
		Thread.sleep(3000);
		
		String accTab = driver.getTitle();
		System.out.println("Accounts Salesforce Page: "+accTab);
		String expectedAccTab = "Accounts: Home ~ Salesforce - Developer Edition";
		if (accTab.equalsIgnoreCase(expectedAccTab)) {
			System.out.println("Account home page displayed");
		} else {
			System.out.println("Account home page not displayed");
		}
		
		Thread.sleep(3000);
		WebElement noThanks	= driver.findElement(By.id("lexNoThanks"));
		noThanks.click();
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000);
		
		WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		newView.click();
		
		String  createView= driver.getTitle();
		System.out.println("Accounts Create New View page: "+createView);
		String expectedCreateView= "Accounts: Create New View ~ Salesforce - Developer Edition";
		if (createView.equalsIgnoreCase(expectedCreateView)) {
			System.out.println("Create View page displayed");
		} else {
			System.out.println("Create View page not displayed");
		}
		
		
		WebElement viewName = driver.findElement(By.id("fname"));
		viewName.click();
		viewName.sendKeys("Savi_s28");
		WebElement uniqueName = driver.findElement(By.id("devname"));
		uniqueName.click();
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
		Thread.sleep(3000);
		
		String  accView= driver.getTitle();
		System.out.println("Accounts Salesforce page: "+accView);
		String expectedAccView= "Accounts ~ Salesforce - Developer Edition";
		if (accView.equalsIgnoreCase(expectedAccView)) {
			System.out.println("Accounts page displayed");
		} else {
			System.out.println("Accounts page not displayed");
		}
		//driver.close();

	}
}
