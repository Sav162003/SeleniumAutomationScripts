package com.feb04.salesforce;


public class TC_02Launch extends BaseTest{

	public static void main(String[] args)  throws InterruptedException {
		// Launch the app
		GetDriver("chrome");
		goToUrl("https://login.salesforce.com/");
		Thread.sleep(3000);
		loginFromBase();
		
			driver.close();
	}


}
