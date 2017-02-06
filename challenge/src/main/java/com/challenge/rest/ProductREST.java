package com.challenge.rest;

import java.net.URI;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.challenge.dao.ImageDAO;
import com.challenge.dao.ProductDAO;
import com.challenge.entity.Image;
import com.challenge.entity.Product;
import com.google.gson.Gson;

@Path("/product")
public class ProductREST {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProduct(String content) {
		Product product = new Gson().fromJson(content, Product.class);
		new ProductDAO().create(product);
		URI uri = URI.create("/products/" + product.getId());
		return Response.created(uri).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(String content) {
		Product product = new Gson().fromJson(content, Product.class);
		Product updatedProduct = new ProductDAO().update(product);
		return Response.ok(updatedProduct).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteProduct(Product product) {
		product = new ProductDAO().getById(product.getId());
		new ProductDAO().delete(product);
		return Response.noContent().build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllProducts(@HeaderParam("images") boolean images,
			@HeaderParam("parent") boolean parentProduct) {
		if (images || parentProduct) {
			Set<Product> allProducts = new ProductDAO().getAllProductsWithImagesOrParentProduct(images, parentProduct);
			String productJSON = new Gson().toJson(allProducts);
			return Response.ok(productJSON).build();
		} else {
			Set<Product> allProducts = new ProductDAO().getAllProducts();
			String productJSON = new Gson().toJson(allProducts);
			return Response.ok(productJSON).build();
		}
	}

	@GET
	@Path("/{id}")
	public Response getProduct(@PathParam("id") Integer id, @HeaderParam("images") boolean images,
			@HeaderParam("parent") boolean parentProduct) {
		if (images || parentProduct) {
			Product product = new ProductDAO().getProductWithImagesOrParentProduct(id, images, parentProduct);
			String productJSON = new Gson().toJson(product);
			return Response.ok(productJSON).build();
		} else {
			Product product = new ProductDAO().getById(id);
			String productJSON = new Gson().toJson(product);
			return Response.ok(productJSON).build();
		}
	}

	@GET
	@Path("/child/{id}")
	public Response getChildProducts(@PathParam("id") Integer id) {
		Set<Product> products = new ProductDAO().getChildProducts(id);
		String productJSON = new Gson().toJson(products);
		return Response.ok(productJSON).build();
	}

	@GET
	@Path("/image/{id}")
	public Response getImagesFromProduct(@PathParam("id") Integer id) {
		Set<Image> images = new ImageDAO().getImagesForProductId(id);
		String imagesJSON = new Gson().toJson(images);
		return Response.ok(imagesJSON).build();
	}
}
