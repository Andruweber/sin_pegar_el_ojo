package co.com.andruweber.log4jtest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ThrowableInformation;

public class LoggerHandler {
	
	//JavaDoc Log4j: http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/package-summary.html
	
	private static final String LINE_SEPATOR = "\n";
	
	public static final String FHIR_EVENTS_LOGGER = "fhir.events";
	public static final String LOG4J_TEST_SERVLET_LOGGER = Log4jTestServlet.class.getName();
	
	public static void trace(String loggerName, Object message) {
		trace(loggerName, message, null);
	}
	
	public static void trace(String loggerName, Object message, Throwable t) {
		log(Level.TRACE, loggerName, message, t);
	}
	
	public static void debug(String loggerName, Object message) {
		debug(loggerName, message, null);
	}
	
	public static void debug(String loggerName, Object message, Throwable t) {
		log(Level.DEBUG, loggerName, message, t);
	}
	
	public static void info(String loggerName, Object message) {
		info(loggerName, message, null);
	}
	
	public static void info(String loggerName, Object message, Throwable t) {
		log(Level.INFO, loggerName, message, t);
	}
	
	public static void warn(String loggerName, Object message) {
		warn(loggerName, message, null);
	}
	
	public static void warn(String loggerName, Object message, Throwable t) {
		log(Level.WARN, loggerName, message, t);
	}
	
	public static void error(String loggerName, Object message) {
		error(loggerName, message, null);
	}
	
	public static void error(String loggerName, Object message, Throwable t) {
		log(Level.ERROR, loggerName, message, t);
	}
	
	public static void fatal(String loggerName, Object message) {
		fatal(loggerName, message, null);
	}
	
	public static void fatal(String loggerName, Object message, Throwable t) {
		log(Level.FATAL, loggerName, message, t);
	}
	
	private static void log(Level level, String loggerName, Object message, Throwable t) {
		Logger logger = Logger.getLogger(loggerName);
		
		if(t == null) {
			logger.log(level, message);
		} else {
			logger.log(level, message, t);
		}
	}
	
	private static String[] getThrowableInformation(Throwable t) {
		ThrowableInformation throwableInformation;
		if(t != null) {
			throwableInformation = new ThrowableInformation(t);
			return throwableInformation.getThrowableStrRep();
		} else {
			return null;
		}
	}
	
	public static String getThrowableInformationAsString(Throwable t) {
		String[] throwableInformation;
		StringBuilder builder;
		
		throwableInformation = getThrowableInformation(t);
		
		if(throwableInformation != null) {
			builder = new StringBuilder();
			for(String informationLine : throwableInformation) {
				builder.append(LINE_SEPATOR);
			    builder.append(informationLine);
			    
			}
			builder.delete(0, LINE_SEPATOR.length());
			return builder.toString();
		} else {
			return null;
		}
	}
}
