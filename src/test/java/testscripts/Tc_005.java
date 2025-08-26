package testscripts;

import java.util.List;   // ✅ Correct import

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_005 {

    public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://tutorialsninja.com/demo/");

        // Navigate to Desktops -> Mac (1)
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        // Locate the dropdown
        WebElement sort = driver.findElement(By.id("input-sort"));
        
        // Use Select
        Select sort1 = new Select(sort);

        // Get all options
        List<WebElement> l1 = sort1.getOptions();

        System.out.println("Total options in sort dropdown: " + l1.size());

        // Print all options
        for (WebElement option : l1) {
            System.out.println("values are:" + option.getText());
        }

        driver.quit();
    }
}
