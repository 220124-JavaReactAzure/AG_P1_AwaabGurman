package com.revature.wedding.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.wedding.dao.EmployeeDAO;
import com.revature.wedding.dao.ServiceDAO;
import com.revature.wedding.dao.ServiceTypeDAO;
import com.revature.wedding.dao.WeddingDAO;
import com.revature.wedding.services.EmployeeServices;
import com.revature.wedding.services.ServiceServices;
import com.revature.wedding.services.ServiceTypesServices;
import com.revature.wedding.services.WeddingService;
import com.revature.wedding.servlets.EmployeesServlet;
import com.revature.wedding.servlets.ServiceServlet;
import com.revature.wedding.servlets.ServiceTypeServlet;
import com.revature.wedding.servlets.WeddingServlet;
@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		private final Logger logger = Logger.getLogger(null);
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
		
		WeddingDAO weddingDAO = new WeddingDAO();
		WeddingService weddingService = new WeddingService(weddingDAO);
		WeddingServlet weddingServlet = new WeddingServlet(mapper, weddingService);	
		
		ServletContext context = sce.getServletContext();
		context.addServlet("EmployeesServlet", employeeServlet).addMapping("/employees/*");
		context.addServlet("ServiceTypeServlet", serviceTypeServlet).addMapping("/servicetype/*");
		context.addServlet("ServiceServlet", serviceServlet).addMapping("/services/*");
		context.addServlet("WeddingServlet", weddingServlet).addMapping("/wedding/*");		
		
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

}
