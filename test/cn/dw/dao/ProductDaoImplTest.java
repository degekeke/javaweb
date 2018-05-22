package cn.dw.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.model.Product;

public class ProductDaoImplTest {

	// static说明当前属性是类属性,只有一份,静态方法只能操作静态属性
	private static ProductDaoImpl daoImpl = null;
	private static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass.....");
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
//		daoImpl = (ProductDaoImpl)context.getBean("productDao");
		daoImpl = context.getBean("productDao", ProductDaoImpl.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass.....");
		daoImpl = null;
	}

	@Test
	public void testQueryByName() {
		// "%%":代表查询所有记录
		List<Product> proList = daoImpl.queryByName("",2,3);
		for (Product temp : proList) {
			System.out.println(temp + "=======>" + temp.toString());
		}
	}
//	
	@Test
	public void testGetById() {
		// "%%":代表查询所有记录
		System.out.println(daoImpl.getById(4));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		System.out.println("save........");
		Product product = new Product();
		product.setName("xyz~~~~~");
		product.setPrice(3.14);
		product.setRemark("remark");
		daoImpl.save(product);
	}

}
