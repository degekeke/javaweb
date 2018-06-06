package cn.dw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dw.model.Category;
import cn.dw.model.Product;
import cn.dw.service.CategoryServiceImpl;

@RequestMapping(value="/category") 
public class CategoryController extends BaseController {
	
	@Resource(name="categoryService")
	private CategoryServiceImpl categoryService;
	
	// mvc中各种不同的方法取代了doGet/doPost
	// 如果前台页面的name属性,与参数的属性一致则数据会自动注入
	@RequestMapping(value="/queryAll")
	@ResponseBody   // 此注解定义返回的是json格式
 	public Object queryAll(Category category) {
		System.out.println(category);
		List<Category> catList = categoryService.queryByName("%%");
		// 如果是ajax请求,则返回的应该是字符串(json就是有格式的字符串),而非页面
		// "[{},{},{},{},{}]"
		return catList;  // @ResponseBody 会把对象自动转化json格式
	}
}









