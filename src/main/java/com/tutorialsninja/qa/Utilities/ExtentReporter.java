package com.tutorialsninja.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class ExtentReporter {
	
	
	public static ExtentReports generalExtentReporter() throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\extentreporter\\extentreporterTutorialNija.html");

		ExtentSparkReporter sparkReperorter = new ExtentSparkReporter(extentReportFile);
		
		sparkReperorter.config().setTheme(Theme.DARK);
		sparkReperorter.config().setReportName("Magento Regression Test");
		sparkReperorter.config().setDocumentTitle("Magento | PnT Weekend Batch 133 ");
		sparkReperorter.config().setTimeStampFormat("MM/DD/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReperorter);
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "src\\test\\java\\com\\tutorialnija\\CofigData\\config.properties" );
		prop.load(ip);
		
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("browser name", prop.getProperty("chrome"));
		extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("java version", prop.getProperty("java version"));
		extentReport.setSystemInfo("SDET Name", prop.getProperty("user.name"));
		return extentReport;
		
		

	}
	
	


}
