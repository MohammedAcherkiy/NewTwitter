package TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hepler.ClickIconHelper;
import Hepler.ComboBoxHelper;
import Hepler.LogerHelper;
import Hepler.StartWebDriver;
import Hepler.WindowHelper;

public class TwitterTest extends StartWebDriver {
	private static final Logger logger = LogerHelper.getLogger(TwitterTest.class);

	@Test
	public void test() {
		// wait for the web page to load
		ComboBoxHelper.waitHelper(By.cssSelector(".cnList"));
		logger.info("Page loaded");
		ClickIconHelper.ClickFifth(By.cssSelector(".kudos-count"));
		logger.info("Clicked  on  twitter logo' that has more than 5 tweets ");
		// wait for element to be visible
		ComboBoxHelper.waitHelper(By.cssSelector(".icon-twitter.share-twitter"));
		logger.info("waited for the webElement(share-twiter) to be visible");
		// click on it
		ClickIconHelper.Click(By.cssSelector(".icon-twitter.share-twitter"));
		logger.info("clicked on  share-twiter'");
		// switch to the child window
		WindowHelper.switchWindow(1);
		logger.info("switched to child window");
		// wait for the elements on the child window to be visible
		ComboBoxHelper.waitHelper(By.id("status"));
		logger.info("element 'status' in the child window is visible");
		String text = ComboBoxHelper.getText(By.id("status"));
		logger.info("stored the textArea content in a String variable='text'");
		// Close the child windows and switch to the parent Window
		WindowHelper.closeAndSwitchToParent();
		logger.info("Closed the child windows and switched to  parent window");
		// Wait for the title to be visible
		ComboBoxHelper.waitHelper(By.xpath("//div[@class='cnoverlay-articletitle']"));
		// This test will fail because text 1 is not the same as text2
		Assert.assertEquals(text, ComboBoxHelper.getText(By.xpath("//div[@class='cnoverlay-articletitle']")));

		logger.error(
				"Used assertEquals to check that the text in the textArea(childwindow) is the same as the text under the image(mainPage)");

	}
}