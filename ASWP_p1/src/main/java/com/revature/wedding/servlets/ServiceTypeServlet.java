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
import com.revature.wedding.dao.ServiceTypeDAO;
import com.revature.wedding.models.ServiceType;
import com.revature.wedding.services.ServiceTypesServices;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class ServiceTypeServlet extends HttpServlet {
	private final ObjectMapper mapper;
	private final ServiceTypesServices serviceTypesServices;

	/**
	 * @param mapper
	 * @param serviceTypeDAO
	 */
	public ServiceTypeServlet(ServiceTypesServices serviceTypesServices, ObjectMapper mapper) {
		super();
		this.mapper = mapper;
		this.serviceTypesServices = serviceTypesServices;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /serviceTypes
		String path = req.getPathInfo();
		if (path == null)
			path = "";
		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("serviceTypeId");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?serviceTypeId=# in your url");
					return;
				}

				int serviceTypeId = Integer.valueOf(idParam);
				ServiceType serviceType = serviceTypesServices.getServiceTypeById(serviceTypeId);
				if (serviceType == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(serviceType);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<ServiceType> serviceTypes = serviceTypesServices.getAllServiceTypes();
			String payload = mapper.writeValueAsString(serviceTypes);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			ServiceType newServiceType = mapper.readValue(req.getInputStream(), ServiceType.class);
			boolean wasReg = serviceTypesServices.addServiceType(newServiceType);
			if (wasReg) {
				resp.setStatus(201);
			} else {
				resp.setStatus(500);
				resp.getWriter().write("Database did not persist");
			}
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
			ServiceType updatedServiceType = mapper.readValue(req.getInputStream(), ServiceType.class);
			// serviceTypeServices.updateServiceTypeWithHQL(updatedServiceType);
			serviceTypesServices.updateServiceType(updatedServiceType);
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
		resp.setStatus(200);
		resp.getWriter().write("ServiceType is not able to deleted, beacuse we have many services on a relation with"
				+ ". you can make update to it");
	}
}
