package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact {
@Test(dataProvider="getdata")
	public void CreateContacttest(String FirstName,String lastName) {
		System.out.println("lastName:"+lastName+"firstName:"+FirstName);
	}
	
	
	@DataProvider
	public Object[][] getdata(){
		Object[][] objArr=new Object[2][2];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[1][0]="sam";
		objArr[1][1]="hd";
	
		return objArr;
}
}
