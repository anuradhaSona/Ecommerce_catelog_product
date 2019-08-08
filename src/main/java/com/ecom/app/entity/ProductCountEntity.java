package com.ecom.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductCountEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@OneToOne
	private ProductEntity product;

	private int count;

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public ProductEntity getProduct() {

		return product;

	}

	public void setProduct(ProductEntity product) {

		this.product = product;

	}

	public int getCount() {

		return count;

	}

	public void setCount(int count) {

		this.count = count;

	}

}
