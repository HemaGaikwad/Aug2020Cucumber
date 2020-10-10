package stepDefinations;

import java.util.List;
/* Import the Function Library Class which defined in Framework Utils */
import frameworkUtility.FunctionLibrary;
/* Import the Page Object Class which defined for objects of a page*/
import pageObjects.EmpForm;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateEmployeeDetails extends FunctionLibrary
{
@Given("^Application should be launched on browser$")
public void application_should_be_launched_on_browser()
{
//Launch the Application URL
	FunctionLibrary.launchAppURL("ApplicationUrl");
}
@Given("^Application should be up and running$")
public void application_should_be_up_and_running()
{
 // Write code here that turns the phrase above into concrete actions
	FunctionLibrary.launchAppURL("https://demoqa.com/automation-practice-form/");
}
/* Enter Employe details – No data passed from feature file. */
@When("^Enter Employee Details$")
public void enter_Employee_Details()
{
 // Write code here that turns the phrase above into concrete actions
//Create opbject for Employee Form page object class
	EmpForm empFormObj = new EmpForm(driver);
	
	//Enter the person first name
	enterText(empFormObj.txtFirstName, "David");
	//Enter the person first name
	enterText(empFormObj.txtLastName, "John");
	//Select person gender
	clickElement(empFormObj.rdGenderMale);
	//Select Automation tool
	selectCheckBox(empFormObj.chkSeleniumWebDriver);
}
@Then("^Click on Submit$")
public void click_on_Submit()
{
 // Write code here that turns the phrase above into concrete actions
//Create opbject for Employee Form page object class
EmpForm empFormObj = new EmpForm(driver);
//Click on submit button
clickElement(empFormObj.btnSubmit);

}
@When("^Enter Employee Details as First Name \"([^\"]*)\" and Last Name \"([^\"]*)\"$")
public void enter_Employee_Details(String strFirstName, String strLastName) throws InterruptedException
{
// Write code here that turns the phrase above into concrete actions
//Create opbject for Employee Form page object class
EmpForm empFormObj = new EmpForm(driver);
//Enter the person first name
enterText(empFormObj.txtFirstName, strFirstName);
Thread.sleep(3000);
//Enter the person first name
enterText(empFormObj.txtLastName, strLastName);
Thread.sleep(3000);
//Select person gender
clickElement(empFormObj.rdGenderMale);
//Select Automation tool
selectCheckBox(empFormObj.chkSeleniumWebDriver);
}
/*
*/
}