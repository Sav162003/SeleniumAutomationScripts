package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_19CQuarterlySummary extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Quarterly summary Report - Next/All
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
			System.out.println("Opportunities Home page displayed");
		} else {
			System.out.println("Opportunities Home page not displayed");
		}

		WebElement noThanks = driver.findElement(By.id("lexNoThanks"));
		noThanks.click();
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000);
		
		WebElement intervalNext = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		intervalNext.click();
		Select ob=new Select(intervalNext);
		ob.selectByVisibleText("Next FQ");
		WebElement intervalAll = driver.findElement(By.xpath("//select[@id='open']"));
		intervalAll.click();
		Select open = new Select(intervalAll);
		open.selectByVisibleText("All Opportunities");
		WebElement runReport = driver.findElement(By.xpath("//input[@title='Run Report']"));
		runReport.click();
		String oppoRepPage = driver.getTitle();
		String expected = "Opportunity Report ~ Salesforce - Developer Edition";
		if(oppoRepPage.equalsIgnoreCase(expected)) {
			System.out.println("Opportunity Report page displayed");
		}
		else {
			System.out.println("Opportunity Report page not displayed");
		
		}
			driver.close();

	}
}
