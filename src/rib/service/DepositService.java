package rib.service;

import org.hibernate.SessionFactory;

import rib.dao.DepositDao;
import rib.entity.Deposit;
import rib.util.HibernateUtils;

public class DepositService {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	DepositDao depositDao = new DepositDao();

	public DepositService() {
		super();
	}

	public void addRon(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.addRon(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public void addEur(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.addEur(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public void addUsd(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.addUsd(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public void addGbp(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.addGbp(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}
	
	public void withdrowRon(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.removeRon(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}
}
