package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_18StuckOpportunity extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Stuck Opportunity
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

		WebElement opportunity = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/a"));
		opportunity.click();
		Thread.sleep(3000);

		String oppoPage = driver.getTitle();
		System.out.println("Opportunities Salesforce Page: "+oppoPage);
		String expectedOppoPage = "Opportunities: Home ~ Salesforce - Developer Edition";
		if (oppoPage.equalsIgnoreCase(expectedOppoPage)) {
			System.out.println("Opportunities page displayed");
		} else {
			System.out.println("Opportunities page not displayed");
		}

		WebElement noThanks = driver.findElement(By.id("lexNoThanks"));
		noThanks.click();
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000);

		WebElement stuckOpportunity = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		stuckOpportunity.click();
		
		String stuckPage = driver.getTitle();
		String expectedStuckPage = "Stuck Opportunities ~ Salesforce - Developer Edition";
		if(stuckPage.equalsIgnoreCase(expectedStuckPage)) {
			System.out.println("Stuck Opportunity page displayed");
			}
			else {
				System.out.println("Stuck Opportunity page not displayed");
			}
	
		driver.close();

	}
}
