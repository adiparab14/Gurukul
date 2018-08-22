package log;

import org.apache.log4j.Logger;

public class Log {

	// get a logger instance
	public static Logger Log = Logger.getLogger(Log.class);

	public static void startTestCase(String sTestCaseName) {
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 Start Testcase " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D- " + sTestCaseName + "             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
	}

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}
}