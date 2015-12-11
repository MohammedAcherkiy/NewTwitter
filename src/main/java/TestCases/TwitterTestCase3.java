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

public class TwitterTestCase3 extends StartWebDriver {

	@Test()
	public void VerifyTheFiveURLSareTheSameAsTheLinkOnTheItem() {

		ComboBoxHelper.waitHelper(By.cssSelector(".cnList"));

		ClickIconHelper.ClickFifth(By.cssSelector(".kudos-count"));

		List<WebElement> url = new ArrayList<WebElement>(driver.findElements(By.xpath("//span[@class='link'][1]")));
		for (int i = 0; i < url.size(); i++) {
			String x1 = url.get(0).getText();
			String x2 = url.get(1).getText();
			String x3 = url.get(2).getText();
			String x4 = url.get(3).getText();
			String x5 = url.get(4).getText();
			Assert.assertEquals(x1, x2);
			Assert.assertEquals(x2, x3);
			Assert.assertEquals(x3, x4);
			Assert.assertEquals(x4, x5);

		}

	}
}