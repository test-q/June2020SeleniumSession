package app.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreshWorksTest extends BaseTest{

	@Test
	public void freshWorkTitleTest() {
		driver.get("https://www.freshworks.com/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "A fresh approach to customer engagement");
	}
	
	@Test
	public void freshWorkURLTest() {
		driver.get("https://www.freshworks.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.freshworks.com/");
	}

}
