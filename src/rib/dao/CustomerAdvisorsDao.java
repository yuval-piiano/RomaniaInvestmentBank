package rib.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rib.entity.CustomerAdvisors;
import rib.util.HibernateUtils;
import rib.util.Warehouse;

public class CustomerAdvisorsDao implements EntityDao<CustomerAdvisors, Integer> {

	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	Scanner scanner = new Scanner(System.in);
	Warehouse warehouse = new Warehouse();
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

	@SuppressWarnings({ "unchecked" })
	public void customerAdvisorsLogin() {
		int attempts = 0;
		do {
			if (attempts == 3) {
				System.err.println("\nATI INTRODUS DE PREA MULTE ORI CONTUL GRESIT!\nLA REVEDERE!");
				System.exit(0);
			} else {
				System.out.print("Introduceti numele: ");
				String firstName = scanner.next();
				System.out.print("Introduceti prenumele: ");
				String lastName = scanner.next();
				System.out.print("Introduceti parola: ");
				int password = scanner.nextInt();
				List<CustomerAdvisors> list = session.createQuery(
						"SELECT 1 FROM CustomerAdvisors c WHERE c.firstName=:firstName and c.lastName=:lastName and customerAdvisorsPassword_No in (SELECT no from CustomerAdvisorsPassword where Password=:password)")
						.setParameter("firstName", firstName).setParameter("lastName", lastName)
						.setParameter("password", password).list();

				if (list.isEmpty()) {
					System.err.print("");
				} else {
					warehouse.progressBar();
					System.out.println("Done");
					break;
				}
			}
			attempts++;
			if ((3 - attempts) == 2)
				System.err.print("\nMAI AVETI 2 INCERCARI DISPONOBILE!\n");
			if ((3 - attempts) == 1)
				System.err.print("\nMAI AVETI O SINGURA INCERCARE DISPONIBILA!\n");
		} while (attempts <= 3);
	}

	public void delete(CustomerAdvisors entity) {
		session.delete(entity);
	}

	@Override
	public void deleteAll() {
		session.createQuery("DELETE from CustomerAdvisors").executeUpdate();
	}

//	@SuppressWarnings("unchecked")
//	public List<BankAgency> findBankAgencyByCity(String city)throws Exception  {
//		List<BankAgency> bankBranches=session.createQuery("from BankAgency where address_No in (SELECT no from Address where City=:city)").setParameter("city", city).list();
//		if(bankBranches.isEmpty())
//			throw new Exception("There are not bank branches in "+city);
//	return bankBranches;
//	}

	@SuppressWarnings("unchecked")
	public List<CustomerAdvisors> findBankEmployees(String bankID) {
		List<CustomerAdvisors> list = session
				.createQuery("from CustomerAdvisors where bankAgency_No in (SELECT no from BankAgency where ID=:bankID")
				.setParameter("ID", bankID).list();
		if (list.isEmpty())
			System.err.print("Nu exista bancher cu id-ul " + bankID);
		return list;
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
