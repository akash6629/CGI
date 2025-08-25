package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_008_lab_06 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();    
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("akash6656@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test1234");       
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        

		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
		
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		WebElement sort = driver.findElement(By.id("input-limit"));
		sort.click();
		Select sort1 = new Select(sort);
		sort1.selectByContainsVisibleText("25");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		WebElement input = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		input.sendKeys("Mobile");
		WebElement enter = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
		enter.click();
		
		WebElement select = driver.findElement(By.xpath("//*[@id=\"description\"]"));
		select.click();
		
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		
		driver.findElement(By.linkText("HTC Touch HD")).click();
		
		WebElement input2 = driver.findElement(By.xpath("//*[@id=\"input-quantity\"]"));
		input2.clear();
		input2.sendKeys("3");
		Thread.sleep(2000);
		
		WebElement enter2 = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
		enter2.click();
		Thread.sleep(3000);
		
		WebElement message = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		String expectedMsg = "Success: You have added HTC Touch HD to your shopping cart!";
		if(message.getText().contains(expectedMsg)) {
			System.out.println("Message is appearing");
		}
		else {
			System.out.println("Message is not appearing");
		}
		
		driver.findElement(By.id("cart-total")).click();
		
		WebElement title = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[2]/a"));
		String expectedTitle = "HTC Touch HD";
		if(title.getText().contains(expectedTitle)) {
			System.out.println("Mobile name is appearing");
		}
		else {
			System.out.println("Mobile name is not appearing");
		}
		
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.linkText("Continue")).click();
		
		driver.quit();

	}
}