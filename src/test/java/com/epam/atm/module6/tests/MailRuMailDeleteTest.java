package com.epam.atm.module6.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.atm.module6.screens.MailRuAccountPage;
import com.epam.atm.module6.screens.MailRuBasketPage;
import com.epam.atm.module6.screens.MailRuHomePage;
import com.epam.atm.module6.screens.MailRuIncomingPage;


public class MailRuMailDeleteTest extends MailRuTestBase {
	@Test(description = "Mail delete",dependsOnGroups = {"test_2"}, groups={"test_3"})
	public void mailRuMailDeleteTest() {
		
		MailRuHomePage homePage = new MailRuHomePage(driver);
		homePage.startBrowser();
		homePage.fillLoginFormSecondAccaunt();
		
		MailRuAccountPage accountPage = homePage.pressSubmit();
				
		accountPage.clickMailIncomingMenuLink();
		MailRuIncomingPage incomingPage = new MailRuIncomingPage(driver);		
		String subjectDeleteIncomingMail = incomingPage.getIncomingMailSubject();
		
		incomingPage.deleteIncomingMail();
		
	    Assert.assertFalse(incomingPage.isEmailNotPresentOnPage(subjectDeleteIncomingMail));
	    
	    accountPage.clickBasketMenuLink();
	    
	    MailRuBasketPage basketPage = new MailRuBasketPage(driver);
	    
	    Assert.assertTrue(basketPage.isEmailPresentOnPage(subjectDeleteIncomingMail));

		accountPage.clickLogOut();
		
	}


}
