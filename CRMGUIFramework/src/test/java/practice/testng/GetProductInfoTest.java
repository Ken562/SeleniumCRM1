package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.genericUtility.ExcelUtility;

public class GetProductInfoTest {

	@Test(dataProvider="getdata")
	public void getProductInfotest(String Brandname,String productname) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		//searchProduct
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		//capture product info
		String x="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getdata() throws Throwable{
		ExcelUtility Eu=new ExcelUtility();
		int Rowcount = Eu.getRowcount("sheet1");
		Object[][] objArr=new Object[Rowcount][2];
		for(int i=0;i<Rowcount;i++) {
			objArr[i][0]=Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "sheet1", i+1, 0);
			objArr[i][1]=Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "sheet1", i+1, 1);
			
		}
		
	return objArr;
	
	
}
}
