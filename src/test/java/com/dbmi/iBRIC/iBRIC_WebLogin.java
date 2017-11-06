package com.dbmi.iBRIC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iBRIC_WebLogin {
  public WebDriver driver;
  public String baseUrl;
  public static WebElement element = null;
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette", "/usr/local/bin/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "http://dev.ibric.dbmi.pitt.edu/";
//    baseUrl = "https://act-network.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

//  @Test
  public void testIbricLogin() throws Exception {
    driver.get(baseUrl + "user/");
    driver.findElement(By.id("edit-name")).clear();
    driver.findElement(By.id("edit-name")).sendKeys("admin");
    driver.findElement(By.id("edit-pass")).clear();
    driver.findElement(By.id("edit-pass")).sendKeys("dbmi2016ibr");
    driver.findElement(By.id("edit-submit")).click();
    Thread.sleep(200);
//    driver.findElement(By.linkText("Login")).click();
  
  }
//  protected void navigateToActPage(WebDriver driver) {
//		driver.findElement(By.linkText("Overview")).click();
//		element = driver.findElement(By.linkText("Week 1: March 17, 2016"));
//		element.click();
//  }
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
//    driver.quit();
    }
  }
