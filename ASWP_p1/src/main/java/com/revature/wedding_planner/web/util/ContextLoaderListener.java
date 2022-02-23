package com.revature.wedding_planner.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.wedding_planner.daos.MealTypeDAO;
import com.revature.wedding_planner.daos.UserDAO;
import com.revature.wedding_planner.services.MealTypeServices;
import com.revature.wedding_planner.services.UserServices;
import com.revature.wedding_planner.servlets.MealServlet;
import com.revature.wedding_planner.servlets.UserServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		MealTypeDAO mealTypeDAO = new MealTypeDAO();
		MealTypeServices mealTypeServices = new MealTypeServices(mealTypeDAO);
		MealServlet mealTypeServlet = new MealServlet(mapper, mealTypeServices);
		
		UserDAO userDAO = new UserDAO();
		UserServices userServices = new UserServices(userDAO);
		UserServlet userServlet = new UserServlet(userServices, mapper);	
		
		ServletContext context = sce.getServletContext();
		context.addServlet("UserServlet", userServlet).addMapping("/users/*");
		context.addServlet("MealTypeServlet", mealTypeServlet).addMapping("/mealtype/*");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
