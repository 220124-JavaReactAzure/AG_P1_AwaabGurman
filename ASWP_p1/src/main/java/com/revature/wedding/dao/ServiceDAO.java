/**
 * 
 */
package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding.models.Service;
import com.revature.wedding.util.datasource.HibernateUtil;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class ServiceDAO implements IDAO<Service> {

	@Override
	public boolean create(Service service) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(service);
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public List<Service> selectAll() {
		try {
			Session session = HibernateUtil.getSession();
//			SELECT * FROM service s 
//			INNER JOIN service_types st 
//			ON s.service_types_id = st.service_types_id ;
			String sqlSyntax = " FROM Service S ";
			List<Service> services = session.createQuery(sqlSyntax).list();
			return services;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public Service selectById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Service services = session.get(Service.class, id);
			return services;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean update(Service service) {
		try {
			Session session = HibernateUtil.getSession();
			// Updates and Deletes always start with a transaction and end with a commit
			Transaction transaction = session.beginTransaction();
			session.merge(service);
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
		try {
			Session session = HibernateUtil.getSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Service> getServicesByServiceTypeId(int id) {
		try {
			Session session = HibernateUtil.getSession();

			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM service m WHERE m.serviceType.id = :ID");

			query.setParameter("ID", id);

			List<Service> serviceList = query.getResultList();

			return serviceList;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
