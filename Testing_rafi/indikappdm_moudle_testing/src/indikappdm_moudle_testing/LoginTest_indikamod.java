package indikappdm_moudle_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_indikamod {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8069/web#action=291&model=indikamodule.websitestable&view_type=list&cids=1&menu_id=178");   
        //driver.manage().window().maximize();
        //driver.findElement(By.id("login")).sendKeys("mohammedrafi.shaik@leelaconsultancy.co.uk"); 
        //driver.findElement(By.id("password")).sendKeys("Furqaan$1314"); 
        //driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click();
        //		Thread.sleep(1000);
        //driver.getTitle();
	    //driver.close();
		
		
		
		
		//System.setProperty("webdriver.chrome.driver", "/Users/shaikfahemida/Downloads/chromedriver_mac64");   
		//WebDriver driver = new ChromeDriver(); 

		  //driver.get("http://www.google.com/");    

	}

}
 