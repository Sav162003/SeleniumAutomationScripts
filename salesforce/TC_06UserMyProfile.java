package com.feb04.salesforce;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_06UserMyProfile extends BaseTest{

	public static void main(String[] args) throws InterruptedException, AWTException {
		// My Profile
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();


		WebElement userName = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		userName.click();
		Thread.sleep(3000);

		WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		myprofile.click();
		String userAcc= driver.getTitle();
		System.out.println("Accounts User Salesforce Page: "+userAcc );
		String expectedUserAcc  = "User: Savitha M ~ Salesforce - Developer Edition";
		if (userAcc.equalsIgnoreCase(expectedUserAcc)) {
			System.out.println("Account user home page displayed");
		} else {
			System.out.println("Account user home page not displayed");
		}
		Thread.sleep(3000);

		WebElement editprofile = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		if(editprofile.isDisplayed()) {
			editprofile.click();
			System.out.println("Edit profile is displayed");
		}
		else {
			System.out.println("Edit profile is not displayed");
		}
		Thread.sleep(4000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		driver.switchTo().frame(iframe);

		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		about.click();


		WebElement lastname = driver.findElement(By.id("lastName"));
		lastname.click();
		lastname.clear();
		String lnameupdated = "M";
		lastname.sendKeys(lnameupdated);
		System.out.println("The last name is updated");
		WebElement saveall = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		saveall.click();

		WebElement post = driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
		post.click();
		Thread.sleep(3000);

		//iframe[@title='Rich Text Editor, publisherRichTextEditor']
		WebElement postFrame = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		driver.switchTo().frame(postFrame);
		Thread.sleep(3000);

		WebElement postText = driver.findElement(By.xpath("/html[1]/body[1]"));
		postText.click();
		postText.sendKeys("Hello, Selenium Salesforce Automation");
		System.out.println("Message posted");

		driver.switchTo().parentFrame();

		Thread.sleep(3000);
		WebElement shareButton = driver.findElement(By.id("publishersharebutton"));
		shareButton.click();
		Thread.sleep(3000);


		WebElement file =  driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		file.click(); Thread.sleep(4000);

		//a[@id='chatterUploadFileAction']
		WebElement uploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		uploadFile.click(); 
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		chooseFile.sendKeys("C:\\Users\\savi1\\OneDrive\\Desktop\\file.txt");

		WebElement shareFile = driver.findElement(By.id("publishersharebutton"));
		shareFile.click();
		Thread.sleep(3000);

		WebElement modimage = driver.findElement(By.id("displayBadge"));
		Thread.sleep(3000);
		modimage.click();
		Thread.sleep(3000);

		WebElement photoFrame = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(photoFrame);
		Thread.sleep(3000);

		WebElement photo = driver.findElement(By.xpath("//input[@id=\"j_id0:uploadFileForm:uploadInputFile\"]"));
		photo.sendKeys("C:\\Users\\savi1\\OneDrive\\Desktop\\chipn.png");
		System.out.println("Upload photo opened");
		Thread.sleep(3000);

		WebElement savePhoto = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		savePhoto.click();
		System.out.println("Profile pic uploaded");
		Thread.sleep(3000);
		//*[@id="j_id0:j_id7:save"]
		WebElement save = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id7:save\"]"));
		save.click();
		driver.close();


	}

}
