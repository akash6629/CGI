package testscripts;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {
	
	WebDriver driver;

  // Test method using DataProvider
  @Test(dataProvider = "loginData")
  public void f(String username, String password) {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Enter username
		WebElement uname = driver.findElement(By.name("username"));
		if (uname.isDisplayed()) {
			uname.clear();
			uname.sendKeys(username);
			System.out.println("Get placeholder: " + uname.getAttribute("placeholder"));
		} else {
			System.out.println("Username field is not displayed");
		}

		// Enter password
		WebElement pass = driver.findElement(By.name("password"));
		pass.clear();
		pass.sendKeys(password);

		// Press Enter
		pass.sendKeys(Keys.ENTER);

		// Add a simple validation (check page title or URL change)
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("dashboard")) {
			System.out.println("Login successful for: " + username);
		} else {
			System.out.println("Login failed for: " + username);
		}
  }

  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  // 🔹 DataProvider with multiple login credentials
  @DataProvider(name = "loginData")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },   // valid
      new Object[] { "Admin", "wrongpass" }, // invalid
      new Object[] { "wrongUser", "admin123" }, // invalid
    };
  }
}
