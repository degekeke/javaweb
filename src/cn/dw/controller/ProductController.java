package cn.dw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

// 此类用于取代MVC的Servlet,主要用来接收前端的请求,并且把数据交给Service
@RequestMapping(value="/product")  // @RequestMapping:属于Spring框架.也称为自定义注解,用来定义访问当前Controller地址
public class ProductController extends BaseController {
	
	// MVC推荐使用注解,因此此处采用注解取代xml
	// Resource回到配置文件中去查找ID为指定名称的Bean
	@Resource(name="productService")
	private ProductServiceImpl productService;
	
	// mvc中各种不同的方法取代了doGet/doPost
	// 如果前台页面的name属性,与参数的属性一致则数据会自动注入
	@RequestMapping(value="/save")
	public String save(Product product) {
		// 1: 此处应该调用ProductService.save(),以前没有jsp页面,测试数据都是通过main方法
		productService.save(product);
		// 2: 跳转到查询页面(web项目中,所有的资源都要从工程名开始访问,如果未添加则说明系统自带了工程名)
		return "redirect:/query.jsp";
	}
	// Servlet ===> JSP
	@RequestMapping(value="/queryByName")
	public String queryByName(String keyword) {
		// 1: 此处应该调用ProductService.save();
		List<Product> proList = productService.queryByName("%" + keyword + "%", 1, 100);
		request.setAttribute("proList", proList);
		// 2: 跳转到查询页面,如果未添加则说明系统自带了工程名
		// 如果当前对象与目标页面(jsp) 存在着request数据共享,则只能用转发
		return "forward:/query.jsp";
	}
	

}









