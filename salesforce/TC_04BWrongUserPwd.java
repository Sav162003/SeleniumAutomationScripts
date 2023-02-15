package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TC_04BWrongUserPwd extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// Wrong User Password
	
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		

		String salesLogin = driver.getTitle();
		System.out.println("Login Salesforce Page: "+salesLogin);
		String expectedLogin = "Login | Salesforce";
		if (salesLogin.equalsIgnoreCase(expectedLogin)) {
			System.out.println("Login page displayed");
		} else {
			System.out.println("Login page not displayed");
		}
		
		WebElement username = driver.findElement(By.id("username"));
		if(username.isDisplayed()) {
			username.clear();
			username.sendKeys("123");
		}
		else {
			System.out.println("Wrong user name");
		}
		
		WebElement pwd = driver.findElement(By.id("password"));
		if(pwd.isDisplayed()) {
			pwd.clear();
			pwd.sendKeys("22131");
		}
		else {
			System.out.println("Element password not correct");
		}
		driver.findElement(By.id("Login")).click();
		
	}


}
