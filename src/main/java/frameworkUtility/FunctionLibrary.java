package frameworkUtility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class FunctionLibrary
{
public static WebDriver driver;
/*Method to Kick off the browser defined in Property file*/
public static void startBrowser() throws IOException
{
FileUtilLibrary obj = new FileUtilLibrary();
/*Read the browser name from property file*/
String strBrowser = obj.readProperty("Browser");
if(strBrowser.equals("Chrome"))
{
/*Pass the driver path*/

System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\Drivers\\chromedriver.exe");
/*ChromeOptions opts = new ChromeOptions();
opts.setExperimentalOption("useAutomationExtension", false);*/
driver = new ChromeDriver();
}if(strBrowser.equals("Firefox"))
{
System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\Drivers\\geckodriver.exe");
driver = new FirefoxDriver();
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
}
/*Method to kill the browser session*/
public static void endBrowser()
{
driver.quit();
}
/*Method to launch the application*/
public static void launchAppURL(String strURL)
{
	driver.get(strURL);
}
/*public static void launchAppURL()
{
	FileUtilLibrary obj = new FileUtilLibrary();
	driver.get(obj.readProperty("ApplicationUrl"));
}*/
/*Method to refresh the browser */
public static void refreshBrowser()
{
	driver.navigate().refresh();
}
public static void clickElement(WebElement ele)
{
	ele.click();
}
public static void selectCheckBox(WebElement ele)
{
	if(!ele.isSelected())
	ele.click();
}
public static void deselectCheckBox(WebElement ele)
{
	if(ele.isSelected())
	ele.click();
}
public static void selectOptionByIndex(WebElement ele, int Ind)
{
	Select sel = new Select(ele);
	sel.selectByIndex(Ind);
}
public static void selectOptionByValue(WebElement ele, String strValue)
{
	Select sel = new Select(ele);
	sel.selectByValue(strValue);
}
public static void selectOptionByVisibleText(WebElement ele, String strText)
{
	Select sel = new Select(ele);
	sel.selectByVisibleText(strText);
}
public static void enterText(WebElement ele, String strValue)
{
	ele.sendKeys(strValue);
}
/*Method to count the element with tag name a*/
public static int getCount()
{
	int count = driver.findElements(By.tagName("a")).size();
	return count;
}
/*Method to capture the screen shot*/
public static void captureScreenshot(String strScenarioName) throws IOException
{
	TakesScreenshot src = (TakesScreenshot) driver;
	File imgFile = src.getScreenshotAs(OutputType.FILE);
	File trgFile = new File("src/test/resources/ScreenShots/"+strScenarioName+".png");
	FileUtils.copyFile(imgFile, trgFile);
}
}