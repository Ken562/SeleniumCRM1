package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NetworkRelTestcase {
	@Test(retryAnalyzer = com.comcast.crm.generic.listnerUtility.RetrylistenerImp.class)
	public void activateSim() {
	System.out.println("execute activateSim");
	Assert.assertEquals("", "login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}
}
