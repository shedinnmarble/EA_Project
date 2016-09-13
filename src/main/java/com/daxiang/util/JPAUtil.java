package com.daxiang.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	private JPAUtil() {
		// TODO Auto-generated constructor stub
	}
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	

}
