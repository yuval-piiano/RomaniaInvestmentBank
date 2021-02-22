package rib.service;

import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import rib.dao.CustomerAdvisorsDao;
import rib.entity.Address;
import rib.entity.BankAgency;
import rib.entity.CustomerAdvisors;
import rib.util.HibernateUtils;

public class CustomerAdvisorsSevice {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	private CustomerAdvisorsDao customerAdvisorsDao;
	Scanner scanner = new Scanner(System.in);
	BankAgency bankAgency = new BankAgency();
	CustomerAdvisors customerAdvisors = new CustomerAdvisors();
	Address address = new Address();

	public CustomerAdvisorsSevice() {
		super();
		this.customerAdvisorsDao = new CustomerAdvisorsDao();
	}

	public void addCustomersAdvisors(CustomerAdvisors customerAdvisors) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createNativeQuery(
				"INSERT INTO CustomersAdvisors(FirstName, LastName, CNP, PhoneNumber, address_No, bankAgency_No) values(?1,?2,?3,?4,?5,?6)");
		System.out.print("First name: ");
		customerAdvisors.setFirstName(scanner.next());
		System.out.print("Last name: ");
		customerAdvisors.setLastName(scanner.next());
		System.out.print("CNP: ");
		customerAdvisors.setCnp(scanner.next());
		System.out.print("Phone: ");
		customerAdvisors.setPhoneNumber(scanner.next());
		System.out.println("If a parameter doesn't exist, you enter \"0\"");
		System.out.print("Address no.: ");
		address.setNo(scanner.nextInt());
		System.out.print("Bank agency no.: ");
		bankAgency.setNo(scanner.nextInt());

		query.setParameter(1, customerAdvisors.getFirstName());
		query.setParameter(2, customerAdvisors.getLastName());
		query.setParameter(3, customerAdvisors.getCnp());
		query.setParameter(4, customerAdvisors.getPhoneNumber());
		query.setParameter(5, address.getNo()==0?null:address.getNo());
		query.setParameter(6, bankAgency.getNo()==0?null:bankAgency.getNo());
		System.err.println("Customer advisors successfully added!");
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	public void deleteCustomerAdvisors(CustomerAdvisors customerAdvisors) {
		customerAdvisorsDao.openCurrentSessionwithTransaction();
		customerAdvisorsDao.delete(customerAdvisors);
		customerAdvisorsDao.closeCurrentSessionwithTransaction();
	}
	
	public void deleteAllCustomersAdvisors() {
		customerAdvisorsDao.openCurrentSessionwithTransaction();
		customerAdvisorsDao.deleteAll();
		customerAdvisorsDao.closeCurrentSessionwithTransaction();
	}
}
