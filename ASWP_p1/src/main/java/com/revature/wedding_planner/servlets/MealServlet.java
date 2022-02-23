package com.revature.wedding_planner.servlets;

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
import com.revature.wedding_planner.models.MealType;
import com.revature.wedding_planner.services.MealTypeServices;

@SuppressWarnings("serial")
public class MealServlet extends HttpServlet {

	private final ObjectMapper mapper;
	private final MealTypeServices mealTypeServices;
	
	public MealServlet(ObjectMapper mapper, MealTypeServices mealTypeServices) {
		super();
		this.mapper = mapper;
		this.mealTypeServices = mealTypeServices;
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /mealTypes
		String path = req.getPathInfo();
		if(path == null) path = "";
		switch(path) {
		case "/ID":
			try {
				String idParam = req.getParameter("mealTypeId");
				if(idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?mealTypeId=# in your url");
					return;
				}
				
				int mealTypeId = Integer.valueOf(idParam);
				MealType mealType = mealTypeServices.getMealTypeById(mealTypeId);
				if(mealType == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(mealType);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<MealType> mealTypes = mealTypeServices.getAllMealTypes();
			String payload = mapper.writeValueAsString(mealTypes);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			MealType newMealType = mapper.readValue(req.getInputStream(), MealType.class);
			boolean wasReg = mealTypeServices.addMealType(newMealType);
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
			MealType updatedMealType = mapper.readValue(req.getInputStream(), MealType.class);
			mealTypeServices.updateMeal(updatedMealType);
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
