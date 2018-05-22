package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtils;

// 操作数据库的前提创建一个Model
// ProductDaoImpl extends BaseDaoImpl<Product>:当ProductDaoImpl继承BaseDaoImpl时 T代表的就是Product类型
// 如果继承抽象类型,则必须实现抽象类的抽象方法
public class ProductDaoImpl extends BaseDaoImpl<Product> {

	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		return super.getById(sql, id);
	}

	@Override
	protected Product getRow(ResultSet rs) throws SQLException {
		// 数据库一行记录,对应Java中对象
		Product product = new Product();
		// 通过列的名称,获取当前行的指定列信息
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		product.setId(rs.getInt("id"));
		product.setDate(rs.getDate("date"));
		return product;
	}

	// ctrl + shift + o:导入导出包
	public List<Product> queryByName(String name) {
		// 声明一个集合,用来存储查询到数据库的记录
		List<Product> proList = new ArrayList<Product>();
		String sql = "select * from product where name like ?";
		// 1:获取数据库的连接
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			// 2:配置参数,并且执行SQL
			pre = conn.prepareStatement(sql);
			// 模糊查询需要设置%%
			pre.setString(1, "%" + name + "%");
			// 3: 通过查询返回结果集 (数据就存储在rs中)
			rs = pre.executeQuery();
			// 默认光标是在第一行之前,需要调用next
			while (rs.next()) {// 光标移动到下一行,如果当前行有记录,返回为true
				// 数据库一行记录,对应Java中对象
				Product product = new Product();
				// 通过列的名称,获取当前行的指定列信息
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setId(rs.getInt("id"));
				product.setDate(rs.getDate("date"));
				// 上面的代码实现了把当前行的记录存储到Java中的对象中
				// 只需要把当前对象,存储到集合中,并返回即可
				proList.add(product);
			}
			return proList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				pre.close(); // 无论pre是否关闭成功,conn都需要关闭
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int delete(int id) {
		String sql = "delete from product where id=?";
		return super.executeUpdate(sql, new Object[] { id });
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		return super.executeUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		return super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

}
