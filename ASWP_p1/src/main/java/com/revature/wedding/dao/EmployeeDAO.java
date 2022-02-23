/**
 * 
 */
package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding.models.Employee;
import com.revature.wedding.util.datasource.HibernateUtil;

/**
 * @author Awaab
 *
 */
public class EmployeeDAO implements IDAO<Employee> {
//	static Logger logger = Logger.getLogger(EmployeeDAO.class.getName());

	@Override
	public boolean create(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(employee);
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> selectAll() {
		List<Employee> employees; 
		try {
			Session session = HibernateUtil.getSession();
			 employees= session.createQuery("FROM Employee").list();
			 System.out.println(employees);
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public Employee selectById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Employee employee = session.get(Employee.class, id);
			return employee;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean update(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			// Updates and Deletes always start with a transaction and end with a commit
			Transaction transaction = session.beginTransaction();
			session.merge(employee);
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
