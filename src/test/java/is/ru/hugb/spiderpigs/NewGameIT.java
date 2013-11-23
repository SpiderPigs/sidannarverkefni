package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class NewGameIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://spiderpigs-staging.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testTestNewGame() throws Exception {
		selenium.open("/");
		selenium.click("x1y1");
		Thread.sleep(700);
		selenium.click("newGameBtn");
		Thread.sleep(700);
		assertEquals("", selenium.getTable("css=table.0.0"));
		assertEquals("", selenium.getTable("css=table.1.0"));
		assertEquals("", selenium.getTable("css=table.0.1"));
		assertEquals("", selenium.getTable("css=table.0.2"));
		assertEquals("", selenium.getTable("css=table.2.0"));
		assertEquals("", selenium.getTable("css=table.1.1"));
		assertEquals("", selenium.getTable("css=table.1.2"));
		assertEquals("", selenium.getTable("css=table.2.1"));
		assertEquals("", selenium.getTable("css=table.2.2"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
