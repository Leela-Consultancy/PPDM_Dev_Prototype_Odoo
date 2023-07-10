package Pkg_Extent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class inputwebsitedata {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	
	@Test(dataProvider="inputwebsitedata")
	public void loginTest(String user,String pwd,String exp) throws InterruptedException
	{

		
	
		driver.get("http://localhost:8069/");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"top_menu\"]/li[3]/a")).click();
		
		  driver.findElement(By.id ("login")).sendKeys("mohammedrafi.shaik@gmail.com");
		
		
		
		driver.findElement(By.id ("password")).sendKeys("123456789");
		
		
		 driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click(); //Login  button
		 Thread.sleep(1000);
		
		String exp_title="Odoo - Discuss";
		String act_title=driver.getTitle();
		
		
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.xpath("/html/body/header/nav/div[2]/div[10]/button/span")).click();
				driver.findElement(By.xpath("/html/body/header/nav/div[2]/div[10]/div/a[3]")).click();
				
				Assert.assertTrue(true);
			}	//driver.close();
			
			
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/div/a[4]")).click();
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(null);
		driver.findElement(By.xpath("//*[@id=\"desc\"]")).sendKeys(null);
		driver.findElement(By.xpath("//*[@id=\"url\"]")).sendKeys(null);
		//*[@id="name"]
			
			
			
			
			
			
	}
	@DataProvider(name="inputwebsitedata")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								 {"mohammedrafi.shaik@gmail.com","123456789","Valid"},
//		             {"mohammed.shaik@gmail.com","1234567","Invalid"},
//		             {"mohammedrafi.shaik@gmail.com","1234567","Invalid"},
//		             {"mohammed.shaik@gmail.com","123456789","Invalid"}
							};*/
		
		//get the data from excel
		String path=".\\Datafiles\\inputwebsitedata.xlsx";
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
