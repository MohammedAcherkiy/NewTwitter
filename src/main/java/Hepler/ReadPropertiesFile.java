package Hepler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	protected static InputStream input;
	protected static Properties prop;

	public ReadPropertiesFile() {
		try {
			input = ReadPropertiesFile.class.getClassLoader().getResourceAsStream("Resources/config.properties");
			prop = new Properties();
			prop.load(input);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getUrl() {
		if (prop.getProperty("url") == null)
			return "";
		return prop.getProperty("url");

	}

	public String getBrowser() {
		if (prop.getProperty("browser") == null)
			return null;

		return prop.getProperty("browser");
	}

}
