package cn.dw.model;

import java.util.Date;

// 此类是model  类->表    对象->记录  属性->字段  
public class Product {
	
//	public static void main(String[] args) {
//		// 类只有一份,类只定义的属性和方法
//		Product product=new Product();
//		System.out.println(product);
//		product.setName("xxx");;
//		System.out.println(product.getName());
//		
//		
//		Product product2=new Product();
//		System.out.println(product2);
//		product2.setName("yyy");;
//		System.out.println(product2.getName());
//	}
	
	

	private Integer id;
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", date=" + date
				+ "]";
	}

	private String name;
	private Double price;
	private String remark;
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
//		System.out.println(this);
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
