package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hepler.ClickIconHelper;
import Hepler.ComboBoxHelper;
import Hepler.StartWebDriver;
import Hepler.WindowHelper;

public class TwitterTestCase4 extends StartWebDriver {

	@Test
	public void VerifyTheUrls() {

		ComboBoxHelper.waitHelper(By.cssSelector(".cnList"));
		ClickIconHelper.ClickFifth(By.cssSelector(".kudos-count"));
		// Clicking on the link and handling the new window
		ClickIconHelper.Click((By.cssSelector(".link>a")));
		// Switching to the child window
		WindowHelper.switchWindow(1);
		// getting the url using the comboBoxClass
		String url1 = ComboBoxHelper.getUrl();
		// Closing the child window and switching the parent window
		WindowHelper.closeAndSwitchToParent();
		// Clicking on the link on the original article and handling the new
		// window
		ClickIconHelper.Click(By.cssSelector(".cnClickSource"));
		WindowHelper.switchWindow(1);
		// get the url using the comboBoxClass
		String url2 = ComboBoxHelper.getUrl();
		Assert.assertEquals(url1, url2);

	}
}
