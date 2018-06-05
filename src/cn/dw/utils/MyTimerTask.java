package cn.dw.utils;

import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.dw.model.Category;
import cn.dw.service.CategoryServiceImpl;

// 自定义的定时器,主要实现在项目启动时定时加载功能
public class MyTimerTask extends TimerTask {

	private ServletContext application;
	
	private CategoryServiceImpl categoryService;
	
	public void setCategoryService(CategoryServiceImpl categoryService) {
		this.categoryService = categoryService;
	}

//	public MyTimerTask(ServletContext application) {
//		this.application = application;
//	}
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		System.out.println("run....................");
		List<Category> categoryList = categoryService.queryByName("%%");
		application.setAttribute("categoryList", categoryList);
	}

}
