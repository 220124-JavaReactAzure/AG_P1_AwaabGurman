/**
 * 
 */
package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding.models.ServiceType;
import com.revature.wedding.util.datasource.HibernateUtil;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class ServiceTypeDAO implements IDAO<ServiceType> {

	@Override
	public boolean create(ServiceType serviceType) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(serviceType);
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public List<ServiceType> selectAll() {
		try {
			Session session = HibernateUtil.getSession();
			List<ServiceType> serviceTypes = session.createQuery("FROM ServiceType").list();
			return serviceTypes;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public ServiceType selectById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			ServiceType serviceType = session.get(ServiceType.class, id);
			return serviceType;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean update(ServiceType service) {
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
			// Updates and Deletes always start with a transaction and end with a commit
			Transaction transaction = session.beginTransaction();
//			session.merge(service);
			session.delete(session.get(ServiceType.class, id));
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
