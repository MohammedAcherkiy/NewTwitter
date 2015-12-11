package Hepler;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComboBoxHelper extends StartWebDriver {
	static final int WAIT_TIME = 30;

	public static void waitHelper(By by) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public static String getText(By by) {

		return driver.findElement(by).getText();
	}

	public static String getUrl() {

		return driver.getCurrentUrl();
	}
}
