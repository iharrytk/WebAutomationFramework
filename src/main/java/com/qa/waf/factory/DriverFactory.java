package com.qa.waf.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	WebDriver driver;
	Properties prop=new Properties();
	
	public DriverFactory(WebDriver driver) {
		this.driver=driver;
	}
	

	public WebDriver init_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Please enter a valid browser name.You have entered:"+browser);
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	public Properties init_prop() {
		
		try {
			FileInputStream ip=new FileInputStream("./src/main/resource/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} 
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;

	}

}
