package com.challenge.rest;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Before;
import org.junit.Test;
import com.challenge.buider.ProductBuilder;
import com.challenge.entity.Image;
import com.challenge.entity.Product;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;

import groovy.json.JsonException;

public class ProductRESTTest {

	private Product product;

	@Before
	public void setUp() {
		product = new ProductBuilder("Barbecue")
				.images(new Image("https://static.carrefourdigital.com.br/medias/sys_master/images/images/h66/he6/h00/h00/8944087203870.jpg"),
						new Image("https://static.carrefourdigital.com.br/medias/sys_master/images/images/h16/hc8/h00/h00/8944089759774.jpg"))
				.build();
		RestAssured.baseURI = "http://localhost:8080/challenge/";
	}

	@Test
	public void createProduct() throws Exception {
		insertProduct(product);
	}

	private String insertProduct(Product product) throws JsonException {
		String productJSON = new Gson().toJson(product);
		given().body(productJSON)
		.and().header("Content-Type", "application/json")
		.expect().statusCode(201)
		.when()
		.post("/product").andReturn().header("Location");

		return productJSON;
	}

}
