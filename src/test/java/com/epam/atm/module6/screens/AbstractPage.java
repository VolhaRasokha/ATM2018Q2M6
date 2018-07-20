package com.epam.atm.module6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	protected WebDriver driver;
	private static final int WAIT_FOR_ELEMENT_SECONDS = 15;

	public AbstractPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	protected void waitForElementVisible(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
				.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(locator));
	}

	protected void waitForElementPresent(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
				.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(locator));
	}

	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isEmailPresentOnPage(String by_subject) {
		waitForElementVisible(By.xpath("//*[text()='" + by_subject + "']"));
		return isElementPresent(By.xpath("//*[text()='" + by_subject + "']"));
	}

	public boolean isEmailNotPresentOnPage(String by_subject) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[text()='"
						+ by_subject + "']")));
		return isElementPresent(By.xpath("//*[text()='" + by_subject + "']"));
	}
	
	public void poGo(){
		
	}

}
