package testscripts;

import java.util.List;   

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_003 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");

        List<WebElement> allinks = driver.findElements(By.tagName("a"));

        System.out.println("Total links: " + allinks.size());
/*
        // Print link text and URL
        for (int i = 0; i < allinks.size(); i++) {
            String text = allinks.get(i).getText();
            String url = allinks.get(i).getAttribute("href");

            if (url != null && !url.isEmpty()) {
                System.out.println("Text: " + text + " | URL: " + url);
            }
        }*/

        driver.quit();
    }
}
