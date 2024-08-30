package com.tutorialnija.Listeners;


import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class MyListener implements ITestListener{
	
	
	public String testName;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project Execution Started");
		try {
			extentReport = com.tutorialsninja.qa.Utilities.ExtentReporter.generalExtentReporter();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
		

	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getTestName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, TestName + "--> testCase executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getTestName();
		extentTest.log(Status.PASS, TestName + "--> testCase executing");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getTestName();
		System.out.println(TestName + "--> testCase FAILED");
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		e.printStackTrace();
		}
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+ "\\\test-output\\ScreenShots" + TestName + ".png";
		
		try {
		FileHandler.copy(source, new File (destinationFile));
	}catch (IOException e) {
		e.printStackTrace();
	}
		extentTest.addScreenCaptureFromBase64String(destinationFile);
}		

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName = result.getTestName();
		System.out.println(TestName + "--> testCase SKIPPED");
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Project Execution Finished");
	}



}
