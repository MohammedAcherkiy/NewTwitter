package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hepler.ClickIconHelper;
import Hepler.ComboBoxHelper;
import Hepler.StartWebDriver;

public class TwitterTest2 extends StartWebDriver {

	@Test
	public void VerifyThatTheFiveAuthorsOfTheFiveTweetsAreTheSame() {

		ComboBoxHelper.waitHelper(By.cssSelector(".cnList"));

		ClickIconHelper.ClickFifth(By.cssSelector(".kudos-count"));

		List<WebElement> allAuthorsName = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".username>a")));
		for (int i = 0; i < allAuthorsName.size(); i++) {
			Assert.assertTrue(allAuthorsName.get(i).getText()
					.equalsIgnoreCase(ComboBoxHelper.getText(By.xpath("//div[@class='cnoverlay-author']"))));
		}
	}
}
