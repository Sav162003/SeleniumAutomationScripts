package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_31CreateViewCancel extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Create View Cancel
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		Thread.sleep(3000);

		WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contacts']"));
		contact.click();
		Thread.sleep(3000);
		WebElement noThanks = driver.findElement(By.id("lexNoThanks"));
		noThanks.click(); 
		WebElement close =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		close.click();
		Thread.sleep(3000); //img[@title='Contact']

		String contactTab = driver.getTitle();
		System.out.println("Contacts home Page: "+contactTab);
		String expectedTab = "Contacts: Home ~ Salesforce - Developer Edition";
		if (contactTab.equalsIgnoreCase(expectedTab)) {
			System.out.println("Contacts Home page displayed");
		} else {
			System.out.println("Contacts Home page not displayed");
		}

		WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNewView.click();

		String actualCreateNewViewHome = driver.getTitle();
		System.out.println("Page Title :"+actualCreateNewViewHome); 
		String createHome = "Contacts: Create New View ~ Salesforce - Developer Edition";
		if(actualCreateNewViewHome.equalsIgnoreCase(createHome))
		{
			System.out.println("Create New View Page launched"); 
		} 
		else {
			System.out.println("Create New View Page launched"); 
		}
		WebElement viewName = driver.findElement(By.id("fname"));
		viewName.click();
		viewName.sendKeys("ABCD");
		WebElement viewUnique = driver.findElement(By.xpath("//input[@id='devname']"));
		viewUnique.click();
		viewUnique.clear();
		viewUnique.sendKeys("EFGH");
		Thread.sleep(3000);
		
		System.out.println("View name: " +viewName.getText());
		System.out.println("View Unique name : " +viewUnique.getText());
		
		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
		cancel.click();
		
		String contactCancel = driver.getTitle();
		System.out.println("Contacts home Page: "+contactCancel);
		String expectedCancel = "Contacts: Home ~ Salesforce - Developer Edition";
		if (contactCancel.equalsIgnoreCase(expectedCancel)) {
			System.out.println("Contacts Home page displayed after cancel");
		} else {
			System.out.println("Contacts Home page not displayed after cancel");
		}

		//*[@id="editPage"]/div[1]/table/tbody/tr/td[2]/input[2]
		// driver.close();

	}
}
