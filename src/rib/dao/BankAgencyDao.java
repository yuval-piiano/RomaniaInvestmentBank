package rib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rib.entity.BankAgency;
import rib.util.HibernateUtils;

public class BankAgencyDao implements EntityDao<BankAgency, Integer> {

	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	private Transaction transaction;

	public BankAgencyDao() {
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

	@SuppressWarnings("unchecked")
	public List<BankAgency> findBankAgencyByCity(String city)throws Exception  {
		List<BankAgency> bankBranches=session.createQuery("from BankAgency where address_No in (SELECT no from Address where City=:city)").setParameter("city", city).list();
		if(bankBranches.isEmpty())
			throw new Exception("There are not bank branches in "+city);
	return bankBranches;
	}
	
	
	
	public BankAgency findByNo(int no) {
		return session.get(BankAgency.class, no);
	}
	
	@Override
	public void delete(BankAgency entity) {
		session.delete(entity);
	}

	@Override
	public void deleteAll() {
		session.createQuery("delete from BankAgency").executeUpdate();
	}

	public List<BankAgency> orderByIdAsc() {
		return session.createQuery("FROM BankAgency order by ID ASC", BankAgency.class).list();
	}
	
	public List<BankAgency> orderByIdDesc() {
		return session.createQuery("FROM bankagency order by ID DESC", BankAgency.class).list();
	}
	
	@Override
	public List<BankAgency> orderByCityAsc() {
		return session.createQuery("FROM bankAgency order by city ASC", BankAgency.class).list();
	}

	@Override
	public List<BankAgency> orderByCityDesc() {
		return session.createQuery("FROM BankAgency order by City DESC", BankAgency.class).list();
	}

	@Override
	public List<BankAgency> orderByNoAsc() {
		return session.createQuery("FROM BankAgency Order by NO ASC", BankAgency.class).list();
	}

	@Override
	public List<BankAgency> orderByNoDesc() {
		return session.createQuery("FROM BankAgency Order by NO DESC", BankAgency.class).list();
	}

	@Override
	public void persist(BankAgency entity) {
		session.save(entity);
	}
	
	@Override
	public List<BankAgency> showAll() {
		return session.createQuery("FROM BankAgency", BankAgency.class).list();
	}
}

