package com.feb04.salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_14AccReport extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Account Report
		
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
		
		WebElement accReport = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		//a[contains(text(),'Accounts with last activity > 30 days')]
		accReport.click();	
				
		String unsavedReport = driver.getTitle();
		System.out.println("Unsaved Report Salesforce Page: "+unsavedReport);
		String expected = "Unsaved Report ~ Salesforce - Developer Edition";
		if (unsavedReport.equalsIgnoreCase(expected)) {
			System.out.println("Unsaved Report page displayed");
		} else {
			System.out.println("Unsaved Report page not displayed");
		}
				
		Thread.sleep(3000);
		
		WebElement dateField = driver.findElement(By.id("ext-gen148"));
		dateField.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);

		WebElement dateFrom = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		dateFrom.click();
		Thread.sleep(3000);
		
		WebElement fromToday = driver.findElement(By.xpath("//button[@id='ext-gen281']"));
		fromToday.click();
		Thread.sleep(3000);
		
		WebElement dateTo = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		dateTo.click();
		Thread.sleep(3000);
		WebElement toToday = driver.findElement(By.xpath("//button[@id='ext-gen296']"));
		toToday.click();
		Thread.sleep(3000);
		
		WebElement save= driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		save.click();
		Thread.sleep(3000);
		WebElement reportName = driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		reportName.sendKeys("Rep2023");
		WebElement uniqueRepName = driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		uniqueRepName.clear();
		uniqueRepName.sendKeys("Feb10");
		Thread.sleep(4000);
		
		WebElement saveDialog = driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"));
		saveDialog.click();
		Thread.sleep(3000);
		
		String repName = driver.getTitle();
		System.out.println("Report Name Salesforce Page: "+repName);
		String expectedRepName = "Rep2023 ~ Salesforce - Developer Edition";
		if (repName.equalsIgnoreCase(expectedRepName)) {
			System.out.println("Report Name page displayed");
		} else {
			System.out.println("Report Name page not displayed");
		}
		
//		driver.close();

	}
}
