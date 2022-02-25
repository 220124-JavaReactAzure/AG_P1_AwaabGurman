/**
 * 
 */
package com.revature.wedding.util.datasource;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Test;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class HibernateUtilTestSuite {
	@Test
	public void test_getSession_returnsValidSessuib_givenProviderCredentials() {
		try {
			Session sess = HibernateUtil.getSession();
			HibernateUtil.closeSession();
			System.out.println(sess);
			assertNotNull(sess);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
