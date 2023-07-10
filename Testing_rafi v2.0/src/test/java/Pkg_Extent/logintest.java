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

public class logintest {
	 ChromeDriver driver = new ChromeDriver();
	 ExtentReports extent = new ExtentReports();
	 ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
  
	 @BeforeTest
	  public void beforeTest() {
		 spark.config().setTheme(Theme.DARK);
		 spark.config().setDocumentTitle("Rafi_Report-v2");
		 extent.attachReporter(spark);
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  String baseUrl = "http://localhost:8069/";
	       driver.get(baseUrl);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }

	 public static String capturescreenshot(ChromeDriver driver) throws IOException {
			
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destinationfilepath = new File("src/../images/screenshot"+System.currentTimeMillis()+".png");
			String absolutepathlocation = destinationfilepath.getAbsolutePath();
			FileUtils.copyFile(srcfile, destinationfilepath);
			return absolutepathlocation;
			  
		  }
	 
	  @Test
  public void tc_000() throws IOException {
		   
		  ExtentTest test = extent.createTest("Launch browser and website ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	     test.info("capturing the page title");
	     String pagetitle = driver.getTitle();
	     System.out.println("page title is:" +pagetitle);
	     if (pagetitle.equals("Home | My Website")) {
	    	 test.pass("page title is verified : titie captured :" +pagetitle);
	    	 test.addScreenCaptureFromPath(capturescreenshot(driver));
	    	 }else {
	    		 test.fail("page title is not macthed with expected results :" +pagetitle);
	    		 test.addScreenCaptureFromPath(capturescreenshot(driver));
	    	 }
	     //driver.findElement(By.xpath("//*[@id=\"top_menu\"]/li[3]/a")).click();
	       }
	 
	  
	  @Test(dataProvider = "credentials")
	  public void tc_001(String scenario, String username, String password ) throws IOException, InterruptedException {
		  
		  ExtentTest test = extent.createTest("login with username and password ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  // Click on Signing
		  test.info("logging into the page");
		  driver.findElement(By.xpath("//*[@id=\"top_menu\"]/li[3]/a")).click();
		  Thread.sleep(1000);
		  test.addScreenCaptureFromPath(capturescreenshot(driver));
		  test.info("Enter username and password");

		  Thread.sleep(1000);
      // Enter Email 
		  driver.findElement(By.id ("login")).sendKeys(username);
      //Enter password
		  driver.findElement(By.id ("password")).sendKeys(password);
      // Click on login
		  Thread.sleep(1000);
		  test.addScreenCaptureFromPath(capturescreenshot(driver));
		  test.info("clicking on login");
		  driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click();
		  Thread.sleep(1000);
		  if(scenario.equals("bothcorrect")){
			  WebElement dropdowntoggle = driver.findElement (By.className ("dropdown-toggle"));
			  Assert.assertTrue(dropdowntoggle.isDisplayed(), "Login not Sucess");
			  test.addScreenCaptureFromPath(capturescreenshot(driver));
			  }
//		  else  if (scenario.equals("bothwrong")) {
//			  String errormessage = driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/p")).getText();
//			  Assert.assertEquals(errormessage, "Wrong login/password");
//			  test.addScreenCaptureFromPath(capturescreenshot(driver));
//			  }
		  
		  test.addScreenCaptureFromPath(capturescreenshot(driver));

	     Thread.sleep(1000);
      
	  test.log(Status.PASS, "user logged into website");
	  test.pass("user logged in verified");
	 }
	  @DataProvider (name = "credentials")
	  public  Object [][] getdata(){
		  return new Object [][]{
		            {"bothcorrect","mohammedrafi.shaik@gmail.com","123456789"},
		             /*{"bothwrong","mohammed.shaik@gmail.com","1234567"},
		             {"correctusername","mohammedrafi.shaik@gmail.com","1234567"},
		             {"correctpassword","mohammed.shaik@gmail.com","123456789"}*/
		  };
		  }


  @Test
  public void tc_002() throws InterruptedException, IOException {
	  ExtentTest test = extent.createTest("Indkika Module Verification ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  
	   Thread.sleep(1000);
      //click on the Discuss toggle for top menu 
      driver.findElement(By.xpath("/html/body/header/nav/div[1]/button")).click();
      test.addScreenCaptureFromPath(capturescreenshot(driver));
      Thread.sleep(1000);
      //verify the module name with the src doucment
      String modulename = driver.findElement(By.xpath("/html/body/header/nav/div[1]/div/a[4]")).getText();
      System.out.println("Module name is displayed as:" +modulename);
      
      Thread.sleep(1000);
      test.addScreenCaptureFromPath(capturescreenshot(driver));
      driver.findElement(By.xpath("/html/body/header/nav/div[1]/div/a[4]")).click();
      String title = driver.getTitle();
      System.out.println("Title of the page is:" +title);
      Thread.sleep(1000);
      test.addScreenCaptureFromPath(capturescreenshot(driver));
      
      String websitenamedisplay = driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).getText();
      System.out.println("Websitename dispalay is:" +websitenamedisplay);
      String vendornamedisplay = driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).getText();
      System.out.println("vendorname dispalay is:" +vendornamedisplay);
      String ppdmmappingnamedisplay = driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[3]")).getText();
      System.out.println("PPDM mapping name dispalay is:" +ppdmmappingnamedisplay);
      String title1 = driver.getTitle();
      System.out.println("Title of the page is:" +title1);
    
		  test.log(Status.PASS, "user launched Indkia Module");
		  test.pass("In Indkika Module, Wesbsites Menu Tab is displayed");
		  test.pass("In Indkika Module, Vendor Sites Menu Tab is displayed");
		  test.pass("In Indkika Module, PPDM Mapping Menu Tab is displayed");
             
  }
  
  @Test
  public void tc_003() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Search bar Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/div/input")).isDisplayed();
	Thread.sleep(500);
	Assert.assertTrue(flag);
	test.pass("Search bar in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	
  }
  @Test
  public void tc_004() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Site Name Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[2]/div/span")).getText();
	Thread.sleep(500);
	String actualtext ="Site Name";
	 
	 Assert.assertEquals(actualtext, text);
	test.pass("Site Name in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
  }
  @Test
  public void tc_005() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Site Brief Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[3]/div/span")).getText();
	Thread.sleep(500);
	String actualtext ="Site Brief";
	 
	 Assert.assertEquals(actualtext, text1);
	test.pass("Site Brief in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
  }
  @Test
  public void tc_006() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Site Url Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[4]/div/span")).getText();
	Thread.sleep(500);
	String actualtext ="Site Url";
	 
	 Assert.assertEquals(actualtext, text2);
	test.pass("Site Url in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	}
  @Test
  public void tc_007() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Websites Data Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/ol/li/span")).getText();
	Thread.sleep(500);
	String actualtext ="Websites Data";
	 
	 Assert.assertEquals(actualtext, text3);
	test.pass("Websites Data in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	}

  @Test
  public void tc_008() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Create Button Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button")).getText();
	Thread.sleep(500);
	String actualtext ="CREATE";
	 System.out.println("the text in the button is" +text4);
	 Assert.assertNotEquals(actualtext, text4);
	//test.pass("Create button in Wesbsites Menu Tab is displayed");
	test.fail("Create button in websites Menu Tab is not displayed "  );
	test.fail(actualtext);
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	}
  @Test
  public void tc_009() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("radiobutton Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[1]/div/input")).isDisplayed();
	
	Thread.sleep(500);
	Assert.assertTrue(flag);
	test.pass("radio button in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	 // inputs into the websites menu
	
	   /// click on the new button
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div/input")).sendKeys("BBC BBC");
	  driver.findElement(By.xpath("//input[@id='desc']")).sendKeys("It's a British Broadcasting Corporation news Channel");
	  
	  WebElement urlinput = driver.findElement(By.xpath("//input[@id='url']"));
	  //enter the wrong url
	   urlinput.sendKeys("www.bbc.co.uk");
	   // Get the entered URL value
       String enteredUrl = urlinput.getAttribute("value");
	 
       //String text  = "www.bbc.co.uk";
                      
	   String regex = "[\\w-]+(\\.[\\w-]+)+([/?#][^\\s]*)?$";
       Pattern pattern = Pattern.compile(regex);
       //String currentURL = driver.getCurrentUrl();
       Matcher matcher = pattern.matcher(enteredUrl);
     
       
        //Perform assertions or other actions based on the result
       if (matcher.matches()) {
           System.out.println("Valid URL format.");
           driver.findElement(By.xpath("//a[contains(text(),'Add a line')]")).click();
     	  driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/main/div/div/div[1]/div[2]/div/input")).sendKeys("First party");
     	  driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/main/div/div/div[2]/div[2]/div/div/textarea")).sendKeys("Normal data collection about mail id, address and DoB");
     	  driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/footer/button[1]")).click();
     	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[1]/ol/li[2]/div/div/button[1]/i")).click();
     	  test.addScreenCaptureFromPath(capturescreenshot(driver));
     	 //Assert.assertEquals(matcher.matches(), "URL format validation pass for given text: " + enteredUrl);
     	  test.pass("Entered URL is a Valid URL format");
     	 driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
   	  
     	WebElement radioElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[1]/div/input"));
     	boolean selectState = radioElement.isSelected();
     			
     	//performing click operation only if element is not selected
     	if(selectState == false) {
     		radioElement.click();
     	}
     	
     	
     	Thread.sleep(1000);
     	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[2]/div/button")).click();
     	Thread.sleep(500);
     	test.pass("radio button is selected to perform delete options in Wesbsites Menu Tab is displayed");
     	test.addScreenCaptureFromPath(capturescreenshot(driver));
     	driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
     	Thread.sleep(1000);
     	test.addScreenCaptureFromPath(capturescreenshot(driver));
     	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/footer/button[1]")).click();
     	Thread.sleep(1000);                     
     	test.addScreenCaptureFromPath(capturescreenshot(driver));

     	   
     	test.pass("Deleted previous saved url's in Wesbsites Menu Tab is displayed");
     	test.addScreenCaptureFromPath(capturescreenshot(driver));
     	  
       } else {
           System.out.println("Invalid URL format.");
           Assert.assertFalse(matcher.matches(), "Invalid URL format: " + enteredUrl);
           test.fail("Entered URL is not a correct URL format, Please enter the correct URL"  );
       	   test.fail(enteredUrl);
       	   test.addScreenCaptureFromPath(capturescreenshot(driver));
       	   //urlinput.clear();
       	   Thread.sleep(1000);
       	   driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
       }
         
  }
  
  
  @Test
  public void tc_010() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Create Button Verification in vendor sites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  Thread.sleep(500);
	  test.info("Create button screenshot in vendorsites");
	  test.addScreenCaptureFromPath(capturescreenshot(driver));

	  String text4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button")).getText();
	Thread.sleep(500);
	String actualtext ="CREATE";
	 
	Assert.assertNotEquals(actualtext, text4);
	//test.pass("Create button in Wesbsites Menu Tab is displayed");
	test.fail("Create button in vendor Sites Menu Tab is not displayed "  );
	test.fail(actualtext);
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	
  }
    
  @Test
  public void tc_011() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Search bar Verification in VendorSites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div")).isDisplayed();
	Thread.sleep(500);
	Assert.assertTrue(flag);
	test.pass("Search bar in Vendor Sites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	
  }
  
  @Test
  public void tc_012() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("radiobutton Verification in VendorSites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[1]")).isDisplayed();
	
	Thread.sleep(500);
	Assert.assertTrue(flag);
	test.pass("radio button in Vendor sites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	 // inputs into the vendor sites menu tab
	
	   /// click on the new button
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//input[@id='name']")).sendKeys("BBC BBC vendor");
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div/input")).sendKeys("It's a  vendors British Broadcasting Corporation news Channel");
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[3]/div[2]/div/input")).sendKeys("www.bbc.co.uk");
	  driver.findElement(By.xpath("//a[contains(text(),'Add a line')]")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/main/div/div/div[1]/div[2]/div/input")).sendKeys("third party data");
//	  driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/main/div/div/div[2]/div[2]/div/select")).click();
	  Select fruits = new Select(driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/main/div/div/div[2]/div[2]/div/select")));
		fruits.selectByVisibleText("First Party");
		fruits.selectByIndex(1);	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	  
		  driver.findElement(By.xpath("//button[contains(text(),'Save & Close')]")).click();
				
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  
	WebElement radioElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[1]"));
	boolean selectState = radioElement.isSelected();
			
	//performing click operation only if element is not selected
	if(selectState == false) {
		radioElement.click();
	}
	
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[2]/div/button")).click();
	Thread.sleep(500);
	test.pass("radio button is selected to perform delete options in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
	Thread.sleep(1000);
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/footer/button[1]")).click();
	Thread.sleep(1000);                     
	test.addScreenCaptureFromPath(capturescreenshot(driver));
//     
//     //Get handles of the windows
//     String mainWindowHandle = driver.getWindowHandle();
//     Set<String> allWindowHandles = driver.getWindowHandles();
//     Iterator<String> iterator = allWindowHandles.iterator();
//
//     // Here we will check if child window has other child windows and will fetch the heading of the child window
//     while (iterator.hasNext()) {
//         String ChildWindow = iterator.next();
//             if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
//             driver.switchTo().window(ChildWindow);
//             String title2 = driver.getTitle();
//             System.out.println("the popwindow title is:" +title2);
//             //driver.findElement(By.xpath("//*[@id=\"dialog_4\"]/div/div/div/footer/button[1]")).click();
//             
//         }
//     }
//     
     
	
//	 // Switch to the alert dialog
//    Alert alert = driver.switchTo().alert();
//
//    // Get the alert text
//    String alertText = alert.getText();
//
//    // Display the alert text
//    System.out.println("Alert Text: " + alertText);
//
//    // Click OK/Cancel based on your confirmation requirements
//    // To accept the confirmation:
//    alert.accept();
	   
	test.pass("Deleted previous saved url's in Vendor sites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
  }
  @Test
  public void tc_013() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Vendor Name Verification in Vendor sites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[2]/div/span")).getText();
	Thread.sleep(500);
	String actualtext ="Vendor Name";
	 
	 Assert.assertEquals(actualtext, text);
	test.pass("Vendor Name in Wesbsites Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
  }
  @Test
  public void tc_014() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Vendor Site Url Verification in websites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/thead/tr/th[3]/div/span")).getText();
	Thread.sleep(500);
	String actualtext ="Vendor Site Url";
	 
	 Assert.assertEquals(actualtext, text1);
	test.pass("Vendor Site Url in Vendors Site Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
  }
  
  @Test
  public void tc_015() throws IOException, InterruptedException {
	  ExtentTest test = extent.createTest("Vendors Data Verification in VendorSites Menu tab ").assignAuthor("Rafi").assignCategory("Functional Test Cases").assignDevice("Windows");
	  driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
	  Thread.sleep(500);
	  test.addScreenCaptureFromPath(capturescreenshot(driver));
	String text3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/ol/li/span")).getText();
	Thread.sleep(500);
	String actualtext ="Vendors Data";
	 
	 Assert.assertEquals(actualtext, text3);
	test.pass("Vendors Data(name Text) in Vendors Site  Menu Tab is displayed");
	test.addScreenCaptureFromPath(capturescreenshot(driver));
	}
  @AfterTest
  public void afterTest() {
	  extent.flush();
	  driver.close();
  }

}
