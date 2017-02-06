package com.challenge.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "ID_PRODUCT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "NAME", length = 45, nullable = false)
	private String name;
	@OneToMany(cascade = CascadeType.ALL , mappedBy="product")
	private Set<Image> images;
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;

	public Product() {
		super();
	}

	public Product(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<Image> getImages() {
		return images;
	}

	public Product getParentProduct() {
		return parentProduct;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public void addToImage(Image image) {
		image.setProduct(this);
		this.images.add(image);
	}

	public void setParent(Product parent) {
		this.parentProduct = parent;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

}
