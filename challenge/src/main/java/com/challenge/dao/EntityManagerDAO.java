package com.challenge.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerDAO {

	private static EntityManager entityManager;

	private EntityManagerDAO() {

	}

	public static EntityManager getInstance() {

		if (entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hsql");
			entityManager = entityManagerFactory.createEntityManager();
		}

		return entityManager;

	}

}