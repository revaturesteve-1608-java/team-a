package com.gc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
	
	/**
	 * Main method for test automation
	 * @param args String array
	 */
	public static void main(String[] args) {
		SeleniumTest test = new SeleniumTest();
		test.openFirefox();
	}
	
	/**
	 * Automated test using FireFox browser
	 */
	public void openFirefox() {
		// Load driver
		File file = new File("C:/selenium-java-3.0.1/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver",  file.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ec2-52-55-211-16.compute-1.amazonaws.com:8080/majortomdev/#/");
		
		// Load properties file
		Properties properties = new Properties();
		
		// Try with resources -- auto-closes FIS
		try (FileInputStream in = new FileInputStream("src/test/resources/xpath.properties")){
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		testSetSeat(driver, properties);
		testSwapSeat(driver, properties);
		//testChangeFlight(driver, properties);
		
		//driver.quit();
	}
	
	/**
	 * Sleep
	 * @param ms Milliseconds
	 */
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Enters a ticket and reserves a seat
	 * @param driver The web driver
	 * @param properties Properties with access to xpath.properties
	 */
	public void testSetSeat(WebDriver driver, Properties properties) {
		// Login with a ticket		
		driver.findElement(By.id("TicketIDBox")).sendKeys("1000000007");
		
		// Click the login button
		driver.findElement(By.xpath(properties.getProperty("receiptButton"))).click();
		
		// Wait for it to login + load seats
		sleep(8000);
		
		// Click a seat
		driver.findElement(By.id("seat75")).click();
		
		// Reserve the seat
		driver.findElement(By.id("ReserveButton")).click();
		
		// Wait for it to reserve the seat
		sleep(10000);
	}
	
	/**
	 * Logins as employee and swaps seats
	 * @param driver The web driver
	 * @param properties Properties with access to xpath.properties
	 */
	public void testSwapSeat(WebDriver driver, Properties properties) {
		// Login as an employee
		driver.findElement(By.xpath(properties.getProperty("receiptLink"))).click();
		
		// Enter employee login info		
		driver.findElement(By.id("username")).sendKeys("atlasm");
		driver.findElement(By.id("password")).sendKeys("password");
		
		// Click the login button
		driver.findElement(By.xpath(properties.getProperty("receiptButtonEmp"))).click();
		
		// Wait for it to login + load seats
		sleep(3000);
		
		// Click a seat
		driver.findElement(By.id("seat75")).click();
		// Swap the seat
		driver.findElement(By.xpath(properties.getProperty("swap"))).click();
		// Click a seat
		driver.findElement(By.id("seat69")).click();
		// Swap the seat
		driver.findElement(By.xpath(properties.getProperty("completeSwap"))).click();
		
		sleep(3000);
	}
	
	/**
	 * Changes flight while the employee is logged in
	 * @param driver The web driver
	 * @param properties Properties with access to xpath.properties
	 */
	public void testChangeFlight(WebDriver driver, Properties properties) {
		// Click drop-down
		driver.findElement(By.id("flightSelect")).click();
		
		// Click flight 3283
		//driver.findElement(By.xpath(properties.getProperty("flightOption"))).click();
		//Select select = new Select(driver.findElement(By.id("flightSelect")));
		//select.deselectAll();
		//select.selectByIndex(3);
		
		sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("flightOption"))).click();
		
		//Select select = new Select(driver.findElement(By.id("flightSelect")));
		//select.deselectAll();
		//select.selectByValue("object:23");
	}
}
