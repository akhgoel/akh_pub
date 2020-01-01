package customereporter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CustomLogger {
	
	public static void logPass(String log)
	{
		if(ExtentManager.getTest()!=null)
		{
			ExtentManager.getTest().log(Status.PASS, log);
			ExtentManager.getTest().log(Status.INFO,"this is info");
			System.out.println(log);
		}
	}
	
	public static void logFail(String log)
	{
		if(ExtentManager.getTest()!=null)
		{
			ExtentManager.getTest().log(Status.FAIL, log);
			System.out.println(log);
		}
	}
	
	public static void logFail(String log, ExtentColor color)
	{
		if(ExtentManager.getTest()!=null)
		{
			ExtentManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(log, color));
		}
		System.out.println(log);
	}

}
