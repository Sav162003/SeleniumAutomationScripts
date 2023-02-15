package com.feb04.salesforce;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_32SaveNewContactButton extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Save New Contact Button
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

		WebElement newAcc = driver.findElement(By.xpath("//input[@title='New']"));
		newAcc.click();

		String ContactEditHome = driver.getTitle();
		System.out.println("Page Title :"+ContactEditHome); 
		String expectedcontactEdit = "Contacts: Create New View ~ Salesforce - Developer Edition";
		if(ContactEditHome.equalsIgnoreCase(expectedcontactEdit))
		{
			System.out.println("Contact New Edit Page launched"); 
		} 
		else {
			System.out.println("Create New Edit Page launched"); 
		}
		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		lastName.click();
		lastName.sendKeys("Indian");
		
		WebElement nameLookUp = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		nameLookUp.click();
		
		String mainWindow =driver.getWindowHandle();
		Set<String>allWindowHandle=driver.getWindowHandles();
		for(String handle:allWindowHandle) {
			if(!mainWindow.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		WebElement frame = driver.findElement(By.xpath("//frame[@id='searchFrame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		WebElement newName = driver.findElement(By.xpath("//input[@title='New']"));
		newName.click();
		Thread.sleep(3000);
		
		WebElement resultsFrame = driver.findElement(By.xpath("//frame[@id='resultsFrame']"));
		driver.switchTo().frame(resultsFrame);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
				
		 WebElement accName = driver.findElement(By.xpath("//div[@class='requiredInput']|//input[@id='2']")); accName.click();
		 accName.sendKeys("Global Media");
		 
		 WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']|//input[@title='Save']")); 
		 save.click();
		  
		 
		 Thread.sleep(3000); 
		 driver.close();

	}
}
