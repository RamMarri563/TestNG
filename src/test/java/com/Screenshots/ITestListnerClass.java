package com.Screenshots;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListnerClass implements ITestListener {
	BaseTest base;

	@Override
	public void onTestFailure(ITestResult result) {
		base= new BaseTest();
		
			try {
				base.catureScreenshot(result.getMethod().getMethodName()+".jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}}
