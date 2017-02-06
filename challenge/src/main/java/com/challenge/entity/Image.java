package com.challenge.entity;

import java.net.URI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.google.gson.Gson;

@Entity
@Table(name = "IMAGE")
public class Image {

	@Id
	@Column(name = "ID_IMAGE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "URI", nullable = false)
	private URI uri;
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCT")
	private Product product;

	public Image() {
		super();
	}

	public Image(String uri) {
		this.uri = URI.create(uri);
	}

	public URI getUri() {
		return uri;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
