package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test(description="this test will verify valid login",dataProvider="login",dataProviderClass=CustomDataProvider.class)
 public void validLoginTest(String username,String password ) {
	LoginPage login=new LoginPage(driver);
	login.loginToApp(username, password);
	Assert.assertTrue(driver.findElement(By.className("welcomeMessage")).isDisplayed());
	
	
}
}
