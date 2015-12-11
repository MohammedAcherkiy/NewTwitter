package Hepler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class StartWebDriver {

	public static WebDriver driver = null;

	@BeforeMethod
	public void SetUp() {

		try {
			ReadPropertiesFile file = new ReadPropertiesFile();

			if ("firefox".equalsIgnoreCase(file.getBrowser())) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			} else if ("chrome".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.chrome.driver", "/Users/mohammedacherkiy/downloads/chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			} else if ("safari".equalsIgnoreCase(file.getBrowser())) {
				driver = new SafariDriver();
				driver.manage().window().maximize();
			} else {

				driver = new HtmlUnitDriver();

			}

			driver.get(file.getUrl());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void TearDown() {

		driver.quit();

	}

}
