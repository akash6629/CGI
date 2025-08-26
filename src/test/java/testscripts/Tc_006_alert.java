package testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_006_alert {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://letcode.in/alert");

        // Simple Alert :Simple alerts just have a OK button on them. 
        // They are mainly used to display some  information to the user
        driver.findElement(By.id("accept")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert text: " + simpleAlert.getText());
        simpleAlert.accept(); // click OK
        Thread.sleep(2000);

        // Confirm Alert:This alert comes with an option to accept or dismiss the alert. To accept the alert  
        // you can use Alert.accept() and to dismiss you can use the Alert.dismiss().


        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm Alert text: " + confirmAlert.getText());
        confirmAlert.dismiss(); // click Cancel
        Thread.sleep(2000);

        // Prompt Alert: In prompt alerts you get an option to add text to the alert box. 
        // This is specifically  used when some input is required from the user. We will use
        // the sendKeys() method to type something in the Prompt alert box.

        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert text: " + promptAlert.getText());
        promptAlert.sendKeys("Akash"); // enter text in prompt
        promptAlert.accept(); // click OK
        Thread.sleep(2000);

        driver.quit();
    }
}
