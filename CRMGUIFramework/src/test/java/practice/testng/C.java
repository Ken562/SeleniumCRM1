package practice.testng;

import org.testng.annotations.Test;

public class C {
	@Test(dataProvider="getdata",dataProviderClass=B.class)
	public void CreateContacttest(String FirstName,String lastName) {
		System.out.println("lastName:"+lastName+"firstName:"+FirstName);
	}
}
