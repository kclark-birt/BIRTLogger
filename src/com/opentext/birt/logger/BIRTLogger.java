package com.opentext.birt.logger;

/** 
 * <h1>BIRTLogger</h1>
 * BIRTLogger is a simple example showing how to catch and log
 * BIRT script exceptions.
 * 
 * @author @author <a href="mailto:clark.kristopher@gmail.com">Kristopher Clark</a>
 * @version 1.0
 * @since 2015-04-14
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BIRTLogger {
	final private static Logger LOGGER = Logger.getLogger(BIRTLogger.class);

	private String reportName;
	private String methodName;
	
	/**
	 * BIRTLogger() is 1 of 2 constructors for this class.  This constructor
	 * allows for the methodName and reportName to be set.  This should match
	 * the report name you are debugging and the method in which your implementing
	 * this class.
	 * @param methodName
	 * @param reportName
	 */
	public BIRTLogger(String methodName, String reportName) {
		this.reportName = new String(reportName);
		this.methodName = new String(methodName);
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		PropertyConfigurator.configure(classLoader.getResource("log4j.properties"));
	}

	/**
	 * BIRTLogger() is 1 of 2 constructors for this class.  This constructor
	 * takes no parameters.  It excepts you to use the setters for reportName
	 * and methodName
	 * @return Nothing
	 */
	public BIRTLogger() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		PropertyConfigurator.configure(classLoader.getResource("log4j.properties"));		
	}

	/**
	 * setReportName will set the name of the report that is calling this class
	 * @param reportName
	 * @return Nothing
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * setMethodName will set the name of the method that is calling this class
	 * @param reportName
	 * @return Nothing
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	/**
	 * getReportName will return the value of reportName
	 * @return String
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * getMethodName will return the value of methodName
	 * @return String
	 */
	public String getMethodName() {
		return methodName;
	}
	
	/**
	 * Logs an exception from the BIRT script
	 * @param exception
	 */
	public void logError(String exception) {		
		LOGGER.error(reportName + " in " + methodName + "(): " + exception);
	}

	/**
	 * Logs a wanring from the BIRT script
	 * @param warning
	 */
	public void logWarning(String warning) {
		LOGGER.warn(reportName + " in " + methodName + "(): " + warning);
	}

	/**
	 * Logs info from the BIRT script
	 * @param info
	 */
	public void logInfo(String info) {
		LOGGER.info(reportName + " in " + methodName + "(): " + info);
	}
	
	/**
	 * Logs a debug statement from the BIRT script
	 * @param debug
	 */
	public void logDebug(String debug) {
		LOGGER.debug(reportName + " in " + methodName + "(): " + debug);
	}
	
	/**
	 * Logs a fatal exception from the BIRT script
	 * @param fatal
	 */
	public void logFatal(String fatal) {
		LOGGER.fatal(reportName + " in " + methodName + "(): " + fatal);
	}
}
