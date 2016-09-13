package com.daxiang.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.daixiang.domain.Project;
import com.daxiang.util.JPAUtil;

public class ProjectDAO {
	EntityManager em=JPAUtil.getEntityManager();
	
	public void CreateProject(Project project){
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			em.persist(project);
			tx.commit();
			
		}catch(PersistenceException ex){
			if(tx!=null &&tx.isActive()) tx.rollback();
			ex.printStackTrace();
		}finally{
			em.close();
		}
	}
	public void removeProject(int id){
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			Project p= em.find(Project.class, id);
			em.remove(p);
			tx.commit();
			
		}catch(PersistenceException ex){
			if(tx!=null &&tx.isActive()) tx.rollback();
			ex.printStackTrace();
		}finally{
			em.close();
		}
	}
	public void editProject(Project p){
		EntityTransaction tx=null;
		try{
			tx=em.getTransaction();
			tx.begin();
			Project old=em.find(Project.class, p.getId());
			old.setName(p.getName());
			old.setDesc(p.getDesc());
			old.setTasks(p.getTasks());
			old.setEndDate(p.getEndDate());
			old.setOwner(p.getOwner());
			old.setStatus(p.getStatus());
			tx.commit();
			
		}catch(PersistenceException ex){
			if(tx!=null &&tx.isActive()) tx.rollback();
			ex.printStackTrace();
		}finally{
			em.close();
		}
	}
	public ProjectDAO() {
		// TODO Auto-generated constructor stub
	}

}
