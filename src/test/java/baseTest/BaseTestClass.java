package baseTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


import customereporter.CustomReporter;
import customereporter.ExtentManager;


@Listeners({ CustomReporter.class })
public class BaseTestClass {
	public static WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("Base class before suite");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("Base class after suite");
		ExtentManager.addExecutionDetails_ExtentReport();
	}
	
	
	public static String capture() throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
				+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
}
