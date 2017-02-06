package com.challenge.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.challenge.entity.Image;

public class ImageDAO {

	private EntityManager em = EntityManagerDAO.getInstance();

	public Set<Image> getImagesForProductId(Integer id) {
		return new HashSet<>(em.createQuery("select i from Image i where i.product.id = :id", Image.class).setParameter("id", id).getResultList());
	}

}
