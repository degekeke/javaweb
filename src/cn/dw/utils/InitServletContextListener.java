package cn.dw.utils;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.dw.model.Category;
import cn.dw.service.CategoryServiceImpl;

public class InitServletContextListener implements ServletContextListener {
	
	private CategoryServiceImpl categoryService = null;
	// spring的配置文件加载,而且存储application内置对象中
	// servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);
	private ApplicationContext context = null;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized..........");
		ServletContext application = event.getServletContext();
		// context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		context = WebApplicationContextUtils.getWebApplicationContext(application);
		categoryService = context.getBean("categoryService",CategoryServiceImpl.class);
		System.out.println("app:" + application);
		// 启动时需要获取所有的类别信息.并且把它存储在application
		List<Category> categoryList = categoryService.queryByName("%%");
		System.out.println(categoryList.size());  // 2
		application.setAttribute("categoryList", categoryList);
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	
}
