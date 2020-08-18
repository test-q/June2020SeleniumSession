package app.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
	
	@Test
	public void googleTitleTest() {
		//long id = Thread.currentThread().getId();
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void googleURLTest() {
		//long id = Thread.currentThread().getId();
		driver.get("https://www.google.com/");
		String url = driver.getCurrentUrl();
		System.out.println("URL: " + url);
		Assert.assertEquals(url, "https://www.google.com/");
	}
	
}
