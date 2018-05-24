package cn.dw.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// 此类并不需要配置 @RequestMapping,此类仅仅是用来存储共性代码
public class BaseController {

	// mvc中可以自动的把request session application注入
	@Resource // 不用添加名称,系统会自动根据类型注入
	protected HttpServletRequest request;
	@Resource
	protected HttpSession session;
	@Resource
	protected ServletContext application;
}
