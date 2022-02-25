package com.revature.wedding.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.wedding.dao.EmployeeDAO;
import com.revature.wedding.dao.MealTypeDAO;
import com.revature.wedding.dao.ServiceDAO;
import com.revature.wedding.dao.ServiceTypeDAO;
import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.dao.WeddingDAO;
import com.revature.wedding.services.EmployeeServices;
import com.revature.wedding.services.MealTypeServices;
import com.revature.wedding.services.ServiceServices;
import com.revature.wedding.services.ServiceTypesServices;
import com.revature.wedding.services.UserServices;
import com.revature.wedding.services.WeddingService;
import com.revature.wedding.servlets.EmployeesServlet;
import com.revature.wedding.servlets.MealServlet;
import com.revature.wedding.servlets.ServiceServlet;
import com.revature.wedding.servlets.ServiceTypeServlet;
import com.revature.wedding.servlets.UserServlet;
import com.revature.wedding.servlets.WeddingServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	private Logger logger;
	private Handler fh;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			fh = new FileHandler("log.txt", true);
			Logger.getLogger("").addHandler(fh);
		    Logger.getLogger("").setLevel(Level.CONFIG);
		    this.logger = Logger.getLogger("");
		    logger.info("Initialized logging in ContextLoaderListener");			
		}
		catch (Exception e) {
		
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeServices employeeServices = new EmployeeServices(employeeDAO);  // manual wiring
		EmployeesServlet employeeServlet = new EmployeesServlet(employeeServices, mapper);
		
		ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
		ServiceTypesServices serviceTypesServices = new ServiceTypesServices(serviceTypeDAO);
		ServiceTypeServlet serviceTypeServlet = new ServiceTypeServlet(serviceTypesServices,mapper);
		
		ServiceDAO serviceDAO = new ServiceDAO();
		ServiceServices serviceServices = new ServiceServices(serviceDAO);
		ServiceServlet serviceServlet = new ServiceServlet(serviceTypesServices, serviceServices, mapper);	
		
		MealTypeDAO mealTypeDAO = new MealTypeDAO();
		MealTypeServices mealTypeServices = new MealTypeServices(mealTypeDAO);
		MealServlet mealTypeServlet = new MealServlet(mapper, mealTypeServices);
		
		UserDAO userDAO = new UserDAO();
		UserServices userServices = new UserServices(userDAO);
		
		WeddingDAO weddingDAO = new WeddingDAO();
		WeddingService weddingService = new WeddingService(weddingDAO,userDAO);
		
		UserServlet userServlet = new UserServlet(weddingService,userServices, mapper);		
		
		
		WeddingServlet weddingServlet = new WeddingServlet(mapper, weddingService, serviceServices, userServices);	

			
		
		ServletContext context = sce.getServletContext();
		context.addServlet("EmployeesServlet", employeeServlet).addMapping("/employees/*");
		context.addServlet("ServiceTypeServlet", serviceTypeServlet).addMapping("/servicetype/*");
		context.addServlet("ServiceServlet", serviceServlet).addMapping("/services/*");
		context.addServlet("WeddingServlet", weddingServlet).addMapping("/wedding/*");		
		context.addServlet("UserServlet", userServlet).addMapping("/users/*");
		context.addServlet("MealTypeServlet", mealTypeServlet).addMapping("/mealtype/*");
		
		logger.info("contextInitialized");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		logger.info("contextDestroyed");
	}

}
