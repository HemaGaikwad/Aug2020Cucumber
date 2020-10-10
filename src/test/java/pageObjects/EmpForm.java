package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmpForm 
{
	
	WebDriver driver=null;
	public EmpForm(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(name="firstname")
	public WebElement txtFirstName;
	
	@FindBy(name="lastname")
	public WebElement txtLastName;
	@FindBy(id="sex-0")
	public WebElement rdGenderMale;
	@FindBy(id="submitAAA")
	public WebElement btnSubmit;
	@FindBy(id="tool-2")
	public WebElement chkSeleniumWebDriver;

}
