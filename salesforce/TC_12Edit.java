package com.feb04.salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_12Edit extends BaseTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Edit Name
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
		
		
		WebElement viewName = driver.findElement(By.id("fcf"));
		viewName.click();
		String expected = "Savi_s28";
		if(viewName.isDisplayed()) {
			String actual = viewName.getText();
			if(actual.equalsIgnoreCase(expected)) {
				System.out.println("Name displayed");	
			}
			else {
				System.out.println("Name not displayed");
			}
		}
		WebElement editName = driver.findElement(By.xpath("//a[normalize-space()='Edit']"));
		editName.click();
		Thread.sleep(3000);
		String editView = driver.getTitle();
		System.out.println("Accounts edit view Salesforce Page: "+editView);
		String expectedEditView = "Accounts: Edit View ~ Salesforce - Developer Edition";
		if (editView.equalsIgnoreCase(expectedEditView)) {
			System.out.println("Account edit view page displayed");
		} else {
			System.out.println("Account edit view page not displayed");
		}
		
		WebElement newName = driver.findElement(By.id("fname"));
		newName.click();
		newName.clear();
		newName.sendKeys("Savi_s26");
		Thread.sleep(3000);
		
		WebElement field = driver.findElement(By.id("fcol1"));
		field.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		WebElement operator = driver.findElement(By.id("fop1"));
		Select ob = new Select(operator);
		ob.selectByVisibleText("contains");
		
		WebElement value = driver.findElement(By.id("fval1"));
		value.click();
		value.clear();
		value.sendKeys("a");
		Thread.sleep(3000);
		
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
		
		String accHome = driver.getTitle();
		System.out.println("Accounts Salesforce Page: "+accHome);
		String expectedAccHome = "Accounts ~ Salesforce - Developer Edition";
		if (accHome.equalsIgnoreCase(expectedAccHome)) {
			System.out.println("Account home page displayed");
		} else {
			System.out.println("Account home page not displayed");
		}
		Thread.sleep(3000);
		driver.close();

	}
}
