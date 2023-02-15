package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_01ErrorPwd extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// Error Password 
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");

		String salesLogin = driver.getTitle();
		System.out.println("Login Salesforce Page: "+salesLogin); String
		expectedLogin = "Login | Salesforce"; 
		if(salesLogin.equalsIgnoreCase(expectedLogin)){
			System.out.println("Login page displayed"); 
		} else 
		{
			System.out.println("Login page not displayed"); 
		} 
		Thread.sleep(3000);

		WebElement username = driver.findElement(By.id("username"));
		if(username.isDisplayed()) { 
			username.clear();
			username.sendKeys("sav162023@gmail.com");
			System.out.println("Element username Displayed");
		} else 
		{
			System.out.println("Element username not displayed"); 
		}

		WebElement pwd = driver.findElement(By.id("password")); 
		if(pwd.isDisplayed()){ 
			pwd.clear(); pwd.sendKeys("");
			System.out.println("Element password Displayed"); 
		} else 
		{
			System.out.println("Element password not displayed"); 
		}
		driver.findElement(By.id("Login")).click();

		driver.quit();

	}

}
