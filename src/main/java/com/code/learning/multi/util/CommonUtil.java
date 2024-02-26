package com.code.learning.multi.util;

import static com.code.learning.multi.util.LoggerUtil.errorlog;
import static com.code.learning.multi.util.LoggerUtil.log;
import static java.lang.Thread.sleep;

import org.apache.commons.lang3.time.StopWatch;

public class CommonUtil {

    public static StopWatch stopWatch = new StopWatch();

    public static void delay(long delayMilliSeconds)  {
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            errorlog(e);
        }

    }

    public static String transForm(String s) {
        CommonUtil.delay(500);
        return s.toUpperCase();
    }

    public static void startTimer(){
        stopWatchReset();
        stopWatch.start();
    }

    public static void timeTaken(){
        stopWatch.stop();
        log("Total Time Taken : " +stopWatch.getTime());
    }

    public static void stopWatchReset(){
        stopWatch.reset();
    }

    public static  int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
