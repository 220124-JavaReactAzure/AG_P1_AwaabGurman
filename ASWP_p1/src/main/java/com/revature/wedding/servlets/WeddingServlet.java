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
import com.revature.wedding.models.Wedding;
import com.revature.wedding.services.ServiceServices;
import com.revature.wedding.services.WeddingService;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
public class WeddingServlet extends HttpServlet {
	private final ObjectMapper mapper;
	private final WeddingService weddingService;
	private final ServiceServices serviceServices;

	/**
	 * @param mapper
	 * @param weddingService
	 * @param service
	 * @param serviceType
	 */
	public WeddingServlet(ObjectMapper mapper, WeddingService weddingService, ServiceServices serviceServices) {
		super();
		this.mapper = mapper;
		this.weddingService = weddingService;
		this.serviceServices = serviceServices;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Wedding newWedding = mapper.readValue(req.getInputStream(), Wedding.class);
			String venuId = req.getParameter("venuId");
			if(venuId != null) {
				Service service = serviceServices.getServiceById(Integer.valueOf(venuId));
				newWedding.setVenuId(service);
			}
			String musicianId = req.getParameter("musicianId");
			if(musicianId != null) {
				Service service = serviceServices.getServiceById(Integer.valueOf(musicianId));
				newWedding.setVenuId(service);
			}
			String catererId = req.getParameter("catererId");
			if(catererId != null) {
				Service service = serviceServices.getServiceById(Integer.valueOf(catererId));
				newWedding.setVenuId(service);
			}
			String floristId = req.getParameter("floristId");
			if(floristId != null) {
				Service service = serviceServices.getServiceById(Integer.valueOf(floristId));
				newWedding.setVenuId(service);
			}
			String photographerId = req.getParameter("photographerId");
			if(photographerId != null) {
				Service service = serviceServices.getServiceById(Integer.valueOf(photographerId));
				newWedding.setVenuId(service);
			}
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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /service
		String path = req.getPathInfo();
		if(path == null) path = "";
		List<Wedding> wedding = weddingService.getAllWedding();
		String payload = mapper.writeValueAsString(wedding);
		writer.write(payload);
		resp.setStatus(200);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			String weddingId = req.getParameter("weddingId");
			if(weddingId == null) {
				resp.setStatus(400);
				resp.getWriter().write("Please include the query ? weddingId=# in your url");
				return;
			}
			boolean value = weddingService.deleteWedding(Integer.valueOf(weddingId));
			if (value) {
				resp.setStatus(200);
				resp.getWriter().write("weeding deleted");
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
}
