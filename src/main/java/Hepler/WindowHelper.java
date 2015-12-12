package Hepler;

import java.util.ArrayList;
import java.util.List;

public class WindowHelper extends StartWebDriver {

	public static void switchWindow(int index) {
		try {
			List<String> win = new ArrayList<String>(driver.getWindowHandles());
			for (int i = 0; i < win.size(); i++) {
				driver.switchTo().window(win.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid window index " + index);

		}

	}

	public static void closeAndSwitchToParent() {
		List<String> win = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 1; i < win.size(); i++) {
			driver.close();
		}
		driver.switchTo().window(win.get(0));

	}

}
