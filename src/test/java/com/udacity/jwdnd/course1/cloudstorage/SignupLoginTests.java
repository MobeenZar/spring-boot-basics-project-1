package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignupLoginTests extends BaseTests{

//	@LocalServerPort
//	public int port;
//	public static WebDriver driver;
//	public String baseURL;
//
//
//	private SignupPage signupPage;
//	private LoginPage loginPage;
//	private HomePage homePage;
//
//	@BeforeAll
//	public static void beforeAll() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//
//	@AfterAll
//	public static void afterAll() {
//		driver.quit();
//		driver = null;
//	}
//
//	@BeforeEach
//	public void beforeEach() {
//		//baseURL = "http://localhost:" + port;
//		driver.get("http://localhost:" + port + "/signup");
//
//		signupPage = new SignupPage(driver);
//		loginPage = new LoginPage(driver);
//		homePage = new HomePage(driver);
//	}

	/**
	 * Write a test that verifies that an unauthorized user can only access the login and signup pages.
	 */
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
	 * Write a test that signs up a new user, logs in, verifies that the home page is accessible, logs out, and verifies
	 * that the home page is no longer accessible.
	 */
	@Test
	public void testUserSignupLogin() {
//		String username = "pzastoup";
//		String password = "whatabadpassword";
//
//		driver.get("http://localhost:" + this.port + "/signup");
//		Assertions.assertEquals("Sign Up", driver.getTitle());
//
//		signupPage.signup("Peter", "Zastoupil", username, password);
//		driver.get("http://localhost:" + this.port + "/login");
//		Assertions.assertEquals("Login", driver.getTitle());
//
//		loginPage.login(username, password);
//
//		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertEquals("Home", signUpAndLogin());
		homePage.logout();
		//Assertions.assertEquals("Home", driver.getTitle());
	}

	@Test
	public void testUserLogout() {
//		String username = "pzastoup";
//		String password = "whatabadpassword";
//
//		signupPage.signup("Peter", "Zastoupil", username, password);
//
//		driver.get("http://localhost:" + this.port + "/login");
//		//Assertions.assertEquals("Login", driver.getTitle());
//		loginPage.login(username, password);
//
//		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertEquals("Home", signUpAndLogin());

		homePage.logout();
		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
	}
}
