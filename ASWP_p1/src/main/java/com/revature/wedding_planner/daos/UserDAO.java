package com.revature.wedding_planner.daos;

import java.io.IOException;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.wedding_planner.models.User;
import com.revature.wedding_planner.util.HibernateUtil;

public class UserDAO {

	public boolean create(User newUser) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(newUser);
			return true;
		} catch (HibernateException | IOException | NoResultException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public User findByUsername(String username) {
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("from User u where u.username = :username ");

			query.setParameter("username", username);

			User user = (User) query.getSingleResult();
			return user;
		} catch (HibernateException | IOException | NoResultException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Object findByEmail(String email) {
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("from User u where u.email = :email");

			query.setParameter("email", email);

			User user = (User) query.getSingleResult();
			return user;
		} catch (HibernateException | IOException | NoResultException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public User findByUsernameAndPassword(String username, String password) {
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("from User u where u.username = :username and u.password = :password");

			query.setParameter("username", username);
			query.setParameter("password", password);

			User user = (User) query.getSingleResult();

			return user;
		} catch (HibernateException | IOException | NoResultException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
