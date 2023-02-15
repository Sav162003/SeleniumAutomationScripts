package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_09Logout extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// Logout
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		WebElement user = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		user.click();
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		Thread.sleep(2000);
		
		String salesLogout = driver.getTitle();
		System.out.println("Login Salesforce Page: "+salesLogout);
		String expectedLogout = "Login | Salesforce";
		if (salesLogout.equalsIgnoreCase(expectedLogout)) {
			System.out.println("Login page displayed after logout");
		} else {
			System.out.println("Login page not displayed after logout");
		}
		Thread.sleep(3000);
		driver.quit();	


	}
}
