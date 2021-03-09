package rib.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

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

	// TODO repara asta
	@SuppressWarnings("unchecked")
	public List<BankAccount> findPasswordByUser(String username) throws Exception {
		List<BankAccount> list = session.createQuery("select password from BankAccount where Username=:username")
				.setParameter("username", username).list();
		if (list.isEmpty())
			throw new Exception("Numele de utilizator " + username + " a fost introdus gresit sau nu exista");
		else
			System.err.print("Parola: ");
		return list;
	}
}
