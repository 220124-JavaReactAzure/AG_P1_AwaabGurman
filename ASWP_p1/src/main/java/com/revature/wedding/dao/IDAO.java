/**
 * 
 */
package com.revature.wedding.dao;

import java.util.List;

/**
 * @author Awaab Elamin
 * @Date 2/12/2022
 * @interface for data access objects must implements by each DAO class
 **/
public interface IDAO<E> {

	boolean create(E newObject);

	List<E> selectAll();

	E selectById(int id);

	boolean update(E object);

	boolean delete(int id);
}
