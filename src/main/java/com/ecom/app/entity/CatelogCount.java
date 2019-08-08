package com.ecom.app.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CatelogCount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private Catelog catelog;

	private int count;

	public Catelog getCatelog() {

		return catelog;

	}

	public int getCount() {

		return count;

	}

	public int getId() {

		return id;

	}

	public void setCatelog(Catelog catelog) {

		this.catelog = catelog;

	}

	public void setCount(int count) {

		this.count = count;

	}

	public void setId(int id) {

		this.id = id;

	}

}
