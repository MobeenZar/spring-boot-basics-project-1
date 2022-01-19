package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseTests {

	@LocalServerPort
	public int port;
	public static WebDriver driver;
	public String baseURL;

	public SignupPage signupPage;
	public LoginPage loginPage;
	public HomePage homePage;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach() {
		driver.get("http://localhost:" + port + "/signup");

		signupPage = new SignupPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	//@Test
	public String signUpAndLogin() {
		String username = "jdoe";
		String password = "abadpassword";

		driver.get("http://localhost:" + this.port + "/signup");
		Assertions.assertEquals("Sign Up", driver.getTitle());

		signupPage.signup("John", "doe", username, password);
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());

		loginPage.login(username, password);

		driver.get("http://localhost:" + this.port + "/home");
		return driver.getTitle();
	}

}
