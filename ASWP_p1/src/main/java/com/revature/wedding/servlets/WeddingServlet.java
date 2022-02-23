/**
 * 
 */
package com.revature.wedding.servlets;

import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.List;
=======
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

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
<<<<<<< HEAD
public class WeddingServlet extends HttpServlet {
	private final ObjectMapper mapper;
	private final WeddingService weddingService;

=======
public class WeddingServlet extends HttpServlet{
	private final ObjectMapper mapper;
	private final WeddingService weddingService;
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
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
<<<<<<< HEAD

=======
	
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);
			weddingService.insertWedding(newWedding);
			resp.setStatus(201);
<<<<<<< HEAD

=======
			
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
<<<<<<< HEAD
		} catch (Exception e) {
=======
		}catch (Exception e) {
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
<<<<<<< HEAD

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /service
		String path = req.getPathInfo();
		if(path == null) path = "";
		List<Wedding> wedding = weddingService.getAllWedding();
		String payload = mapper.writeValueAsString(wedding);
		writer.write(payload);
		resp.setStatus(200);
	}
=======
	
	
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
}
