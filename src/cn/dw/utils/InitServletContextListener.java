package cn.dw.utils;

import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitServletContextListener implements ServletContextListener {
	
	// servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);
	private ApplicationContext context = null;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized..........");
		ServletContext application = event.getServletContext();
		// context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		context = WebApplicationContextUtils.getWebApplicationContext(application);
		// 从spring配置文件中获取定时器任务
		MyTimerTask timerTask = context.getBean("timerTask",MyTimerTask.class);
		timerTask.setApplication(application);
		// true则定义为守护线程
		new Timer(true).schedule(timerTask, 0, 1000 * 60 * 60);
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	
}
