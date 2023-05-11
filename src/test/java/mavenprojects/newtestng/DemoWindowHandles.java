package mavenprojects.newtestng;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWindowHandles {

public static void main(String[] args) throws Exception {

WebDriverManager.chromedriver().setup();

ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(chromeOptions);
driver.get("https://demoqa.com/browser-windows");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();

String parentWindowHandle = driver.getWindowHandle();
System.out.println(parentWindowHandle);

driver.findElement(By.id("windowButton")).click();
driver.findElement(By.id("messageWindowButton")).click();

Set<String> childWindowHandles = driver.getWindowHandles();
Iterator<String> iterator = childWindowHandles.iterator();
//{"id1","id2"}
while(iterator.hasNext())
{
String childWindow = iterator.next();
if(!parentWindowHandle.equalsIgnoreCase(childWindow))
{
driver.switchTo().window(childWindow);
Thread.sleep(2000);
driver.close();
Thread.sleep(2000);
}
}

}

}