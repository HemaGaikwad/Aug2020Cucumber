package scriptRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import frameworkUtility.FunctionLibrary;
import stepDefinations.CreateEmployeeDetails;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/",
glue = {"stepDefinations"},
/* It will use for generate the cucumber html report */
plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json"},
tags = {"@smoke"}
)
public class TestRunner {
@BeforeClass
public static void initialize() throws Exception 
{
	FunctionLibrary.startBrowser();
}
@AfterClass
public static void tearDown() throws Exception 
{
	
}


@Test
public void test()
{
	CreateEmployeeDetails cd = new CreateEmployeeDetails();
	cd.application_should_be_launched_on_browser();
	cd.application_should_be_up_and_running();
	cd.enter_Employee_Details();
	cd.click_on_Submit();
}
}