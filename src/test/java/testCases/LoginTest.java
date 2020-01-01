package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTestClass;
import customereporter.CustomLogger;

public class LoginTest extends BaseTestClass {
	
	@Test
	public void test1()
	{
		CustomLogger.logPass("test1 got passed");
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2()
	{
		CustomLogger.logFail("test2 got Failed");
		Assert.assertTrue(false);
	}

}
