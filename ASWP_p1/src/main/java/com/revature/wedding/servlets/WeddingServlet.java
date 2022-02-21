/**
 * 
 */
package com.revature.wedding.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.ServiceType;
import com.revature.wedding.models.Wedding;
import com.revature.wedding.services.ServiceServices;
import com.revature.wedding.services.WeddingService;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
public class WeddingServlet extends HttpServlet{
	private final ObjectMapper mapper;
	private final WeddingService weddingService;
	/**
	 * @param mapper
	 * @param weddingService
	 * @param service
	 * @param serviceType
	 */
	public WeddingServlet(ObjectMapper mapper, WeddingService weddingService) {
		super();
		this.mapper = mapper;
		this.weddingService = weddingService;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);
			weddingService.insertWedding(newWedding);
			resp.setStatus(201);
			
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
		}catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
	
	
}
