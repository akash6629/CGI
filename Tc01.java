package testscripts;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc01 {

    public static void main(String[] args) {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. Open Application
            driver.get("https://tutorialsninja.com/demo/");

            // 2. Verify page title
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);
            if (title.equals("Your Store")) {
                System.out.println("Title verified");
            } else {
                System.out.println("Title mismatch");
            }

            // 3. Click on My Account -> Register
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();

            // 4. Verify Heading
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Register Account']")));
            if (heading.getText().equals("Register Account")) {
                System.out.println("Heading 'Register Account' is verified");
            }

            // 5. Fill the form
            driver.findElement(By.id("input-firstname")).sendKeys("Akash");
            driver.findElement(By.id("input-lastname")).sendKeys("Mangond");

            // generate unique email each run
            String email = "akash" + new Random().nextInt(10000) + "@gmail.com";
            driver.findElement(By.id("input-email")).sendKeys(email);

            driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
            driver.findElement(By.id("input-password")).sendKeys("Test@123");
            driver.findElement(By.id("input-confirm")).sendKeys("Test@123");

            // Do not check Privacy Policy yet
            // Click Continue
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // 6. Verify warning message (re-locate after DOM refresh)
            WebElement warn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='account-register']/div[1]")));
            String warning = warn.getText();

            if (warning.contains("Warning: You must agree to the Privacy Policy!")) {
                System.out.println("Warning Appeared: " + warning);
            } else {
                System.out.println("Warning not Appeared: " + warning);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
