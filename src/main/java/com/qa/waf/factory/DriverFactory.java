package com.qa.waf.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;


import com.qa.waf.frameworkexceptions.FrameException;

public class DriverFactory {
	WebDriver driver;
	OptionsManager options;
	public static String highlightElement;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	//Properties prop = new Properties();

	public DriverFactory(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver init_driver(Properties prop) {
		String browser = prop.getProperty("browser");
		options=new OptionsManager(prop);
		highlightElement=prop.getProperty("highlight");
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver(options.getChromeOptions());
			tlDriver.set(new ChromeDriver(options.getChromeOptions()));
			System.out.println("Opening Chrome browser");
			break;
		case "edge":
			//driver = new EdgeDriver(options.getEdgeOptions());
			tlDriver.set(new EdgeDriver(options.getEdgeOptions()));
			System.out.println("Opening Edge browser");
			break;
		case "firefox":
			//driver = new FirefoxDriver(options.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(options.getFirefoxOptions()));
			System.out.println("Opening Firefox browser");
			break;
		default:
			System.out.println("Please enter a valid browser name.You have entered:" + browser);
			break;
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}
	
	public synchronized static WebDriver getDriver() {
		
		return tlDriver.get();
	}

	public Properties init_prop() {
		Properties prop = new Properties();
		FileInputStream ip = null;
		// mvn clean install -Denv="qa"
		String envName = System.getProperty("env");
		System.out.println("Running testcases on:"+envName);

		try {

			if (envName == null) {
				System.out.println("No environment specified.Hence running in default QA environment");
				ip = new FileInputStream("./src/main/resource/config/config.properties");

			}
			else {
				
				switch (envName.toLowerCase().trim()) {
				case "dev":	
					ip = new FileInputStream("./src/main/resource/config/devConfig.properties");
					break;
				case "stage":	
					ip = new FileInputStream("./src/main/resource/config/stageConfig.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/main/resource/config/prodConfig.properties");
					break;
				case "qa":
					
					ip = new FileInputStream("./src/main/resource/config/config.properties");
					break;	

				default:
					System.out.println("Plz pass the right environment.The given environment is"+envName);
					throw new FrameException("NOVALIDENVGIVEN");
					
				}
			
			}

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Running testcases in headless=:"+prop.getProperty("headless"));
		System.out.println("Running testcases in incognito=:"+prop.getProperty("incognito"));

		return prop;
		

	}
	
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	

}
