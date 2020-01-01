package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTestClass;

import customereporter.CustomLogger;

public class HomePage extends BaseTestClass{
	@Test(invocationCount=3, threadPoolSize=3)
	public void Hometest1()
	{
		int a=10;
		int b=10;
		int c=a+b;
		Assert.assertEquals(c, 20);
		CustomLogger.logPass("Home test1 got passed");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Hometest2()
	{
		CustomLogger.logFail("Home test2 got Failed");
		Assert.assertTrue(false);
	}
}
