package com.pharma.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Startup implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized called");
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed called");
	}

}