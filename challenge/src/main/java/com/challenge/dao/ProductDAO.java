package com.challenge.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.challenge.entity.Product;

public class ProductDAO {

	private EntityManager em = EntityManagerDAO.getInstance();

	public void create(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
	}

	public Product update(Product product) {
		em.getTransaction().begin();
		Product newProduct = em.merge(product);
		em.getTransaction().commit();
		return newProduct;
	}

	public void delete(Product product) {
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
	}

	public Product getById(Integer id) {
		return em.find(Product.class, id);
	}

	public Set<Product> getAllProducts() {
		return new HashSet<>(em.createQuery("select p from Product p", Product.class).getResultList());
	}

	public Product getProductWithImagesOrParentProduct(Integer id, boolean images, boolean parentProduct) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
		Root<Product> root = criteria.from(Product.class);
		if (images) {
			root.fetch("images", JoinType.LEFT);
		}
		if (parentProduct) {
			Fetch<Object, Object> joinParent = root.fetch("parentProduct", JoinType.LEFT);
			joinParent.fetch("images", JoinType.LEFT);
		}
		criteria.where(builder.equal(root.get("id"), id));
		return em.createQuery(criteria).getSingleResult();
	}

	public Set<Product> getAllProductsWithImagesOrParentProduct(boolean images, boolean parentProduct) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
		Root<Product> root = criteria.from(Product.class);
		if (images) {
			root.fetch("images", JoinType.LEFT);
		}
		if (parentProduct) {
			Fetch<Object, Object> joinParent = root.fetch("parentProduct", JoinType.LEFT);
			joinParent.fetch("images", JoinType.LEFT);
		}
		return new HashSet<>(em.createQuery(criteria).getResultList());
	}

	public Set<Product> getChildProducts(Integer id) {
		return new HashSet<>(em.createQuery("select p from Product p where p.parentProduct.id = :id", Product.class)
				.setParameter("id", id).getResultList());
	}
}
