package rib.service;

import java.awt.image.BandCombineOp;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import rib.dao.BankAccountDao;
import rib.entity.BankAccount;
import rib.util.HibernateUtils;

public class BankAccountService {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	BankAccountDao bankAccountDao = new BankAccountDao();
	Scanner scanner = new Scanner(System.in);

	public BankAccountService() throws Exception {
		super();
		this.bankAccountDao = new BankAccountDao();
	}

	public BankAccount findPasswordByUsername(String username) throws Exception {
		bankAccountDao.openCurrentSession();
		BankAccount bankAccount=bankAccountDao.findPasswordByUser(username);
		bankAccountDao.closeCurrentSession();
		return bankAccount;
	}
}
