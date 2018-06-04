package cn.dw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dw.model.Product;

// 接口主要是用来定义规范的,在MyBatis中,接口与某个mapper映射文件相对应
// 接口是声明,而mapper.xml文件是具体SQL实现,而且xml文件中namespace的值必须与当前接口全名相同
// 接口是不能new对象的,因此需要在spring配置文件中动态生成基于当前接口的实现类
public interface ProductDao {

	public int save(Product product);

	public int update(Product product);

	public int delete(int id);
	
	public Product getById(int id);
	// @Param("key") ===> 在xml中通过 #{key}来获取
	public List<Product> queryByName(@Param("name") String name, @Param("start") int start, @Param("end") int end);

}
