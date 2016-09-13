package com.daxiang.credit_project;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTest(ProjectDaoTest.suite());
		suite.addTest(TaskDaoTestT.suite());
		//$JUnit-END$
		return suite;
	}

}
