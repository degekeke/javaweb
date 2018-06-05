package cn.dw.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.model.Category;
import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

public class CategoryDaoImplTest {

	// static说明当前属性是类属性,只有一份,静态方法只能操作静态属性
	private static CategoryDao categoryDao = null;
	private static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass.....");
		context = new ClassPathXmlApplicationContext("spring-public.xml");
		// categoryDao: 根据包扫描自动生成
		categoryDao = context.getBean("categoryDao", CategoryDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass.....");
		categoryDao = null;
	}

	@Test
	public void testQueryByName() {
		// "%%":代表查询所有记录
		List<Category> catList = categoryDao.queryByName("%%");
		for (Category category : catList) {
			System.out.println("当前类别信息:" + category);
			for(Product temp:category.getProList()) {
				System.out.println("当前类别的商品信息:" + temp);
			}
		}
	}

	//
	@Test
	public void testGetById() {
		// "%%":代表查询所有记录
		System.out.println(categoryDao.getById(2));
	}
}










