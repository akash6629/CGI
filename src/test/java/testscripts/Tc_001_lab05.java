package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_001_lab05 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Launch the URL
        driver.get("https://tutorialsninja.com/demo/");

        // 2. Verify 'Title' of the page
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        if (title.contains("Your Store")) {
            System.out.println("Title verified");
        } else {
            System.out.println("Title mismatch");
        }

        // 3. Click on 'My Account' dropdown
        driver.findElement(By.linkText("My Account")).click();

        // 4. Select 'Register' from dropdown
        driver.findElement(By.linkText("Register")).click();

        // 5. Verify heading 'Register Account'
        WebElement heading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if (heading.isDisplayed()) {
            System.out.println("Heading 'Register Account' is verified");
        }

        // 6. Click on 'Continue' without filling anything
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // 7. Verify warning message
        WebElement warn = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        String warning = warn.getText();
        if (warning.contains("Warning: You must agree to the Privacy Policy!")) {
            System.out.println("Warning Appeared: " + warning);
        } else {
            System.out.println("Warning not Appeared: " + warning);
        }

        // Part 2: Personal Details
        // 1. First Name
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        String longFirstName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
        firstName.sendKeys(longFirstName);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement firstNameError = driver.findElement(
            By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"));
        if (firstNameError.isDisplayed()) {
            System.out.println("First Name validation error displayed: " + firstNameError.getText());
        }

        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Akash");

        // 2. Last Name
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        String longLastName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
        lastName.sendKeys(longLastName);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement lastNameError = driver.findElement(
            By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"));
        if (lastNameError.isDisplayed()) {
            System.out.println("Last Name validation error displayed: " + lastNameError.getText());
        }

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Mangond");

        // 3. Email → unique email each run
        WebElement email = driver.findElement(By.id("input-email"));
        String uniqueEmail = "akash6656" + "@gmail.com";
        email.sendKeys(uniqueEmail);

        // 4. Telephone
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("9876543210");

        System.out.println("Personal details entered successfully");

        // Password + Confirm
        driver.findElement(By.id("input-password")).sendKeys("Test1234");
        driver.findElement(By.id("input-confirm")).sendKeys("Test1234");

        // Newsletter & Agree Policy
        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Success message
        WebElement successMsg = driver.findElement(
                By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));

        if (successMsg.isDisplayed()) {
            System.out.println("Registration successful: " + successMsg.getText());
        } else {
            System.out.println(" Registration failed!");
        }

        // Click Continue button on success page
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        // Navigate to 'View your order history'
        WebElement orderHistoryLink = driver.findElement(By.linkText("View your order history"));
        orderHistoryLink.click();

        // Verify Order History page
        WebElement orderHistoryHeading = driver.findElement(
                By.xpath("//h1[contains(text(),'Order History')]"));

        if (orderHistoryHeading.isDisplayed()) {
            System.out.println("Navigated to Order History page.");
        }
        

        driver.quit();
    }
}
