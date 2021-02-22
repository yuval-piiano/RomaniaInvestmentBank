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

	@Override
	public void delete(CustomerAdvisors entity) {
		session.delete(entity);
	}

	@Override
	public void deleteAll() {
		session.createQuery("DELETE from CustomerAdvisors").executeUpdate();

	}

	@Override
	public List<CustomerAdvisors> orderByCityAsc() {
		//return session.createQuery("from ");
		return null;
	}

	@Override
	public List<CustomerAdvisors> orderByCityDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerAdvisors> orderByNoAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerAdvisors> orderByNoDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerAdvisors> orderByIdAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerAdvisors> orderByIdDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(CustomerAdvisors entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerAdvisors> showAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
