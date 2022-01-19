package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CredentialTests extends BaseTests{
	private String url = "A Url";
	private String userName = "John Doe";
	private String password = "johnPassword";

	@Test
	public void testAddCredential() {
		addCredential();
		homePage.goToCredentialsTab();
		Credential credential = homePage.getFirstCredential();
		Assertions.assertEquals(url, credential.getUrl());
		Assertions.assertEquals(userName, credential.getUserName());
		homePage.deleteCredential();
	}

	public void addCredential() {
		Assertions.assertEquals("Home", signUpAndLogin());
		homePage.goToCredentialsTab();
		homePage.enterCredential(url,userName, password);
		ResultPage resultPage = new ResultPage(driver);

		//Go back to home page
		resultPage.clickOk();
	}

	@Test
	public void testEditCredential() {
		String modUrl = "Modified Url";
		String modUserName = "Little Jonny";
		String modPassword = "modifiedPassword";
		addCredential();

		//Check if new Credential is inserted
		homePage.goToCredentialsTab();
		Credential credential = homePage.getFirstCredential();
		Assertions.assertEquals(url, credential.getUrl());
		Assertions.assertEquals(userName, credential.getUserName());

		homePage.editCredential(modUrl, modUserName, modPassword);
		ResultPage resultPage = new ResultPage(driver);

		//Go back to home page
		resultPage.clickOk();

		homePage.goToCredentialsTab();
		credential = homePage.getFirstCredential();
		Assertions.assertEquals(modUrl, credential.getUrl());
		Assertions.assertEquals(modUserName, credential.getUserName());
		homePage.deleteCredential();
	}

	@Test
	public void testDeleteNote() {
		addCredential();

		//Check if new credential is inserted
		homePage.goToCredentialsTab();
		Credential credential = homePage.getFirstCredential();
		Assertions.assertEquals(url, credential.getUrl());
		Assertions.assertEquals(userName, credential.getUserName());

		homePage.deleteCredential();
		ResultPage resultPage = new ResultPage(driver);

		//Go back to home page
		resultPage.clickOk();

		homePage.goToCredentialsTab();
		try{
			homePage.getFirstCredential();
			assertTrue(false);
		}catch (NoSuchElementException e){
			assertTrue(true);
		}
	}
}
