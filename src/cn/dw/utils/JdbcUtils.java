package cn.dw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 此类称为工具类,主要完成与数据的连接操作与资源释放(建议构造方法私有)
public class JdbcUtils {
	// 在外部不能够new对象,以后通过类来调用方法,因此方法设置static
	private JdbcUtils() {
	}

	// 静态块,在类加载的时候执行且执行一次
	static {
		// 一般驱动,文件资源的加载都会在此静态块完成
		// 通过类全名加载驱动信息.此行代码就可以实现数据库驱动的加载
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			// 异常不能直接打印,而是要向上抛出
			throw new RuntimeException(e);
		}
	}

	// 编写一个方法实现数据库的连接
	public static Connection getConnection() {
		// 连接数据库需要配置：url username password (设置自己的数据库名称,账号和密码)
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
    // shift + alt + A
	public static void main(String[] args) {
		// 1：加载配置文件  2：通过getBean获取对象
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		System.out.println(context.getBean("dataSource"));
	}
}
