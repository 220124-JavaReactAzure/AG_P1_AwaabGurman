/**
 * 
 */
package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			System.out.println("wedding data: "+ wedding);
			session.save(wedding);
			return true;
		} catch (HibernateException | IOException e) {
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
		} catch (Exception e) {
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
