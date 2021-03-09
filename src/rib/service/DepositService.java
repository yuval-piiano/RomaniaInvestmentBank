package rib.service;

import java.util.List;

import rib.dao.DepositDao;
import rib.entity.Deposit;

public class DepositService {
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

	public void withdrawalRon(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.withdrawRon(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public void withdrawalEur(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.withdrawEur(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public void withdrawalUsd(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.withdrawUsd(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public void withdrawalGbp(Deposit deposit) {
		depositDao.openCurrentSessionwithTransaction();
		depositDao.withdrawGbp(deposit);
		depositDao.closeCurrentSessionwithTransaction();
	}

	public List<Deposit> showAll() {
		depositDao.openCurrentSession();
		List<Deposit> list = depositDao.showAll();
		depositDao.closeCurrentSession();
		return list;
	}

	public List<Deposit> showPersonalDeposit() {
		depositDao.openCurrentSession();
		List<Deposit> list = depositDao.showPersonalDeposit();
		depositDao.closeCurrentSession();
		return list;
	}

	public void convertAllMoneyToRON() {
		depositDao.openCurrentSession();
		depositDao.convertAllMoneyToRON();
		depositDao.closeCurrentSession();
	}

	public void convertAllMoneyToEUR() {
		depositDao.openCurrentSession();
		depositDao.convertAllMoneyToEUR();
		depositDao.closeCurrentSession();
	}
}
