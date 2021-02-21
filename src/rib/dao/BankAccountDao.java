package rib.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.xml.bind.v2.TODO;

import rib.entity.BankAccount;
import rib.util.HibernateUtils;

public class BankAccountDao {
	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	private Transaction transaction;

	public BankAccountDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}
	//TODO repara asta
	public BankAccount findPasswordByUser(String username) throws Exception {
		Query query=session.createQuery("from BankAccount where Username=:username").setParameter("username", username);
		if(query==null)
			throw new Exception("The username "+username+" is wrong or don't exist");
	return (BankAccount) query;
	}
}
