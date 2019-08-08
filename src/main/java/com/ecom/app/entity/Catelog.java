package com.ecom.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Catelog implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catelogId;
	private String categoryName;
	@OneToMany
	private List<ProductEntity> product;
	public int getCatelogId() {
		return catelogId;
	}
	public void setCatelogId(int catelogId) {
		this.catelogId = catelogId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<ProductEntity> getProduct() {
		return product;
	}
	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}

	

}
