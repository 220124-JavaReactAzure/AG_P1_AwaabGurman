/**
 * 
 */
package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.Wedding;
import com.revature.wedding.util.datasource.HibernateUtil;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
public class WeddingDAO implements IDAO<Wedding>{

	@Override
	public boolean create(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(wedding);
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
	public List<Wedding> selectAll() {
		try {
			Session session = HibernateUtil.getSession();
			List<Wedding> weddings = session.createQuery("FROM Wedding").list();
			return weddings;
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to retrieve");
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public Wedding selectById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Wedding wedding = session.get(Wedding.class, id);
			return wedding;
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to retrieve");
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public boolean update(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(wedding);
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
				String sqlSyntax = "delete Wedding where weddingId = :weddingId";
				org.hibernate.query.Query weddingQuery = session.createQuery(sqlSyntax);
				weddingQuery.setParameter("weddingId", id);
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
