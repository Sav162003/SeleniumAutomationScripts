package com.feb04.salesforce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_08DevConsole extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// Developer console

		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();

		WebElement user = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		user.click();
		Thread.sleep(3000);
		WebElement console = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		console.click();

		String devConsole = driver.getTitle();
		System.out.println("Developer Consoler Title : "+devConsole);
		String expectedConsole = "Home Page ~ Salesforce - Developer Edition";
		if (devConsole.equalsIgnoreCase(expectedConsole)) {
			System.out.println("Developer Console page displayed");
		} else {
			System.out.println("Developer Console page not displayed");
		}
		
		String mainWindow =driver.getWindowHandle();
		Set<String>allWindowHandle=driver.getWindowHandles();
		for(String handle:allWindowHandle) {
			if(!mainWindow.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		driver.close();

	}
}
