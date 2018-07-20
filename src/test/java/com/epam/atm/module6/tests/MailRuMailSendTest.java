package com.epam.atm.module6.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.atm.module6.screens.MailRuDraftPage;
import com.epam.atm.module6.screens.MailRuCreationPage;
import com.epam.atm.module6.screens.MailRuAccountPage;
import com.epam.atm.module6.screens.MailRuHomePage;
import com.epam.atm.module6.screens.MailRuIncomingPage;
import com.epam.atm.module6.screens.MailRuSentInfoPage;
import com.epam.atm.module6.screens.MailRuSentPage;

public class MailRuMailSendTest extends MailRuTestBase{
	@Test(description = "Mail sending", dependsOnGroups = {"test_1"}, groups={"test_2"})
	public void mailRuMailSendingTest() {
		MailRuHomePage homePage = new MailRuHomePage(driver);
		homePage.startBrowser();
		homePage.fillLoginFormFirstAccaunt();
		homePage.pressSubmit();
		
		MailRuAccountPage accountPage = new MailRuAccountPage(driver);
		accountPage.clickMailDraftMenuLink();
		
		MailRuDraftPage draftPage = new MailRuDraftPage(driver);
		String actualSubject = draftPage.getFirstDraftMailSubject();
		draftPage.openDraftMailBySubject(actualSubject);
		
		MailRuCreationPage mailCreationPage = new MailRuCreationPage(driver);
		mailCreationPage.pressMailSendBtn();
		
		MailRuSentInfoPage mailSentInfoPage = new MailRuSentInfoPage(driver);
		mailSentInfoPage.searchMailSentTitle();
		
		accountPage.clickMailDraftMenuLink();
		
		Assert.assertFalse(draftPage.isEmailNotPresentOnPage(actualSubject), "Email exists in Draft folder");
		
		accountPage.clickMailSentMenuLink();
		MailRuSentPage sentPage = new MailRuSentPage(driver);
		Assert.assertTrue(sentPage.isEmailPresentOnPage(actualSubject), "Email does not exist in SENT folder");
		
		accountPage.clickLogOut();
		
		homePage.fillLoginFormSecondAccaunt();
		homePage.pressSubmit();
		
		accountPage.clickMailIncomingMenuLink();
		MailRuIncomingPage incomingPage = new MailRuIncomingPage(driver);
		Assert.assertTrue(incomingPage.isEmailPresentOnPage(actualSubject));
		accountPage.clickLogOut();
		
	}

}
