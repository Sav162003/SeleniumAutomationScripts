package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_04AForgotPwd extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// Forgot password
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
			username.sendKeys("sav162023@gmail.com");
		}
		else {
			System.out.println("Element not displayed");
		}
		WebElement forgotpwd = driver.findElement(By.id("forgot_password_link"));
		forgotpwd.click();
		
		String forgotLink = driver.getTitle();
		System.out.println("Forgot password Page: "+forgotLink);
		String expectedforgotLink = "Forgot Your Password | Salesforce";
		if (forgotLink.equalsIgnoreCase(expectedforgotLink)) {
			System.out.println("Forgot Your Passord page displayed");
		} else {
			System.out.println("Forgot Your Passord not displayed");
		}

		WebElement forgotuser = driver.findElement(By.id("un"));
		if(forgotuser.isDisplayed()) {
			forgotuser.sendKeys("savi162023@gmail.com");	
			System.out.println("Forgotuser element displayed");
		}
		else {
			System.out.println("Forgotuser element not displayed");
		}

		Thread.sleep(6000);
		driver.findElement(By.id("continue")).click();
		
		String checkEmail = driver.getTitle();
		System.out.println("Check Email: "+checkEmail);
		String expectedcheck  = "Check Your Email | Salesforce";
		if (checkEmail .equalsIgnoreCase(expectedcheck)) {
			System.out.println("Check Email page displayed");
		} else {
			System.out.println("Check Email page not displayed");
		}

		driver.close();
	}

}
