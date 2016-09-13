package com.daxiang.credit_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.daixiang.domain.Project;
import com.daixiang.domain.Task;
import com.daxiang.DAO.ProjectDAO;
import com.daxiang.DAO.TaskDAO;
import com.daxiang.util.JPAUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TaskDaoTestT extends TestCase {
	public void test(){
		assertTrue(true);
	}
	   /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TaskDaoTestT.class );
    }
    /**
     * test create task
     */
    public void testCreateTask(){
    	
		Project p=new Project();
    	p.setName("Test-Project-Name-1");
    	p.setDesc("this is a good project-1");  
    	ProjectDAO projectDao=new ProjectDAO();
    	projectDao.CreateProject(p);
    	
    	Task task=new Task("test-task");
    	task.setProject(p);
    	TaskDAO taskDao=new TaskDAO();
    	taskDao.createTask(task);
	
    	EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction tx=null;
    	tx=em.getTransaction();
    	tx.begin();
    	Query query=em.createQuery("from Task t where t.taskName=:name");
    	query.setParameter("name", task.getTaskName());
    	Task queryTask=(Task) query.getSingleResult();
    	assertTrue(queryTask.getTaskName().equals(task.getTaskName()));
    	assertTrue(queryTask.getProject().getName().equals(p.getName()));
    	em.remove(queryTask);
    	em.remove(queryTask.getProject());
    	
		tx.commit();
		
    }
}
