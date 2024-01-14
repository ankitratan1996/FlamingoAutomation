package com.flamingo.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int countOfTry=0;
	int limitOfTry=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(countOfTry<limitOfTry)
		{
			countOfTry++;
			return true;
		}
		return false;
	}

}
