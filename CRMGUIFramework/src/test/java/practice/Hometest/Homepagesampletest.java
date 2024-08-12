package practice.Hometest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homepagesampletest {
@Test
	public void Homepagestest(Method mtd) {
		System.out.println(mtd.getName()+"test start");
		SoftAssert asserObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		asserObj.assertEquals("Home", "Homep");
		System.out.println("step-3");
		asserObj.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("step-4");
		asserObj.assertAll();
		System.out.println();
		System.out.println(mtd.getName()+"test end");
	}
	@Test
	
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"test start");
		SoftAssert asserObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		asserObj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		asserObj.assertAll();
		System.out.println(mtd.getName()+"test end");
	}
}
