package cn.dw.service;

import java.util.List;

import cn.dw.dao.CategoryDao;
import cn.dw.model.Category;

// 项目的业务逻辑实现,都被封装在Service层,此层不能有访问数据库的代码,如果需要进行数据库操作,则应该Service-->Dao
public class CategoryServiceImpl {
	
	public CategoryServiceImpl() {
		System.out.println("CategoryServiceImpl()..............");
	}
	
	// spring通过xml的配置取代了硬编码,依赖都要交给Spring管理
	private CategoryDao categoryDao = null;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public List<Category> queryByName(String name){
		return categoryDao.queryByName(name);
	}
}
