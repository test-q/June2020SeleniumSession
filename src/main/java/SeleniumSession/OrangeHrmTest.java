package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHrmTest {


	public static void main(String[] args) throws InterruptedException {
		String browserName = "chrome";
		
		//Locators
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName  = By.name("LastName");
		By email     = By.name("Email");
		By jobTitle	 = By.id("Form_submitForm_JobTitle");
		By comName 	 = By.name("CompanyName");
		By phone 	 = By.name("Contact");
		By text 	 = By.linkText("Privacy Policy");
		//Drop down box
		By employees = By.id("Form_submitForm_NoOfEmployees");
		By industry = By.id("Form_submitForm_Industry");
		By country  = By.id("Form_submitForm_Country");
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser(browserName);
		br.getMaximize();
		br.launchURL("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		Thread.sleep(5000);
		
		String pageTitle = br.getPageTitle();
		if(pageTitle.contains("Human Resource Management")) {
			System.out.println(pageTitle + " : Page Title is Correct.");
		}
		else {
			System.out.println(pageTitle + " : Page Title is Incorrect.");
		}
		System.out.println("URL: " + br.getPageURL());
		
		
		ElementUtils eu = new ElementUtils(driver);
		eu.doSendKeys(firstName, "Rupali");
		eu.doSendKeys(lastName, "Gurav");
		eu.doSendKeys(email, "rupali@gmail.com");
		eu.doSendKeys(jobTitle, "Sr. Test Eng");
		eu.getDropDownByIndex(employees, 5);
		eu.doSendKeys(comName, "UBS");
		eu.getDropDownByValue(industry, "Government-Local");
		eu.doSendKeys(phone, "02225426008");
		eu.getDropDownByVisibleText(country, "India");
		
		System.out.println(eu.getDropdownOptionsCount(country));
		eu.getDropdownOptionsValue(country);
		eu.getDropdownOptionsText(country);
		
		String pageText = eu.doGetText(text);
		System.out.println("Text is : " + pageText);
		if(eu.doIsDisplayed(text)== true) {
			System.out.println("Text is visible");
		}
		else {
			System.out.println("Text is not visible.");
		}
		
		
		
		driver.close();
		

	}

}