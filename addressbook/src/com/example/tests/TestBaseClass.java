package com.example.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.example.fw.ApplicationManager;

public class TestBaseClass {

	
	protected static ApplicationManager app;
	
	

	@BeforeSuite
	public void setUp() throws Exception {
		if (app == null){
		app = new ApplicationManager();	   
		}
	  }
	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();
	    
	  }

}
