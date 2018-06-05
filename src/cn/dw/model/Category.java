package cn.dw.model;

import java.util.List;

public class Category {
	
	private Integer id;
	
	private String name;
	
	// category -> product ==>  one-to-many
	
	private List<Product> proList;
	
	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
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
		this.name = name;
	}

}
