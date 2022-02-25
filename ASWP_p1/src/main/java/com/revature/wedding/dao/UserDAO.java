package com.revature.wedding.dao;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.wedding.models.User;
import com.revature.wedding.util.datasource.HibernateUtil;


public class UserDAO {

	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to persist");
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<User> getAllUsers() {
		try {
			Session session = HibernateUtil.getSession();
			List<User> users = session.createQuery("FROM User").list();
			return users;
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to retrieve");
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public User getUserById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			User user = session.get(User.class, id);
			return user;
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to retrieve");
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateUserWithSessionMethod(User user) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(user);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			Logger.getLogger("").warning("failed to update");
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public boolean delete(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String sqlSyntax = "delete User where user_id = :user_id";
			org.hibernate.query.Query query = session.createQuery(sqlSyntax);
			query.setParameter("user_id", id);
			int value = query.executeUpdate();
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

	public boolean deleteByWeddingId(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String sqlSyntax = "delete User where wedd_id = :wedding_Id";
			org.hibernate.query.Query query = session.createQuery(sqlSyntax);
			query.setParameter("wedding_Id", id);
			int value = query.executeUpdate();
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
