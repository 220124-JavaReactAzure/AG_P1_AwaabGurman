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
import com.revature.wedding.models.Employee;
import com.revature.wedding.services.EmployeeServices;

@SuppressWarnings("serial")
public class EmployeesServlet extends HttpServlet{
	private final EmployeeServices employeeServices;
	private final ObjectMapper mapper;
	public EmployeesServlet(EmployeeServices employeeServices, ObjectMapper mapper) {
		this.employeeServices = employeeServices;
		this.mapper = mapper;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Switch statements are back sorry
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /directors
		String path = req.getPathInfo();
		if(path == null) path = "";
		switch(path) {
		case "/ID":
			try {
				String idParam = req.getParameter("employee_id");
				if(idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?employee_id=# in your url");
					return;
				}
				
				int employeeId = Integer.valueOf(idParam);
				
			
				Employee employee = employeeServices.getEmployeeById(employeeId);
				if(employee == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(employee);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Employee> employees = employeeServices.getAllEmployees();
			String payload = mapper.writeValueAsString(employees);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Employee newEmployee = mapper.readValue(req.getInputStream(), Employee.class);
			boolean wasReg = employeeServices.addEmployee(newEmployee);
			if(wasReg) {
				resp.setStatus(201);
			} else {
				resp.setStatus(500);
				resp.getWriter().write("Database did not persist");
			}
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			String message = "JSON threw exception"+ e.getMessage();
			resp.getWriter().write(message);
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Employee updatedEmployee = mapper.readValue(req.getInputStream(), Employee.class);
			//directorServices.updateDirectorWithHQL(updatedDirector);
			employeeServices.updatemployee(updatedEmployee);
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
