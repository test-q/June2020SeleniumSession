package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoTest {
	public static WebDriver driver;

	public static void main(String[] args) {
		ArrayList<String> scoreBoard = new ArrayList<String>();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(
				"https://www.espncricinfo.com/series/19495/scorecard/1198241/england-vs-pakistan-1st-test-england-v-pakistan-2020");
	
		System.out.println(getScorecardInfo("RJ Burns"));
		System.out.println(getScorecardInfo("DP Sibley"));
		System.out.println(getScorecardInfo("JE Root"));
		System.out.println(getScorecardInfo("BA Stokes"));
		//Below both players are not out hence class value change for them
		//System.out.println(getScorecardInfo("OJ Pope"));
		//System.out.println(getScorecardInfo("JC Buttler"));
		//a[text()='DP Sibley']//parent::td[@class='batsman-cell text-truncate out']//following-sibling::td
	}

	public static ArrayList<String> getScorecardInfo(String playerName) {
		System.out.println("Score Board for: " +playerName);
		By player = By.xpath("//a[text()='"+playerName+"']//parent::td[@class='batsman-cell text-truncate out']//following-sibling::td");
		ArrayList<String> playerInfoList = new ArrayList<String>();
		ArrayList<String> scoreBoard = new ArrayList<String>();
		//String score = "";

		List<WebElement> webEleList = driver.findElements(player);
		for (WebElement ele : webEleList) {
			String value = ele.getText();
			playerInfoList.add(value);
		}
		//System.out.println(playerInfoList.size());
		for (int i = 8; i < playerInfoList.size(); i++) {
			String value = playerInfoList.get(i);
			if (!value.isEmpty()) {
				scoreBoard.add(value);
			}
		}
		return scoreBoard;
	}
	
	public static String getWicketkeeperName(String batsmanName) {
		By batsman = By.xpath("//a[text()='" + batsmanName + "']//parent::td//following-sibling::td//span");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(batsman)).getText();
	}
	
	
}
