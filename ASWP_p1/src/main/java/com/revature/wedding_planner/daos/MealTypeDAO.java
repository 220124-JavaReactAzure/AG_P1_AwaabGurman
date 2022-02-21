package com.revature.wedding_planner.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_planner.models.MealType;
import com.revature.wedding_planner.util.HibernateUtil;

public class MealTypeDAO {

	public boolean create(MealType mealType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(mealType);
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<MealType> selectAll() {
		try {
			Session session = HibernateUtil.getSession();
			List<MealType> mealTypes = session.createQuery("FROM MealType").list();
			return mealTypes;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public MealType selectById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			MealType mealType = session.get(MealType.class, id);
			return mealType;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public boolean update(MealType mealType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(mealType);
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(session.get(MealType.class, id));
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
