/**
 * 
 */
package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

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
			Logger.getLogger("").warning("failed to persist");
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
			Logger.getLogger("").warning("failed to retrieve");
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
			Logger.getLogger("").warning("failed to retrieve");
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
			Logger.getLogger("").warning("failed to update");
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
			Transaction transaction = session.beginTransaction();
			String sqlSyntax = "delete ServiceType st where st.serviceTypeId = :serviceTypeId";
			org.hibernate.query.Query weddingQuery = session.createQuery(sqlSyntax);
			weddingQuery.setParameter("serviceTypeId", id);
			int value = weddingQuery.executeUpdate();
			transaction.commit();
			return value > 0;
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to delete");
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
