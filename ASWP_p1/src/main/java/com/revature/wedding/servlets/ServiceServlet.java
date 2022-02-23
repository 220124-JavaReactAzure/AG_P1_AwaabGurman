/**
 * 
 */
package com.revature.wedding.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.ServiceType;
import com.revature.wedding.services.ServiceServices;
import com.revature.wedding.services.ServiceTypesServices;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class ServiceServlet extends HttpServlet {
	private final ObjectMapper mapper;
	private final ServiceServices serviceServices;
	private final ServiceTypesServices serviceTypeService;
	/**
	 * @param mapper
	 * @param serviceTypeDAO
	 */
	public ServiceServlet(ServiceTypesServices serviceTypeService, ServiceServices serviceServices, ObjectMapper mapper) {
		super();
		this.mapper = mapper;
		this.serviceServices = serviceServices;
		this.serviceTypeService = serviceTypeService;
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /service
		String path = req.getPathInfo();
		if(path == null) path = "";
		switch(path) {
		case "/ID":
			try {
				String idParam = req.getParameter("serviceId");
				if(idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?serviceId=# in your url");
					return;
				}
				
				int serviceId = Integer.valueOf(idParam);
				Service service = serviceServices.getServiceById(serviceId);
				if(service == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(service);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Service> service = serviceServices.getAllservices();
			String payload = mapper.writeValueAsString(service);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			String idParam = req.getParameter("serviceTypeId");
			if(idParam == null) {
				resp.setStatus(400);
				resp.getWriter().write("Please include the query ?serviceTypeId=# in your url");
				return;
			}
			ServiceType serviceType = serviceTypeService.getServiceTypeById(Integer.valueOf(idParam));
			Service newService = mapper.readValue(req.getInputStream(), Service.class);
			newService.setServiceType(serviceType);
			serviceServices.insertservice(newService);
			resp.setStatus(201);
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Service updatedService = mapper.readValue(req.getInputStream(), Service.class);
			serviceServices.updateService(updatedService);
			resp.setStatus(204);	
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
