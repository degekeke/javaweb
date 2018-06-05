package cn.dw.model;

import java.util.List;

public class Category {
	
	private Integer id;
	
	private String name;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", proList=" + proList + "]";
	}

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
