package customereporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extentReport=null;
	private static ExtentTest extentTest=null;

	private ExtentManager() {

	}
	
	public static ExtentTest getTest()
	{
		return extentTest;
	}
	
	public static void setTest(ExtentTest test)
	{
		extentTest=test;
	}
	
	public static ExtentReports getInstance(){
		if(extentReport==null){
			createInstance();
		}
		return extentReport;
	}
	
	public static ExtentReports createInstance()
	{
		System.out.println("calling createInstance");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report Created By: ");
		htmlReporter.config().setReportName("My Automation Report");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("uft-8");
		extentReport =new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		return extentReport;
	}

	
	public static void addExecutionDetails_ExtentReport(){
		extentReport.setSystemInfo("Applicarion Version", "build 1.0.1");
		extentReport.setSystemInfo("Application Build Stamp", "123456789abc");
		extentReport.setSystemInfo("Environment", "Staging");
		extentReport.setSystemInfo("Execution Type", "Automation");
		extentReport.setSystemInfo("Language", "English");
		extentReport.flush();
	}
	
}
