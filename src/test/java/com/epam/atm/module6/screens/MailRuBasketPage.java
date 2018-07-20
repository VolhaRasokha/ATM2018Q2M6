package com.epam.atm.module6.screens;

import org.openqa.selenium.WebDriver;

public class MailRuBasketPage extends AbstractPage {

	public MailRuBasketPage(WebDriver driver) {
		super(driver);
	}

@Override
public void poGo(){
		new MailRuBasketPage(driver);
	}
}
