package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_16NewOpportunities extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// New Opportunities
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
		WebElement oppoNew = driver.findElement(By.xpath("//input[@title='New']"));
		oppoNew.click();
		String oppoEdit = driver.getTitle();
		System.out.println("Opportunity Edit Salesforce Page: "+oppoEdit);
		String expectedOppoEdit = "Opportunity Edit: New Opportunity ~ Salesforce - Developer Edition";
		if (oppoEdit.equalsIgnoreCase(expectedOppoEdit)) {
			System.out.println("Opportunity Edit page displayed");
		} else {
			System.out.println("Opportunity Edit  page not displayed");
		}
		Thread.sleep(2000);
		WebElement oppoName = driver.findElement(By.xpath("//input[@id='opp3']"));
		oppoName.click();
		oppoName.sendKeys("Finance");

		WebElement accName = driver.findElement(By.xpath("//input[@id='opp4']"));
		accName.click();
		accName.sendKeys("Shreeya");

		WebElement closeDate = driver.findElement(By.xpath("//input[@id='opp9']"));
		closeDate.click();
		WebElement date = driver.findElement(By.xpath("//td[contains(text(),'14')]"));
		date.click();

		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		stage.click();
		Select st = new Select(stage);
		st.selectByVisibleText("Qualification");

		WebElement probability = driver.findElement(By.id("opp12"));
		probability.click();
		probability.clear();
		probability.sendKeys("30");

		WebElement leadSource = driver.findElement(By.xpath("//select[@id='opp6']"));
		leadSource.click();
		Select lead = new Select(leadSource);
		lead.selectByVisibleText("Web");
		/*
		 * WebElement campaign = driver.findElement(By.xpath("//input[@id='opp17']"));
		 * campaign.click(); campaign.sendKeys("Google Ad");
		 */
		WebElement save = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		save.click();

		String oppoSave = driver.getTitle();
		System.out.println("Opportunity Finance Salesforce Page: "+oppoSave);
		String expectedOppoSave = "Opportunity: Finance ~ Salesforce - Developer Edition";
		if (oppoSave.equalsIgnoreCase(expectedOppoSave)) {
			System.out.println("Opportunity Finance page displayed");
		} else {
			System.out.println("Opportunity Finance page not displayed");
		}
		driver.close();
	}
}
