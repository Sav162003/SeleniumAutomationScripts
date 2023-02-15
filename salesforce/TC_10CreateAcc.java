package com.feb04.salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TC_10CreateAcc extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Create an Account
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
		
		WebElement newAccount = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newAccount.click();
		
		String accEdit = driver.getTitle();
		System.out.println("Accounts Edit Salesforce Page: "+accEdit );
		String expectedAccEdit  = "Account Edit: New Account ~ Salesforce - Developer Edition";
		if (accEdit.equalsIgnoreCase(expectedAccEdit)) {
			System.out.println("Account Edit home page displayed");
		} else {
			System.out.println("Account Edit home page not displayed");
		}
		Thread.sleep(3000);
		WebElement accName = driver.findElement(By.id("acc2"));
		accName.click();
		accName.clear();
		accName.sendKeys("Shreeya");
		Thread.sleep(3000);
		
		
		Thread.sleep(2000);
		WebElement type = driver.findElement(By.id("acc6"));
		type.click();
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyPress(KeyEvent.VK_T);
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.mouseWheel(4);
		Thread.sleep(4000);
		

		WebElement custPriority = driver.findElement(By.id("00NDn00000SjEIK"));
		custPriority.click();
		Robot high = new Robot();
		high.keyPress(KeyEvent.VK_DOWN);
		high.keyPress(KeyEvent.VK_H);
		high.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		save.click();
		
		String userAcc= driver.getTitle();
		System.out.println("Accounts User Salesforce Page: "+userAcc );
		String expectedUserAcc  = "Account: Shreeya ~ Salesforce - Developer Edition";
		if (userAcc.equalsIgnoreCase(expectedUserAcc)) {
			System.out.println("Account user home page displayed");
		} else {
			System.out.println("Account user home page not displayed");
		}
		driver.close();
	
	}
}
