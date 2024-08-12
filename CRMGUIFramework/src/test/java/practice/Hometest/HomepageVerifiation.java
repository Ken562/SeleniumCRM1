package practice.Hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageVerifiation {

	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd.getName()+"test start");
		String expectedpage = "Hom";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String title = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText().trim();
		//hardassert
		Assert.assertEquals(title,expectedpage);
		driver.quit();
		System.out.println(mtd.getName()+"test end");
		
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"test start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[(@title='vtiger-crm-logo.gif')]")).isEnabled();
		Assert.assertTrue(status);
		driver.quit();
		System.out.println(mtd.getName()+"test end");
	}
}
