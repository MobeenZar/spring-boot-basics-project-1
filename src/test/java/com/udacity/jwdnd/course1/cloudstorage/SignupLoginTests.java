package com.udacity.jwdnd.course1.cloudstorage;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignupLoginTests extends BaseTests{


	//Verifies that an unauthorized user can only access the login and signup pages.
	@Test
	public void testPageAccess() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());

		driver.get("http://localhost:" + this.port + "/signup");
		Assertions.assertEquals("Sign Up", driver.getTitle());

		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertNotEquals("Home", driver.getTitle());

		driver.get("http://localhost:" + this.port + "/badurl");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	/**
	 * Signs up a new user Test
	 * Logs in Test
	 * Verifies if a home page is accessible
	 * Logs out, and verifies that the home page is no longer accessible.
	 */
	@Test
	public void testUserSignupLogin() {
		Assertions.assertEquals("Home", signUpAndLogin());
		homePage.logout();
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void testUserLogout() {
		Assertions.assertEquals("Home", signUpAndLogin());

		homePage.logout();
		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
	}
}
