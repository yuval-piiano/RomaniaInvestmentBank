package rib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rib.entity.CustomerAdvisors;
import rib.util.HibernateUtils;

public class CustomerAdvisorsDao implements EntityDao<CustomerAdvisors, Integer> {

	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	private Transaction transaction;

	public CustomerAdvisorsDao() {
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

	public void delete(CustomerAdvisors entity) {
		session.delete(entity);
	}

	@Override
	public void deleteAll() {
		session.createQuery("DELETE from CustomerAdvisors").executeUpdate();

	}

	public List<CustomerAdvisors> orderByFirstNameAsc() {
		return session.createQuery("FROM CustomerAdvisors order by FirstName ASC", CustomerAdvisors.class).list();
	}

	public List<CustomerAdvisors> orderByFirstNameDesc() {
		return session.createQuery("FROM CustomerAdvisors order by FirstName DESC", CustomerAdvisors.class).list();
	}

	public List<CustomerAdvisors> orderByLastNameAsc() {
		return session.createQuery("FROM CustomerAdvisors order by LastName ASC", CustomerAdvisors.class).list();
	}

	public List<CustomerAdvisors> orderByLastNameDesc() {
		return session.createQuery("FROM CustomerAdvisors order by LastName DESC", CustomerAdvisors.class).list();
	}

	@Override
	public List<CustomerAdvisors> orderByNoAsc() {
		return session.createQuery("FROM CustomerAdvisors Order by NO asc", CustomerAdvisors.class).list();
	}

	@Override
	public List<CustomerAdvisors> orderByNoDesc() {
		return session.createQuery("FROM CustomerAdvisors ORDER BY NO DESC", CustomerAdvisors.class).list();
	}

	@Override
	public void persist(CustomerAdvisors entity) {
		session.save(entity);
	}

	@Override
	public List<CustomerAdvisors> showAll() {
		return session.createQuery("from CustomerAdvisors", CustomerAdvisors.class).list();
	}
}
