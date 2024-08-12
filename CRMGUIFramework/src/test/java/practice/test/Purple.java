package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Purple {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.purplle.com");
	////div[@class='inner-box inner-box__third ng-star-inserted']//a[@class='d-inline-block px-1 ng-star-inserted']
	
	WebElement smilebtn = driver.findElement(By.xpath("//div[@class='position-relative']/a"));
	Actions action=new Actions(driver);
	Thread.sleep(2000);
	action.moveToElement(smilebtn).perform();
	driver.findElement(By.xpath("//div[@class='position-relative']/div//span[text()='Login or Register']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c106-3']/input")).sendKeys("9934387106");
	driver.findElement(By.xpath("//span[text()='Continue']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//span[text()='Verify']")).click();
	
	//div[@class='position-relative']/a
	
//	smilebtn.click();
}
}
