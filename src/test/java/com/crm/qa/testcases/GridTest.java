package com.crm.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest {

	@Parameters({ "browserName" })
	@Test
	public void mailTest(String browserName) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		if (browserName.equalsIgnoreCase("chrome")) {
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
		} else if (browserName.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		} else if (browserName.equals("IE")) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("internet explorer");
			cap.setPlatform(Platform.WINDOWS);
		}
		String hubURL = "http://192.168.0.19:4445/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), cap);
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin");
		driver.quit();
	}
}
