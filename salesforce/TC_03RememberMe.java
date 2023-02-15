package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_03RememberMe extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// Remember me
		
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
			System.out.println("Element username Displayed");
		}
		else {
			System.out.println("Element username not displayed");
		}
		
		WebElement pwd = driver.findElement(By.id("password"));
		if(pwd.isDisplayed()) {
			pwd.clear();
			pwd.sendKeys("Cheese2003&");
			System.out.println("Element password Displayed");
		}
		else {
			System.out.println("Element password not displayed");
		}
		
		WebElement checkbox = driver.findElement(By.id("rememberUn"));
		if(checkbox.isDisplayed()) {
		checkbox.click();
		System.out.println("Checkbox visible");
		}
		else {
			System.out.println("The checkbox is not visible");
		}
	
		Thread.sleep(3000);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		WebElement user = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		user.click();
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		logout.click();
		Thread.sleep(3000);

		driver.close();
	}

}
