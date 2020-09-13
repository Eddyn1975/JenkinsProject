package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class addNewAccountPage {
	WebDriver driver;
	
	//static String accountTitleName;
	public addNewAccountPage(WebDriver driver) {
		this.driver = driver;

	}

	// Element Library
	/*
	  WebElement WebElement_USERNAME_FIELD =driver.findElement(By.xpath("//*[@class='login']/descendant::input[@id='username']")); 
	 By USERNAME_FIELD_Locator = By.xpath("//*[@class='login']/descendant::input[@id='password']");
	 */
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']//descendant::span[text()='Bank & Cash']")WebElement BANK_CASH_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']//descendant::a[text()='New Account']")WebElement NEW_ACCOUNT_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='account']")WebElement ACCOUNT_TITLE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='description']")WebElement DESCRIPTION_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='balance']")WebElement INITIAL_BALANCE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='account_number']")WebElement ACCOUNT_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='contact_person']")WebElement CONTACT_PERSON_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='contact_phone']")WebElement PHONE_FIELD ;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::input[@id='ib_url']")WebElement INTERNET_BANKING_URL_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']//descendant::button[contains(text(),' Submit')]")WebElement SUBMIT_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id='wrapper']//descendant::div[@class='alert alert-success fade in']")WebElement ACCOUNT_CREATED_SUCCESSFULLY_TITLE;
	@FindBy(how = How.XPATH, using = "//*[@class='modal-footer']//following::button[text()='OK']")WebElement OK_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id='wrapper']//descendant::div[@class='alert alert-success fade in']")WebElement ACCOUNT_DELETED_TITLE;
	
	

	// Methods to interact with the elements
	public void clickBankCashButton() throws InterruptedException {
		BANK_CASH_BUTTON.click();
		BasePage.waitForImplicitWait();
	}
	public void clickNewAccountButton() throws InterruptedException {
		NEW_ACCOUNT_BUTTON.click();
		BasePage.waitForImplicitWait();
	}
	String accountTitleName;
	public void enterAccountTitleName(String accountName) throws InterruptedException {
		accountTitleName = accountName +""+ BasePage.randomNumGenerator();
		ACCOUNT_TITLE_FIELD.sendKeys(accountTitleName);
		BasePage.waitForImplicitWait();
	}
	
	public void enterDescriptionName(String descriptionName) throws InterruptedException {
		DESCRIPTION_FIELD.sendKeys(descriptionName);
		BasePage.waitForImplicitWait();
	}
	String initialBalanceAmount;
	public void enterInitialBalanceAmount(String initialBalance) throws InterruptedException {
		initialBalanceAmount = initialBalance +""+ BasePage.randomNumGenerator();
		INITIAL_BALANCE_FIELD.sendKeys(initialBalanceAmount);
		BasePage.waitForImplicitWait();
	}
	public void enterAccountNumber(String accountNumber) throws InterruptedException {
		ACCOUNT_NUMBER_FIELD.sendKeys(accountNumber);
		BasePage.waitForImplicitWait();
	}
	public void enterContactPersonName(String contactPersonName) throws InterruptedException {
		CONTACT_PERSON_FIELD.sendKeys(contactPersonName);
		BasePage.waitForImplicitWait();
	}
	public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
		PHONE_FIELD.sendKeys(phoneNumber);
		BasePage.waitForImplicitWait();
	}
	public void enterInternetBankingUrl(String internetUrl) throws InterruptedException {
		INTERNET_BANKING_URL_FIELD.sendKeys(internetUrl);
		BasePage.waitForImplicitWait();
	}
	public void clickSubmitButton() throws InterruptedException {
		SUBMIT_BUTTON.click();
		BasePage.waitForImplicitWait();
	}
	
	String message;
	public  void AccountCreatedSuccessfully() {
		message = ACCOUNT_CREATED_SUCCESSFULLY_TITLE.getText();
		System.out.println(message);
		
	}
	public void ScrollDown() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,8000)");

	}
	
	public void ValidateNewAccountShowedInTheBottonOfTheTable() throws InterruptedException {
		
		List<WebElement> accountElements = driver.findElements(By.xpath("//*[@class='ibox-content']//descendant::tr/td[1]"));
		BasePage.waitForImplicitWait();
		
		for(int i = 0; i < accountElements.size(); i++) {
			
			if(accountElements.get(i).getText().equalsIgnoreCase(accountTitleName)) {
				System.out.println("The account name exist");
			}
			
			else {
				
				System.out.println("The account name does not exist!!!''");	
		
			}
		}
		/*
		
		String LastAccountTitleName = accountElements.get(accountElements.size() - 1).getText();
		System.out.println("The last account title name is "+ ""+ LastAccountTitleName);
		Assert.assertEquals(LastAccountTitleName, accountTitleName, "Account title name  does not match!!!");
		if(LastAccountTitleName.contains(accountTitleName)) {
			System.out.println("The account name exist");
		}
			else {
				
			System.out.println("The account name does not exist!!!''");	
				
		}*/
	}
			
		
		
		//System.out.println("The expected account name is :"+" "+ accountTitleName );
		//System.out.println("The actual account name is :" + " " + accountElements.get(accountElements.size() - 1).getText());
	
	
	public void DeleteAccount() throws InterruptedException {
		List<WebElement> deleteElements = driver.findElements(By.xpath("//*[@class='table table-striped table-bordered']//descendant::tr/td/a[@id]"));
		BasePage.waitForImplicitWait();
		driver.findElements(By.xpath("//*[@class='table table-striped table-bordered']//descendant::tr/td/a[@id]")).get(deleteElements.size()-1).click();
		
	}
	
	public void confirmDeletion() throws InterruptedException {
		OK_BUTTON.click();
		BasePage.waitForImplicitWait();		
	}
	
	String accountDeleted;
	public void validateAccountDeletedFromTheBottomOfTheTable() {
		accountDeleted = ACCOUNT_DELETED_TITLE.getText();
		//System.out.println(driver.findElement(By.xpath("//*[@id='wrapper']//descendant::div[@class='alert alert-success fade in']")).getText());
		
		//ACCOUNT_DELETED_BUTTON.getText();
		System.out.println(accountDeleted);
		
	}
	
}
	

