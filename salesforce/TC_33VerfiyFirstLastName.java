package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_33VerfiyFirstLastName extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Verify First Last Name
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		Thread.sleep(3000);

		String actualLoginHome = driver.getTitle();
		System.out.println("Page Title :"+actualLoginHome);
		String contactHome =  "Home Page ~ Salesforce - Developer Edition";
		if(actualLoginHome.equalsIgnoreCase(contactHome))
		{
			System.out.println("Home Page launched"); 
		}
		else {
			System.out.println("Home Page not launched");
		}

		WebElement user = driver.findElement(By.xpath("//a[contains(text(),'Savitha M')]"));
		user.click();
		String userHome = driver.getTitle();
		System.out.println("Page Title :"+userHome);
		String profileHome =  "User: Savitha M ~ Salesforce - Developer Edition";
		if(userHome.equalsIgnoreCase(profileHome))
		{
			System.out.println("Home Page launched"); 
		}
		else {
			System.out.println("Home Page not launched");
		}

	 driver.close();

	}
}
