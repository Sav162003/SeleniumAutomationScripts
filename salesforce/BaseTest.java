package com.feb04.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	static WebDriver  driver= null;
	
	public static void GetDriver(String browsername) {

		switch(browsername) {
		case "chrome" : WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		default:
		System.out.println("Not a valid browsername");
		}
	}
	public static void goToUrl(String url) {
		driver.get(url);

	}
	public static void loginFromBase() throws InterruptedException {
		
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
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);

		String actual = driver.getTitle();
		System.out.println("Home Page Title : "+actual);
		String expectedContact = "Home Page ~ Salesforce - Developer Edition";
		if (actual.equalsIgnoreCase(expectedContact)) {
			System.out.println("Home page displayed");
		} else 
		{
			System.out.println("Home page not displayed");
		}
	}
}
	

	