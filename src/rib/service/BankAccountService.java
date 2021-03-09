package rib.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import rib.dao.BankAccountDao;
import rib.entity.BankAccount;
import rib.entity.Deposit;
import rib.util.HibernateUtils;

@SuppressWarnings("rawtypes")
public class BankAccountService {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	BankAccountDao bankAccountDao = new BankAccountDao();
	Deposit deposit = new Deposit();
	Scanner scanner = new Scanner(System.in);
	private Query query;

	public BankAccountService() throws Exception {
		super();
		this.bankAccountDao = new BankAccountDao();
	}

	public void addBankAccount(BankAccount bankAccount) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		query = session.createNativeQuery("INSERT INTO BankAccount (Username, Password, Deposit_ID) values(?1,?2,?3)");
		System.out.print("Username: ");
		bankAccount.setUsername(scanner.next());
		System.out.print("Parola: ");
		bankAccount.setPassword(scanner.nextInt());
		System.out.print("Id-ul depozitului: ");
		deposit.setNo(scanner.nextInt());

		query.setParameter(1, bankAccount.getUsername());
		query.setParameter(2, bankAccount.getPassword());
		query.setParameter(3, deposit.getNo() == 0 ? null : deposit.getNo());
		System.err.println("Contul bancar s-a creat cu succes!");
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public List<BankAccount> findPasswordByUsername(String username) throws Exception {
		bankAccountDao.openCurrentSession();
		List<BankAccount> bankAccount = bankAccountDao.findPasswordByUser(username);
		bankAccountDao.closeCurrentSession();
		return bankAccount;
	}
}
