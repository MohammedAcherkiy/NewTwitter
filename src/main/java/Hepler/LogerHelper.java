package Hepler;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class LogerHelper {

	private static PatternLayout layout = null;
	private static ConsoleAppender console = null;
	private static RollingFileAppender rolling = null;
	private static Logger logger = null;
	private static Logger rootLogger = null;
	private static final String pattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p%c{1}:%L -[%M]  %m%n";
	private static boolean flag = false;

	private static void initLogger() {

		layout = new PatternLayout(pattern);

		// Console Appender
		console = new ConsoleAppender(layout);
		console.setName("STDOUT");
		console.setTarget("System.out");
		console.setThreshold(Level.INFO);
		console.activateOptions();

		// RollingFileAppender
		try {
			rolling = new RollingFileAppender(layout, "Logs/logs.log");
			rolling.setName("RfILE");
			rolling.setThreshold(Level.INFO);
			rolling.setMaxFileSize("25MB");
			rolling.setMaxBackupIndex(100);
			rolling.activateOptions();
		} catch (IOException e) {
			e.printStackTrace();
		}

		rootLogger = Logger.getRootLogger();
		rootLogger.addAppender(console);
		rootLogger.addAppender(rolling);
	}

	public static Logger getLogger(Class aclass) {

		if (!flag) {
			initLogger();
			flag = true;
			LogerHelper.logger = Logger.getLogger(aclass);
			return LogerHelper.logger;

		} else {
			LogerHelper.logger = Logger.getLogger(aclass);
			return LogerHelper.logger;
		}

	}

}
