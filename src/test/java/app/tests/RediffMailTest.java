package app.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffMailTest extends BaseTest{
	
	@Test
	public void rediffTitleTest() {
		driver.get("https://www.rediff.com/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	}
	
	@Test
	public void rediffURLTest() {
		driver.get("https://www.rediff.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.rediff.com/");
	}
	

}
