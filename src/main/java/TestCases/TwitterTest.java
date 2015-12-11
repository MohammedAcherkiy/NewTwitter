package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hepler.ClickIconHelper;
import Hepler.ComboBoxHelper;
import Hepler.StartWebDriver;
import Hepler.WindowHelper;

public class TwitterTest extends StartWebDriver {

	@Test
	public void test() {
		// wait for the web page to load
		ComboBoxHelper.waitHelper(By.cssSelector(".cnList"));
		ClickIconHelper.ClickFifth(By.cssSelector(".kudos-count"));
		// wait for element to be visible
		ComboBoxHelper.waitHelper(By.cssSelector(".icon-twitter.share-twitter"));
		// click on it
		ClickIconHelper.Click(By.cssSelector(".icon-twitter.share-twitter"));
		// switch to the child window
		WindowHelper.switchWindow(1);
		// wait for the elements on the child window to be visible
		ComboBoxHelper.waitHelper(By.id("status"));
		// Close the child window and switch to the parent Window
		WindowHelper.closeAndSwitchToParent();
		// Wait for the title to be visible
		ComboBoxHelper.waitHelper(By.xpath("//div[@class='cnoverlay-articletitle']"));
		// This test will fail because text 1 is not the same as text2
		Assert.assertEquals(ComboBoxHelper.getText(By.id("status")),
				ComboBoxHelper.getText(By.xpath("//div[@class='cnoverlay-articletitle']")));

	}
}