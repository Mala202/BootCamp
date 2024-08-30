package com.tutorialsninja.qa.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.Utilities.Utils;



public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public FileInputStream ip;
	
	public TestBase() throws Exception {
		
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsninja\\qa\\Config\\config.prop");		
		prop.load(ip);
		
		dataprop = new Properties();
		ip = new FileInputStream(System.getProperty("user.di") + "\\test\\java\\com\\tutorialsninja\\qa\\TestData\\dataProp.properties");
		dataprop.load(ip);
		
		
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-inforbars"));
			driver = new ChromeDriver(options);
			
		}else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("Browser Not matching");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.implicit_wait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.pageload_timeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.script_timeout));
		driver.get("https://tutorialsninja.com/demo");
		return driver;
	}

}
