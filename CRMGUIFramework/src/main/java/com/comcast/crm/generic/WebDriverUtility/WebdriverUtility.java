package com.comcast.crm.generic.WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	 WebDriver driver=null;
	// Actions action;
	//Select select;
	
	public WebDriver launchTheBrowser(String key) {

		while(key!=null) {
			if(key.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
				break;
			}
			else if(key.equalsIgnoreCase("gecko")) {
				driver=new FirefoxDriver();
				break;
		}
			else if(key.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
				break;
	}
			else if(key.equalsIgnoreCase("safari")) {
				driver=new SafariDriver();
				break;
			}
		}
		return driver;
	}
	
	public void getUrl(String path) {
	driver.get(path);
	}
			
				
	

	public void waitForPagetoLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void MaximizeWindow() {
		driver.manage().window().maximize();
	}
	

	
	
	public void waitForElementTobePresent(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForUrl( String value) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(value));
	}
	public void waitFor_partialTitle( String value) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(value));
	}
	public void waitForTitleTobeMatched( String value) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(value));
	}
	public void waitForelementToBeClickable( WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Select Dropdown(WebElement element) {
		Select sel=new Select(element);
		return sel;
	}
	public void HandleDropdownbyIndex(WebElement element,int index) {
		Dropdown(element).selectByIndex(index);
	}
	public void HandleDropdownbyText(WebElement element,  String Text) {
		Dropdown(element).selectByVisibleText(Text);
	}
	public void HandleDropdownbyValue(WebElement element, String Value) {
		Dropdown(element).selectByValue(Value);
	}
	
	
	public Actions initAction() {
		Actions act=new Actions(driver);
		return act;
	}
	public void mousehover( WebElement element) {
		initAction().moveToElement(element).perform();
	}
	public void dragandDrop(WebElement srcelement, WebElement destelement) {
		initAction().dragAndDrop(srcelement, destelement).perform();
	}
	public void doubleClick(WebElement element) {
		initAction().doubleClick(element).perform();
	}
	public void contexClick(WebElement element) {
		initAction().contextClick(element).perform();
		}
	
	public void enterTheData(WebElement element, String value) {
		initAction().sendKeys(element, value).perform();
	}
	public void clickToElement(WebElement element) {
		initAction().click(element).perform();
	}
	
	
	public void switchToWindow_PartialUrl(String partial) {
		Set<String> set = driver.getWindowHandles();
		for(String wid:set) {
			driver.switchTo().window(wid);
			if(driver.getCurrentUrl().contains(partial)) {
				break;
				}
			
			}
	}
	public void switchToWindow_Title( String title) {
		Set<String> set = driver.getWindowHandles();
		for(String wid:set) {
			driver.switchTo().window(wid);
			if(driver.getCurrentUrl().contains(title)) {
				break;
				}
			
			}
	}
	public void switchToFrameBy_Index(int Index) {
		driver.switchTo().frame(Index);
	}
	public void switchToFrameBy_NameorId(String NameorId) {
		driver.switchTo().frame(NameorId);
	}
	public void switchToFrameBy_value(String value) {
		driver.switchTo().frame(value);
	}
	public void switchToFrameBy_Webelement( WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToFrameBy_defaultContent() {
		driver.switchTo().defaultContent();
	}
	public void switchtoFrame_parentFrame() {
		driver.switchTo().parentFrame();
	}
	
	JavaUtility Ju=new JavaUtility();
	public void screenshot_Webpage(String pagename ) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
	File tempfile = ts.getScreenshotAs(OutputType.FILE);
	  File permfile = new File("./Screenshot/"+pagename+Ju.getLocalDateandTime()+".png");
	  FileUtils.copyFile(tempfile, permfile);
	}
	public void screenshot_WebElement(WebElement element,String pagename ) throws IOException {
	File tempfile = element.getScreenshotAs(OutputType.FILE);
	  File permfile = new File("./Screenshot/"+pagename+Ju.getLocalDateandTime()+".png");
	  FileUtils.copyFile(tempfile, permfile);
	}
	  public void scrollTillElement(WebElement element) {
	  JavascriptExecutor Je=(JavascriptExecutor)driver;
	  int y = element.getLocation().getY();
	  Je.executeScript("window.scrollBy(0,"+y+")");
	  }
	  public void scrollintoView(WebElement element) {
		  JavascriptExecutor Je=(JavascriptExecutor)driver;
		  Je.executeScript("arguments[0].scrollIntoView(true)",element);
	  }
	  public void clickToElement1(WebElement element) {
		  JavascriptExecutor Je=(JavascriptExecutor)driver;
		  Je.executeScript("arguments[0].click()",element);
	  }
	  public void postcondtion(WebDriver driver) {
		  driver.manage().window().minimize();
		  driver.quit();
	  }
	  
	  
	
	
	
	
	
		
		}

	
