package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Element Library
	/*
	  WebElement WebElement_USERNAME_FIELD =driver.findElement(By.xpath("//*[@class='login']/descendant::input[@id='username']")); 
	 By USERNAME_FIELD_Locator = By.xpath("//*[@class='login']/descendant::input[@id='password']");
	 */
	@FindBy(how = How.XPATH, using = "//*[@class='login']/descendant::input[@id='username']")WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@class='login']/descendant::input[@id='password']")WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@class='login']/descendant::button[@name='login']")WebElement SIGNIN_BUTTON;

	// Methods to interact with the elements
	public void enterUserName(String userName) {
		USERNAME_FIELD.sendKeys(userName);
	}

	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}

	public void clickSignInButton() {
		SIGNIN_BUTTON.click();
	}

}
