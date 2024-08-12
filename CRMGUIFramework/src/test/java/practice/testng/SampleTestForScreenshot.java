package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
@Test
public void amazonTest() throws IOException {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	WebDriver Drievr=new ChromeDriver();
	////span[text()='Account & Lists']
	//step-1 create an Object to Event firing WebDriver
	EventFiringWebDriver Edriver = new EventFiringWebDriver(driver);
	File src = Edriver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshot/test.png"));

}


	
}

