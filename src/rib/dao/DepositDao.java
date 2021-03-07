package rib.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import rib.entity.BankAccount;
import rib.entity.Deposit;
import rib.util.HibernateUtils;

public class DepositDao {
	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();
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
	}

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
	}

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
	}

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
	}
//UPDATE deposit d set d.Deposit_RON=d.Deposit_RON-12000 where ID in (SELECT deposit_ID from bankaccount where Password=123 ) and d.Deposit_RON-12000 >= 0;
	
	public void removeRon(Deposit deposit) {
		query = session.createNativeQuery(
				"UPDATE Deposit d set d.deposit_RON=d.deposit_RON-?1 where Id in (SELECT Deposit_ID from BankAccount where Password=?2) and d.deposit_RON-?1>=0");
		System.out.print("Enter amount: ");
		deposit.setRon(scanner.nextInt());
		System.out.print("Enter password: ");
		bankAccount.setPassword(scanner.nextInt());

		query.setParameter(1, deposit.getRon());
		query.setParameter(2, bankAccount.getPassword());
		query.executeUpdate();
	}
}
