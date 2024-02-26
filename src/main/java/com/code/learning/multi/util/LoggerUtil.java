package com.code.learning.multi.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    static Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

	public static void log(String message){
		logger.info("[{}] : {}",Thread.currentThread().getName() ,message);
	}
	
	public static void errorlog(Exception message){
		logger.error("[{}] : Exception Message -> {}",Thread.currentThread().getName() ,ExceptionUtils.getMessage(message));
	}
}
