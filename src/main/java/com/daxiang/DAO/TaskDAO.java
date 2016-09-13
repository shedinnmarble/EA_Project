package com.daxiang.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.daixiang.domain.Task;
import com.daxiang.util.JPAUtil;

public class TaskDAO {

	public void createTask(Task task){
		EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			em.persist(task);
			tx.commit();
		}catch(PersistenceException ex){
			if(tx!=null &&tx.isActive()) tx.rollback();
			ex.printStackTrace();
		}finally{
			em.close();
		}
	}
	public TaskDAO() {
		// TODO Auto-generated constructor stub
	}

}
