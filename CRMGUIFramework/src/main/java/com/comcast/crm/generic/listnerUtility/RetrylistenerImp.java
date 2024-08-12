package com.comcast.crm.generic.listnerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetrylistenerImp implements IRetryAnalyzer {

	int countlimit=5;
	int count=0;
	public boolean retry(ITestResult result) {
		if(count<countlimit) {
			count++;
		return true;
		
	}
	
		return false;
}

}
