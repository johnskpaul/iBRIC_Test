package com.dbmi.iBRIC;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class iBRIC_AboutUs extends iBRIC_WebLogin {
  @Test
  public void testIbricAbouUs() throws Exception {
	  testIbricLogin();
	  driver.findElement(By.xpath(".//*[@title='Description of the Cosbbi Project']")).click();
	  Thread.sleep(2000);
	  List<WebElement> linksList = clickableLinks(driver);
		for (WebElement link : linksList) {
			String href = link.getAttribute("href");
			try {
				System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement e : elements) {
			if (e.getAttribute("href") != null){
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		// http://download.java.net/jdk7/archive/b123/docs/api/java/net/HttpURLConnection.html#getResponseMessage%28%29
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch (Exception e) {
			return e.getMessage();
		}
}

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
