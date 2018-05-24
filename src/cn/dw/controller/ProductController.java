package cn.dw.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

// 此类用于取代MVC的Servlet,主要用来接收前端的请求,并且把数据交给Service
@RequestMapping(value="/product")  // @RequestMapping:属于Spring框架.也称为自定义注解,用来定义访问当前Controller地址
@Controller  // @Controller代表当前类交给Spring管理,注意不用添加名称,因此Controller是用过Mapping访问
public class ProductController {
	// MVC推荐使用注解,因此此处采用注解取代xml
	// Resource回到配置文件中去查找ID为指定名称的Bean
	@Resource(name="productService")
	private ProductServiceImpl productService;

	
	// mvc中各种不同的方法取代了doGet/doPost
	// 如果前台页面的name属性,与参数的属性一致则数据会自动注入
	@RequestMapping(value="/save")
	public void save(Product product) {
		// 1: 此处应该调用ProductService.save(),以前没有jsp页面,测试数据都是通过main方法
		productService.save(product);
		// 2: 跳转到查询页面
	}
	
//	public String queryByName(Product product) {
//		// 1: 此处应该调用ProductService.save();
//		
//		// 2: 跳转到查询页面
//	}
	

}









