package cn.dw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.dw.model.Product;

// 通过spring来管理类与类之间的依赖(以前是通过代码的方式new,现在把所有依赖都配置在xml文件中,实现高内聚低耦合)
public class ProductDaoImpl {

	// 所有的Dao依赖Spring提供的JdbcTemplate,如果要赋值,必须要有Set方法(因为构造方法不灵活)
	private JdbcTemplate jdbcTemplate = null;

	// public Product getRow(ResultSet rs) {
	// rs.getString(name);
	// rs.getString(remark);
	// ........
	// }

	public Product getById(int id) {
		String sql = "select * from product where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class), id);
	}

	public List<Product> queryByName(String name, int page, int size) {
		String sql = "select * from product where name like ? limit ?,?;";
		// 表-->类,因此此处应该指定用来存储数据的类型
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class),
				new Object[] { "%" + name + "%", (page - 1) * size, size });
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("setJdbcTemplate()........");
		this.jdbcTemplate = jdbcTemplate;
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int delete(int id) {
		String sql = "delete from product where id=?";
		return jdbcTemplate.update(sql, id);
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		return jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

}
