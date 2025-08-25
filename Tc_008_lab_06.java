package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_008_lab_06 {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open application
        driver.get("https://tutorialsninja.com/demo/");

        // -------- STEP 1: Login --------
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("testuser123@gmail.com"); // replace with your Lab 1 email
        driver.findElement(By.id("input-password")).sendKeys("Test@123");           // replace with your Lab 1 password
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        if (driver.getTitle().contains("My Account")) {
            System.out.println("✅ Login Successful");
        } else {
            System.out.println("❌ Login Failed");
        }

        // -------- STEP 2: Components → Monitors --------
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();

        // -------- STEP 3: Select 25 from 'Show' dropdown --------
        WebElement showDropDown = driver.findElement(By.id("input-limit"));
        Select select = new Select(showDropDown);
        select.selectByVisibleText("25");
        System.out.println("✅ Selected 25 items per page");

        // -------- STEP 4: Add first item to cart --------
        driver.findElement(By.xpath("(//button[@data-original-title='Add to Cart'])[1]")).click();
        Thread.sleep(2000);

        // -------- STEP 5: Click Specification tab --------
        driver.findElement(By.linkText("Apple Cinema 30\"")).click();
        driver.findElement(By.xpath("//a[text()='Specification']")).click();

        WebElement specTable = driver.findElement(By.id("tab-specification"));
        if (specTable.isDisplayed()) {
            System.out.println("✅ Specification details verified");
        } else {
            System.out.println("❌ Specification details NOT found");
        }

        // -------- STEP 6: Add to wishlist --------
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        WebElement wishMsg = driver.findElement(By.cssSelector(".alert-success"));
        if (wishMsg.getText().contains("Success: You have added Apple Cinema 30")) {
            System.out.println("✅ Wishlist success message verified");
        } else {
            System.out.println("❌ Wishlist message not correct");
        }

        // -------- STEP 7: Search Mobile --------
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        // Click "Search in product descriptions"
        WebElement descChk = driver.findElement(By.id("description"));
        descChk.click();
        if (descChk.isSelected()) {
            System.out.println("✅ Search in description checkbox selected");
        } else {
            System.out.println("❌ Checkbox not selected");
        }

        // -------- STEP 8: Select HTC Touch HD --------
        driver.findElement(By.linkText("HTC Touch HD")).click();

        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
        driver.findElement(By.id("button-cart")).click();

        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
        if (successMsg.getText().contains("Success: You have added HTC Touch HD")) {
            System.out.println("✅ HTC Touch HD added to cart");
        } else {
            System.out.println("❌ HTC Touch HD not added to cart");
        }

        // -------- STEP 9: View cart --------
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        WebElement productName = driver.findElement(By.linkText("HTC Touch HD"));
        if (productName.isDisplayed()) {
            System.out.println("✅ Cart has HTC Touch HD");
        } else {
            System.out.println("❌ Cart is missing HTC Touch HD");
        }

        // -------- STEP 10: Checkout --------
        driver.findElement(By.linkText("Checkout")).click();
        if (driver.getTitle().contains("Checkout")) {
            System.out.println("✅ Checkout page opened");
        } else {
            System.out.println("❌ Checkout page not opened");
        }

        // -------- STEP 11: Logout --------
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();

        WebElement logoutHeading = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
        if (logoutHeading.isDisplayed()) {
            System.out.println("✅ Logout Successful");
        } else {
            System.out.println("❌ Logout Failed");
        }

        // Close browser
        Thread.sleep(2000);
        driver.quit();
    }
}
