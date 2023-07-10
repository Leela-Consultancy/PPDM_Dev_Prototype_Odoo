package Pkg_Extent;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginTestWithMultipleSetOfData {

	public static String capturescreenshot(ChromeDriver driver) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath = new File("src/../images-datadrivenlogin/screenshot"+System.currentTimeMillis()+".png");
		String absolutepathlocation = destinationfilepath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationfilepath);
		return absolutepathlocation;
		  
	  }
	

	@Test(dataProvider = "credentials")
	  public void tc_001(String scenario, String username, String password ) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		 ExtentReports extent1 = new ExtentReports();
		 ExtentSparkReporter spark1 = new ExtentSparkReporter("Extentreport1.html");
		 spark1.config().setTheme(Theme.DARK);
		 spark1.config().setDocumentTitle("Rafi_Reportdatadrivenlogin-v2");
		 extent1.attachReporter(spark1);
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  String baseUrl = "http://localhost:8069/";
	       driver.get(baseUrl);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  ExtentTest test1 = extent1.createTest("login with username and password ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  // Click on Signing
		  test1.info("logging into the page");
		  driver.findElement(By.xpath("//*[@id=\"top_menu\"]/li[3]/a")).click();
		  Thread.sleep(1000);
		  test1.addScreenCaptureFromPath(capturescreenshot(driver));
		  test1.info("Enter username and password");

		  Thread.sleep(1000);
    // Enter Email 
		  driver.findElement(By.id ("login")).sendKeys(username);
    //Enter password
		  driver.findElement(By.id ("password")).sendKeys(password);
    // Click on login
		  Thread.sleep(1000);
		  test1.addScreenCaptureFromPath(capturescreenshot(driver));
		  test1.info("clicking on login");
		  driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click();
		  Thread.sleep(1000);
		
		  if(scenario.equals("bothcorrect")){
			  WebElement dropdowntoggle = driver.findElement (By.className ("dropdown-toggle"));
			  Assert.assertTrue(dropdowntoggle.isDisplayed(), "Login not Sucess");
			  test1.addScreenCaptureFromPath(capturescreenshot(driver));
			  }
		  else  if (scenario.equals("bothwrong")) {
			  String errormessage = driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/p")).getText();
			  Assert.assertEquals(errormessage, "Wrong login/password");
			  test1.addScreenCaptureFromPath(capturescreenshot(driver));
			  }
		  else if (scenario.equals("correctusername")) {         
			  String errormessage = driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/p")).getText();
			  Assert.assertEquals(errormessage, "Wrong login/password");
			  test1.addScreenCaptureFromPath(capturescreenshot(driver));
			  }
		  else {
			  String errormessage = driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/p")).getText();
			  Assert.assertEquals(errormessage, "Wrong login/password");
			  test1.addScreenCaptureFromPath(capturescreenshot(driver));
		  }
		  driver.quit();
		

	 }
	  @DataProvider (name = "credentials")
	  public  Object [][] getdata(){
		  return new Object [][]{
		            {"bothcorrect","mohammedrafi.shaik@gmail.com","123456789"},
		             {"bothwrong","mohammed.shaik@gmail.com","1234567"},
		             {"correctusername","mohammedrafi.shaik@gmail.com","1234567"},
		             {"correctpassword","mohammed.shaik@gmail.com","123456789"}
		  };
		  }
}
