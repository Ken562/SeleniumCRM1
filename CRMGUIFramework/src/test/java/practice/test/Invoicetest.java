package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseUtility.Baseclass;
//@Listeners(com.comcast.crm.generic.listnerUtility.ListImpClass.class)
public class Invoicetest extends Baseclass {
@Test
public void createInvoiceTest() {
	System.out.println("execute createInvoiceTest");
	String actTitle = driver.getTitle();
	Assert.assertEquals(actTitle, "login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
	
}
@Test
public void createInvoicewithContactTest() {
	System.out.println("createInvoicewithContactTest");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
	
}

}
