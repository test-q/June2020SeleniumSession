package SeleniumSession;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenURL {
	public static String domainUrl = "https://in.yahoo.com/";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://in.yahoo.com/");
		Thread.sleep(5000);
		doCheckBrokenLink(domainUrl);
	}
	
	
	public static String doCheckBrokenLink(String domainUrl) {
		HttpURLConnection httpConnect = null;
		int respCode = 200;
		String url = "";
		String urlName = "";
		String deadUrl = "";
		
		List<WebElement> eleList = driver.findElements(By.tagName("a"));
		System.out.println("No of Links On Page: " + eleList.size());
		for(WebElement ele : eleList) {
			url = ele.getAttribute("href");
			urlName = ele.getText();
			//System.out.println(urlName + " : " + url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				System.out.println("URL Name: " + urlName + " ==> " + url);
				deadUrl = url;
				continue;
			}
			if(! url.startsWith(domainUrl)) {
				System.out.println("URL belongs to another domain, skipping it.");
				System.out.println("URL Name: " + urlName + " ==> " + url);
				deadUrl = url;
				continue;
			}
			try {
				httpConnect = (HttpURLConnection) (new URL(url).openConnection());
				httpConnect.setRequestMethod("HEAD");
				httpConnect.connect();
				respCode = httpConnect.getResponseCode();
				if (respCode >= 400) {
					System.out.println("URL Name: " + urlName + " ==> " + url + " :: Broken Link");
				} else {
					//System.out.println(urlName + " : " + url + " ::  Valid Link");
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return deadUrl;
	}


}
