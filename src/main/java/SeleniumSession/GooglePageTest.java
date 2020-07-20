package SeleniumSession;

public class GooglePageTest {

	public static void main(String[] args) {
		String browser = "chrome";
		
		BrowserUtil br = new BrowserUtil();
		br.launchBrowser(browser);
		br.launchURL("http://www.google.com");
		String title = br.getPageTitle();
		if(title.equalsIgnoreCase("google")) {
			System.out.println("Correct Title");
		}
		else {
			System.out.println("Incorrect Title");
		}
		String vUrl = br.getPageURL();
		if(vUrl.contains("google")) {
			System.out.println("Correct URL");
		}
		else {
			System.out.println("Incorrect URL");
		}
		br.launchURL("http://amazon.in");
		br.backBrowser();
		br.forwardBrowser();
		br.closeBrowser();
		

	}

}
