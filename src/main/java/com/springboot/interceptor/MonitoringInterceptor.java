package com.springboot.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MonitoringInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(MonitoringInterceptor.class);
	
    ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();

    //public Logger logger = LoggerFactory.getLogger(this.getClass());  

    public boolean preHandle(HttpServletRequest request,  
                             HttpServletResponse response,
                             Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch(handler.toString());
        stopWatch.start(handler.toString());
        stopWatchLocal.set(stopWatch);
        log.info("접근한 URL 경로 : " + getURLPath(request)); 
        log.info("요청 처리 시작 시각 : " + getCurrentTime());  
        return true;
    } 
    
    public void postHandle(HttpServletRequest arg0,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception { 
    	log.info("요청 처리 종료 시각 : " + getCurrentTime()); 
    }  
    
    public void afterCompletion(HttpServletRequest request,
                               HttpServletResponse response,
                               Object handler, 
                               Exception exception) throws Exception {  
        StopWatch stopWatch = stopWatchLocal.get();
        stopWatch.stop();
        log.info("요청 처리 소요 시간 : " + stopWatch.getTotalTimeMillis()+ " ms");  
        stopWatchLocal.set(null);
        log.info("==========================================");  
    }  
    
    private String getURLPath(HttpServletRequest request) {  
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath+queryString;
    } 
    
    private String getCurrentTime() {  
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }  
}