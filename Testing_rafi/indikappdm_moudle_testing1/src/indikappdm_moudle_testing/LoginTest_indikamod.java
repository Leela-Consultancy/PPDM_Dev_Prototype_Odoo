package indikappdm_moudle_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_indikamod {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
        //driver.get("http://localhost:8069/web/login");   
	    //driver.manage().window().maximize();
        //driver.findElement(By.xpath("/html/body/header/nav/div[1]/button")).click();
     	//driver.findElement(By.xpath("/html/body/header/nav/div[1]/div/a[2]")).click();
     	
     	driver.get("http://localhost:8069/web#action=238&model=indikamodule.websitestable&view_type=list&cids=1&menu_id=155");
     	driver.findElement(By.id("login")).sendKeys("admin"); 
        driver.findElement(By.id("password")).sendKeys("admin"); 
        driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click();
     	Thread.sleep(1000);
     	
     	if(driver.getPageSource().contains("Websites Data"))
     	{
     		System.out.println("text Websites Data is present");
     	}
     	else {
     		System.out.println("text not present");
     	}
     	driver.close();
     	driver.quit();
     	     	
     	
     	
	}

}
 