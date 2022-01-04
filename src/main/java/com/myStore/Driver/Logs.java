package com.myStore.Driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

	// Initialize Log4j logs
	
	/*
	 * static{
	 * 
	 * //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	 * 
	 * //System.setProperty("current.date.time", dateFormat.format(new Date()));
	 * 
	 * String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
	 * Date()); System.setProperty("current", timeStamp); }
	 */

	public static Logger log = LogManager.getLogger(Logs.class.getName());

	// Need to create these methods, so that they can be called

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}
}
