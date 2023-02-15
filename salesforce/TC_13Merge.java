package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_13Merge extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Merge Users
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


		String expected = "Savi_s26";
		WebElement viewName = driver.findElement(By.id("fcf"));
		if(viewName.isDisplayed()) {
			String actual = viewName.getText();
			if(actual.equalsIgnoreCase(expected)) {
				System.out.println("Name displayed");	
			}
			else {
				System.out.println("Name not displayed");
			}
		}
		WebElement mergeAcc = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		mergeAcc.click();	
		Thread.sleep(3000);
		
		String accMerge = driver.getTitle();
		System.out.println("Merge Accounts Salesforce Page: "+accMerge);
		String expectedAccMerge = "Merge My Accounts ~ Salesforce - Developer Edition";
		if (accMerge.equalsIgnoreCase(expectedAccMerge)) {
			System.out.println("Merge My Accounts page displayed");
		} else {
			System.out.println("Merge My Accounts page not displayed");
		}
		
		WebElement searchName = driver.findElement(By.id("srch"));
		searchName.click();
		searchName.sendKeys("Shreeya");
		Thread.sleep(3000);
		
		WebElement findAcc = driver.findElement(By.xpath("//input[@value ='Find Accounts' and @name ='srchbutton']"));
		findAcc.click();
		
		WebElement mergeNext = driver.findElement(By.xpath("//input[@title ='Next']"));
		mergeNext.click();
		WebElement merge = driver.findElement(By.xpath("//input[@title = 'Merge']"));
		merge.click();
		Thread.sleep(3000);
		Alert popup = driver.switchTo().alert();
		Thread.sleep(3000);
		popup.accept();


	}
}
