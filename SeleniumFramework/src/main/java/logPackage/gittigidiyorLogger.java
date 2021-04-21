package logPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;


public class gittigidiyorLogger {
	
	static Logger logger = LogManager.getLogger(gittigidiyorLogger.class);
	
	public void log_info(String text) {
		logger.info(text);
	}
	
	public void log_trace(String text) {
		logger.trace(text);
	}
}