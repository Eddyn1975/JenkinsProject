package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;

	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.startBrowser();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName("demo@techfios.com");
		loginpage.enterPassword("abc123");
		loginpage.clickSignInButton();
		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		
	}

}
