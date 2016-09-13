package com.daxiang.credit_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.daixiang.domain.Project;
import com.daixiang.domain.Task;
import com.daxiang.DAO.ProjectDAO;

/**
 * Hello world!
 *
 */
public class App 
{
//	private static EntityManagerFactory emf;
//
//	static {
//		try {
//			emf = Persistence.createEntityManagerFactory("cs544");
//		} catch (Throwable ex) {
//			ex.printStackTrace();
//			throw new ExceptionInInitializerError(ex);
//		}
//	}

	public static void main(String[] args) {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		Project pj1=new Project("EA project","good project");
//		Task task1=new Task("EA task 1");
//		pj1.getTasks().add(task1);
//		task1.setProject(pj1);
//		em.persist(pj1);
//		em.persist(task1);
//		tx.commit();
		Project pj1=new Project("EA project","good project");
		ProjectDAO projectDao=new ProjectDAO();
    	projectDao.CreateProject(pj1);
    	
        System.out.println( "Hello World!" );
    }
}
