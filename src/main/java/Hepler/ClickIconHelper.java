package Hepler;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClickIconHelper extends StartWebDriver {

	public static void ClickFifth(By by) {

		List<WebElement> ele = new ArrayList<WebElement>(driver.findElements(by));
		// Finding items that have # of tweets >5
		for (int i = 0; i < ele.size(); i++) {
			if (ele.size() > 5) {
				// Click on the item that has # of tweets >
				ele.get(i).click();
				break;
			}
			System.out.println("Can't find item that has more than 5 tweets");
		}

	}

	public static void Click(By by) {

		WebElement ele = driver.findElement(by);
		ele.click();
	}

}
