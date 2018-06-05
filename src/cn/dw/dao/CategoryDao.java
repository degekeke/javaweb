package cn.dw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dw.model.Category;
import cn.dw.model.Product;

public interface CategoryDao {

	public Category getById(int id);
	
	public List<Category> queryByName(String name);

}
