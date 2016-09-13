package com.daxiang.credit_project;

import java.util.Date;

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

/**
 * Unit test for simple App.
 */
public class ProjectDaoTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProjectDaoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProjectDaoTest.class );
    }

    /**
     * test create Project
     */
    public void testCreateProject(){
    	EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction tx=null;
		tx=em.getTransaction();
    	tx.begin();
    	
    	Project p=new Project();
    	p.setName("Test-Project-Name");
    	p.setDesc("this is a good project");
    	ProjectDAO projectDao=new ProjectDAO();
    	projectDao.CreateProject(p);
    	
    	
    	Project projectResult=(Project) em.createQuery("from  Project p where p.name=:name and p.desc=:desc")
    	.setParameter("name",p.getName()).setParameter("desc", p.getDesc()).getSingleResult();
    	//System.out.println(size);   	
    	em.remove(projectResult);
    	tx.commit();
    	assertTrue(projectResult.getName().equals(p.getName()));
    	assertTrue(projectResult.getDesc().equals(p.getDesc()));
    	
    }
    
    public void testRemoveProject(){
    	//create a new one
    	//then delete
    	//check search result
    	Project p=new Project();
    	p.setName("test@test-project"+new Date().getTime());
    	p.setDesc("test@test-project"+new Date().getTime());  
    	ProjectDAO projectDao=new ProjectDAO();
    	projectDao.CreateProject(p);
    	
    	EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction tx=null;
    	tx=em.getTransaction();
    	tx.begin();
    	Query query=em.createQuery("from Project p where p.name=:name and p.desc=:desc");
    	query.setParameter("name", p.getName());
    	query.setParameter("desc", p.getDesc());
    	Project queryProject=(Project) query.getSingleResult();
    	assertTrue(queryProject.getDesc().equals(p.getDesc()));
    	assertTrue(queryProject.getName().equals(p.getName()));
    	em.remove(queryProject);
    	tx.commit();
    	//find the deleted one
    	tx.begin();
    	Project pRemoved=em.find(Project.class, queryProject.getId());
    	tx.commit();
    	assertTrue(pRemoved==null);
    }
    
    public void testEditProject(){
    	//create a new one
    	//then delete
    	//check search result
    	Project p=new Project();
    	p.setName("test@test-project"+new Date().getTime());
    	p.setDesc("test@test-project"+new Date().getTime());  
    	ProjectDAO projectDao=new ProjectDAO();
    	projectDao.CreateProject(p);
    	
    	EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction tx=null;
    	tx=em.getTransaction();
    	tx.begin();
    	Query query=em.createQuery("from Project p where p.name=:name and p.desc=:desc");
    	query.setParameter("name", p.getName());
    	query.setParameter("desc", p.getDesc());
    	Project queryProject=(Project) query.getSingleResult();
    	queryProject.setName("dewei xiang");
    	tx.commit();
    	projectDao.editProject(queryProject);
    	
    }
 
}
