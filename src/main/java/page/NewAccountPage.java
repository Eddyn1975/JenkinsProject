package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class NewAccountPage {
	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	//Elements library
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::h2[text()=' Accounts ']")
	WebElement ACCOUNTS_TITLE;
	
	// Methods to interact with the elements
		public void verifyAccountsTitlePage() {
			Assert.assertEquals(ACCOUNTS_TITLE.getText(), "Accounts", "Wrong page!!!");
			BasePage.waitForElement(ACCOUNTS_TITLE, driver);
		}


}
