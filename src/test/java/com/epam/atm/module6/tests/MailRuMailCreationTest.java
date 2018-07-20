package com.epam.atm.module6.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.atm.module6.screens.MailRuDraftPage;
import com.epam.atm.module6.screens.MailRuCreationPage;
import com.epam.atm.module6.screens.MailRuAccountPage;
import com.epam.atm.module6.screens.MailRuHomePage;

public class MailRuMailCreationTest extends MailRuTestBase {
	private static final String EXPECTED_ACCOUNT_ICON = "vra_atmmodule5@mail.ru"; 

	
	@Test(description = "Login to mail.ru", groups={"test_1"})
	public void mailRuLoginTest() {
		MailRuHomePage homePage = new MailRuHomePage(driver);
		homePage.startBrowser();
		homePage.fillLoginFormFirstAccaunt();
		MailRuAccountPage accountPage = homePage.pressSubmit();
	
		String actualAutIcon = accountPage.getAutIcon();
		Assert.assertEquals(actualAutIcon,EXPECTED_ACCOUNT_ICON);
	}
	
	@Test(description = "Mail creation", dependsOnMethods = { "mailRuLoginTest" }, groups={"test_1"})
	public void mailRuMailCreationTest(){
		MailRuAccountPage accountPage = new MailRuAccountPage(driver);
		MailRuCreationPage mailCreationPage = accountPage.pressMailCreationBtn();
		mailCreationPage.fillEMail();
		mailCreationPage.pressSaveDraftBtn();
		accountPage.clickMailDraftMenuLink();
		MailRuDraftPage draftPage = new MailRuDraftPage(driver);		
		String actualSubject = draftPage.getFirstDraftMailSubject();
		Assert.assertEquals(actualSubject,MailRuCreationPage.SUBJECT);
		
		draftPage.openFirstDraftMail();
		String actualMailToAddress =  mailCreationPage.getActualMailToAddress();
		Assert.assertEquals(actualMailToAddress,MailRuCreationPage.MAIL_TO_ADDRESS + ",");
		
		Assert.assertTrue(mailCreationPage.isMailBodyEnable(),"Required text body has not been found");
		
		accountPage.clickLogOut();
	}
	
	


}
