package rib.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import rib.entity.BankAccount;
import rib.entity.Deposit;
import rib.util.HibernateUtils;

public class DepositDao {
	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	@SuppressWarnings("rawtypes")
	private Query query;
	private Transaction transaction;
	BankAccount bankAccount = new BankAccount();
	Scanner scanner = new Scanner(System.in);

	public DepositDao() {
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
	public void addRon(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_RON=d.deposit_RON+?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2)");
		System.out.print("Enter amount: ");
		deposit.setRon(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getRon());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_RON from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold RON: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void addEur(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_EUR=d.deposit_EUR+?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2)");
		System.out.print("Enter amount: ");
		deposit.setEur(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getEur());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_EUR from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold EUR: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void addUsd(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_USD=d.deposit_USD+?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2)");
		System.out.print("Enter amount: ");
		deposit.setUsd(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getUsd());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_USD from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold USD: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void addGbp(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_GBP=d.deposit_GBP+?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2)");
		System.out.print("Enter amount: ");
		deposit.setGbp(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getGbp());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_GBP from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold GBP: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void withdrawRon(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_RON=d.deposit_RON-?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2) and d.deposit_RON-?1>=0");
		System.out.print("Enter amount: ");
		deposit.setRon(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getRon());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_RON from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold RON: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void withdrawEur(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_EUR=d.deposit_EUR-?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2) and d.deposit_EUR-?1>=0");
		System.out.print("Enter amount: ");
		deposit.setRon(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getEur());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_EUR from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold EUR: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void withdrawUsd(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_USD=d.deposit_USD-?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2) and d.deposit_USD-?1>=0");
		System.out.print("Enter amount: ");
		deposit.setRon(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getUsd());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_USD from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold RON: " + list + "\n");
	}

	@SuppressWarnings("unchecked")
	public void withdrawGbp(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_GBP=d.deposit_GBP-?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2) and d.deposit_GBP-?1>=0");
		System.out.print("Enter amount: ");
		deposit.setRon(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getGbp());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();

		List<Deposit> list = session.createNativeQuery(
				"SELECT Deposit.deposit_GBP from Deposit where Id in (SELECT Deposit_ID from BankAccount where Password=?1)")
				.setParameter(1, bankAccount.getPassword()).list();
		System.err.print("Sold GBP: " + list + "\n");
	}

	public List<Deposit> showAll() {
		return session.createQuery("FROM Deposit", Deposit.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Deposit> showPersonalDeposit(int password) {
		List<Deposit> list = session
				.createQuery("FROM Deposit where ID in (SELECT id from BankAccount where Password=:password)")
				.setParameter("password", password).list();
		if (list.isEmpty())
			System.out.println("EROARE!");
		return list;
	}
}
