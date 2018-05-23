package cn.dw.test;

import java.lang.reflect.Method;

import cn.dw.service.ProductServiceImpl;

// 采用反射的方法,模拟动态生成代理类
public class RefTest {

	// 通过反射来获取类的信息,并且获取类里面的方法,属性信息
	public static void main(String[] args) throws ClassNotFoundException {
		// 根据类全名,或者当前类的信息,获取类信息有三种方式
		Class clazz = Class.forName("cn.dw.service.ProductServiceImpl");
		Class clazz2 = ProductServiceImpl.class;
		// 通过对象获取类信息
		Class clazz3 = new ProductServiceImpl().getClass();
		System.out.println(clazz==clazz2 && clazz2 == clazz3);
		// clazz==> ProductServiceImpl.class
		Method[] methods = clazz.getMethods();
		for(Method temp:methods) {
			System.out.println(temp);
		}
	}
}














