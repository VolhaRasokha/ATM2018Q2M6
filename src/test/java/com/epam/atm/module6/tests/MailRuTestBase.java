package com.epam.atm.module6.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MailRuTestBase {
	protected WebDriver driver;
	
	@BeforeClass(description = "Start browser")
	public void initBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\_webdriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}

}
