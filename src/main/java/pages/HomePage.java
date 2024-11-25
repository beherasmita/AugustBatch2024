package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By welcomeMsg = By.className("welcomeMessage"); // can only access within class member 
	private By manage = By.xpath("//span[normailse-space()='Manage']");
	private By manageCourses = By.xpath("//span[normailse-space()='Manage Courses']");
	private By manageCategory = By.xpath("//span[normailse-space()='Manage Categories']");
	
	
	public String getWelcomeMsg() {
		String welcomeMessage =driver.findElement(welcomeMsg).getText();
		return welcomeMessage;
		
	}
	public Courses clickOnManageCourse() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(manage)).perform();
		driver.findElement(manageCourses).click();
		Courses course = new Courses(driver);
		// object creation using pagefactory 
		//Courses course = PageFactory.initElements(driver, Courses.class);
		return course;
	}
  public Category clickOnManageCategory() {
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(manage)).perform();
	driver.findElement(manageCategory).click();
	
	// below is object creation using pagefactory 
	//Courses course = PageFactory.initElements(driver, Courses.class);
	return new Category(driver); //returning object of Category class
	//return PageFactory.initElements(driver, Courses.class);//using pagefactory
	}
	
}
