package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	//Elements library
	
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']//descendant::span[text()='Dashboard']")WebElement DASHBOARD_BUTTON;
	
	// Methods to interact with the elements
	
		public void verifyDashBoardElement() {
			Assert.assertEquals(DASHBOARD_BUTTON.getText(), "Dashboard", "Wrong page!!!");
			BasePage.waitForElement(DASHBOARD_BUTTON, driver);
		}

}
