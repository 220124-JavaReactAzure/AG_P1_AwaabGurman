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
import com.revature.wedding.models.User;
import com.revature.wedding.models.Wedding;
import com.revature.wedding.services.UserServices;
import com.revature.wedding.services.WeddingService;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	private final UserServices userServices;
	private final ObjectMapper mapper;
	private final WeddingService weddingService;
	
	public UserServlet(WeddingService weddingService,UserServices userServices, ObjectMapper mapper) {
		this.userServices = userServices;
		this.mapper = mapper;
		this.weddingService = weddingService;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /users
		String path = req.getPathInfo();
		if(path == null) path = "";
		switch(path) {
		case "/ID":
			try {
				String idParam = req.getParameter("userId");
				if(idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?userId=# in your url");
					return;
				}
				
				int directorId = Integer.valueOf(idParam);
				
			
				User user = userServices.getUserById(directorId);
				if(user == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(user);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<User> users = userServices.getAllUsers();
			String payload = mapper.writeValueAsString(users);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			User newUser = mapper.readValue(req.getInputStream(), User.class);
			String weddingId = req.getParameter("weddingId");
			if(weddingId != null) {
				Wedding wedding = weddingService.getWeddingById(Integer.valueOf(weddingId));
				newUser.setWedding_id(wedding);
			}
			boolean wasReg = userServices.addUser(newUser);
			if(wasReg) {
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
			User updatedUser = mapper.readValue(req.getInputStream(), User.class);
			userServices.updateUserWithSessionMethod(updatedUser);
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
		resp.setContentType("application/json");
		try {
			String user_id = req.getParameter("user_id");
			if(user_id == null) {
				resp.setStatus(400);
				resp.getWriter().write("Please include the query ? user_id=# in your url");
				return;
			}
			boolean value = userServices.deleteUserById(Integer.valueOf(user_id));
			if (value) {
				resp.setStatus(200);
				resp.getWriter().write("user deleted");
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
