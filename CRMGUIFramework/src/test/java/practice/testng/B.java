package practice.testng;

import org.testng.annotations.DataProvider;

public class B {
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
