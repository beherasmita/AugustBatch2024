package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helper.Utility;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By user_element = By.id("email1"); // can only access within class member 
	private By password_element = By.id("password1");
	private By login_button = By.className("submit-btn");
	//returns object of next page i.e.homepage
	public HomePage loginToApp(String uname,String pass) {
		//driver.findElement(user_element).sendKeys(uname);  instead use Utility class methods
		Utility.findElement(driver, user_element).sendKeys(uname);
		Utility.findElement(driver, password_element).sendKeys(pass);
		Utility.clickElement(driver, login_button);
		driver.findElement(password_element).sendKeys(pass);
		driver.findElement(login_button).click();
		//selenium way to create object using pagefactory
		//HomePage home= PageFactory.initElements(driver, HomePage.class); 
		//below is normal java way to create object
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		return home;
	}
	
}
