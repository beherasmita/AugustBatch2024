package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import dataprovider.ConfigReader;
import factory.BrowserFactory;

public class BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void setupBrowser() {
		System.out.println("LOG:INFO - Setting up Browser");
		driver=BrowserFactory.getDriver(ConfigReader.getValue("browser"),ConfigReader.getValue("qaenv"));
		System.out.println("LOG:INFO - Application is up and running");
	}
	@AfterTest
	public void teardown() {
		System.out.println("LOG:INFO - closing browser");
		driver.quit();
		System.out.println("LOG:INFO - Application and browser closed");
	}
}
