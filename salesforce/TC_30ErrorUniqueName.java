package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_30ErrorUniqueName extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Error Unique Name
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
		WebElement viewUnique = driver.findElement(By.xpath("//input[@id='devname']"));
		viewUnique.click();
		viewUnique.sendKeys("EFGH");
		WebElement save = driver.findElement(By.xpath("(//input[@title='Save'])[1]"));
		save.click();

		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='requiredInput']//div[@class='errorMsg']"));
		System.out.println("Error Message : "+errorMsg.getText());

		driver.close();

	}
}
