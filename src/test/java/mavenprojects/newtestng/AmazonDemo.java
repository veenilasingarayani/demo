package mavenprojects.newtestng;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
	public class AmazonDemo {
		WebDriver driver;

		
	 @BeforeTest
	 public void LaunchUrl()
	 {
		 
		 WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	  System.out.println("Launched URL");
	 }
	 @BeforeMethod
	 public void login()
	 {
		 driver.findElement(By.id("ap_email")).sendKeys("8885850680");
		 driver.findElement(By.id("continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys("Maayu@17324556");
		 driver.findElement(By.id("signInSubmit")).click();
	  System.out.println("Login Successful");
	 }
	 @Test(priority=1)
	 public void search()
	 {
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles Under 30000");
		 driver.findElement(By.id("nav-search-submit-button")).click();
	  System.out.println("Search Completed");
	 }
	 @Test(priority=2)
	 public void addToCart() throws Exception
	 { 
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles Under 30000");
		 driver.findElement(By.id("nav-search-submit-button")).click();
		 driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
		 // Store the current window handle
		 String winHandleBefore = driver.getWindowHandle();

		 // Perform the click operation that opens new window

		 // Switch to new window opened
		 for(String winHandle : driver.getWindowHandles()){
		     driver.switchTo().window(winHandle);
		     Thread.sleep(10000);
		     driver.findElement(By.id("add-to-cart-button")).click();
		 }

		 // Perform the actions on new window
	  System.out.println("Added To Cart");
	 
	 }
	 @AfterMethod
	 public void logout()
	 {
		 WebElement hoverSignout = driver.findElement(By.id("nav-link-accountList"));
		 Actions action = new Actions(driver);
		 action.moveToElement(hoverSignout).build().perform();
		 driver.findElement(By.id("nav-item-signout")).click();
		
	  System.out.println("Logged out");
	 }
	@AfterTest
	 public void closeBrowser()
	 {
	  driver.close();
	  // Switch back to original browser (first window)
	  //driver.switchTo().window(winHandleBefore);
	  driver.close();
	 }

	}

