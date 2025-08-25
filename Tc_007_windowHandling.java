package testscripts;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_007_windowHandling {

    public static void main(String[] args) throws Exception {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


        driver.get("https://letcode.in/window");
        System.out.println("window handle: " + driver.getWindowHandle());

        // Click on multi-window button
        driver.findElement(By.id("multi")).click();

        // Get all windows
        Set<String> multiwin = driver.getWindowHandles();
        System.out.println("Number of windows: " + multiwin.size());

        // Loop through windows
        for (String childwin : multiwin) {
            driver.switchTo().window(childwin);
            System.out.println("url is: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().equals("https://letcode.in/alert")) {

                driver.findElement(By.id("accept")).click();
                Alert simpleAlert = driver.switchTo().alert();
                System.out.println("Simple Alert text: " + simpleAlert.getText());
                simpleAlert.accept(); // click OK

              
                driver.findElement(By.id("confirm")).click();
                Alert confirmAlert = driver.switchTo().alert();
                System.out.println("Confirm Alert text: " + confirmAlert.getText());
                confirmAlert.dismiss(); // click Cancel

            
                driver.findElement(By.id("prompt")).click();
                Alert promptAlert = driver.switchTo().alert();
                System.out.println("Prompt Alert text: " + promptAlert.getText());
                promptAlert.sendKeys("Akash"); // enter text in prompt
                promptAlert.accept(); // click OK
            }
        }

        driver.quit(); // close all windows at the end
    }
}
