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

import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


public class logindatadriven {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp) throws InterruptedException
	{

		
	
		driver.get("http://localhost:8069/");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"top_menu\"]/li[3]/a")).click();
		
		  driver.findElement(By.id ("login")).sendKeys(user);
		
		
		
		driver.findElement(By.id ("password")).sendKeys(pwd);
		
		
		 driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click(); //Login  button
		 Thread.sleep(1000);
		
		String exp_title="Odoo - Discuss";
		String act_title=driver.getTitle();
		
		if(exp.equals("Valid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.xpath("/html/body/header/nav/div[2]/div[10]/button/span")).click();
				driver.findElement(By.xpath("/html/body/header/nav/div[2]/div[10]/div/a[3]")).click();
				
				Assert.assertTrue(true);
				//driver.close();
			}
			else
			{
				Assert.assertTrue(false);
				//driver.close();
			} 
		}
		else if(exp.equals("Invalid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.xpath("/html/body/header/nav/div[2]/div[10]/button/span")).click();
				driver.findElement(By.xpath("/html/body/header/nav/div[2]/div[10]/div/a[3]")).click();
				Assert.assertTrue(false);
				//driver.close();
			}
			else
			{
				Assert.assertTrue(true);
				//driver.close();
			}
		}
		//driver.quit();
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								 {"mohammedrafi.shaik@gmail.com","123456789","Valid"},
//		             {"mohammed.shaik@gmail.com","1234567","Invalid"},
//		             {"mohammedrafi.shaik@gmail.com","1234567","Invalid"},
//		             {"mohammed.shaik@gmail.com","123456789","Invalid"}
							};*/
		
		//get the data from excel
		String path=".\\Datafiles\\loginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return loginData;
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
}