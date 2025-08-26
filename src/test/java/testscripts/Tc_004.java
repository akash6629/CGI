package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_004 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000); // wait for page to load
        
        
        
        
       // Using of keys

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("username")).sendKeys(Keys.TAB);

        driver.switchTo().activeElement().sendKeys("admin123");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);

        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        
        
        
        // isdisplayed method
        
      /*  if(driver.findElement(By.name("username")).isDisplayed())

		{

		driver.findElement(By.name("username")).sendKeys("Admin");

		}

		else

		{

			System.out.println("username is not displayed");

		}*/
        
        
        //getting of attribute value
       
		WebElement uname=driver.findElement(By.name("username"));
		if(uname.isDisplayed())
		{
			uname.sendKeys("Admin");
		System.out.println("Get placeholder:"+uname.getAttribute("placeholder"));
		}
		else
		{
			System.out.println("username is not displayed");
		}
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("username")).sendKeys(Keys.ENTER);

 
    }
}
