package practice.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Demo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com");
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("john");
		driver.findElement(By.id("LastName")).sendKeys("den");
		driver.findElement(By.id("Email")).sendKeys("stushmlk156@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("sharma@12");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("sharma@12");
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.xpath("//input[@type='button'and@value='Continue']")).click();
  Actions act=new Actions(driver);
  WebElement webele = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));
	   act.moveToElement(webele).perform();
	 List<WebElement> comp = driver.findElements(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]/../ul/li/a"));
	
	 for(WebElement ele:comp) {
		 System.out.println(ele.getText());
	 }
	 driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
}
