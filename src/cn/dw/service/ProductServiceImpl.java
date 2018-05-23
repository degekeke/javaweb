package cn.dw.service;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

// 项目的业务逻辑实现,都被封装在Service层,此层不能有访问数据库的代码,如果需要进行数据库操作,则应该Service-->Dao
public class ProductServiceImpl {
	// spring通过xml的配置取代了硬编码,依赖都要交给Spring管理
	private ProductDaoImpl productDao = null;
	// 通过set注入
	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}
	
	// 此数据会从显示层传入
	public int save(Product product) {
		// 目前service并没有复杂的业务逻辑,因此仅仅调用数据访问层
		int result = productDao.save(product);
		// 模拟事务操作: 希望当前逻辑多个操作是一个整体(只要有异常则操作回滚)
//		Integer.parseInt("xxxx");
		return result;
	}
}


















