package rib.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import rib.dao.ClientDao;
import rib.entity.Address;
import rib.entity.BankAccount;
import rib.entity.Client;
import rib.entity.CustomerAdvisors;
import rib.util.HibernateUtils;

@SuppressWarnings("rawtypes")
public class ClientService {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	private ClientDao clientDao;
	private Query query;
	Scanner scanner = new Scanner(System.in);
	BankAccount bankAccount = new BankAccount();
	CustomerAdvisors customerAdvisors = new CustomerAdvisors();
	Address address = new Address();

	public ClientService() throws Exception {
		super();
		this.clientDao = new ClientDao();
	}

	public void addClient(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		query = session.createNativeQuery(
				"INSERT INTO Client (Id, FirstName, LastName, CNP, Email, PhoneNumber, bankAccount_ID, Address_No, customerAdvisors_No) values(?1,?2,?3,?4,?5,?6,?7,?8,?9)");
		System.out.println("If a parameter doesn't exist, you enter \"-\"");
		System.out.print("ID: ");
		client.setId(scanner.next());
		System.out.print("First name: ");
		scanner.nextLine();
		client.setFirstName(scanner.nextLine());
		System.out.print("Last name: ");
		client.setLastName(scanner.next());
		System.out.print("CNP: ");
		client.setCnp(scanner.nextLong());
		System.out.print("Email: ");
		client.setEmail(scanner.next());
		System.out.print("Phone number: ");
		client.setPhoneNumber(scanner.next());
		System.out.println("If a parameter doesn't exist, you enter \"0\"");
		System.out.print("Account ID: ");
		bankAccount.setId(scanner.nextInt());
		System.out.print("Address No: ");
		address.setNo(scanner.nextInt());
		System.out.print("Customers advisor ID: ");
		customerAdvisors.setId(scanner.nextInt());

		query.setParameter(1, client.getId());
		query.setParameter(2, client.getFirstName());
		query.setParameter(3, client.getLastName());
		query.setParameter(4, client.getCnp());
		query.setParameter(5, client.getEmail().equals("-") ? null : client.getEmail());
		query.setParameter(6, client.getPhoneNumber());
		query.setParameter(7, bankAccount.getId() == 0 ? null : bankAccount.getId());
		query.setParameter(8, address.getNo() == 0 ? null : address.getNo());
		query.setParameter(9, customerAdvisors.getId() == 0 ? null : customerAdvisors.getId());
		System.err.println("Client successfully added!");
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public List<Client> findClientByFirstName(String firstName) throws Exception {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.findClientByName(firstName);
		clientDao.closeCurrentSession();
		return lista;
	}

	public Client findClientByCnp(int cnp) {
		clientDao.openCurrentSession();
		Client client = clientDao.findByCnp(cnp);
		clientDao.closeCurrentSession();
		return client;
	}
	
	public List<Client> findClientById(String id) throws Exception {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.findClientById(id);
		clientDao.closeCurrentSession();
		return lista;
	}

	public void deleteClient(Client client) {
		clientDao.openCurrentSessionwithTransaction();
		clientDao.delete(client);
		clientDao.closeCurrentSessionwithTransaction();
	}

	public void deleteAllClients() {
		clientDao.openCurrentSessionwithTransaction();
		clientDao.deleteAll();
		clientDao.closeCurrentSessionwithTransaction();
	}

	public List<Client> orderClientsByIdAsc() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.orderByIdAsc();
		clientDao.closeCurrentSession();
		return lista;
	}

	public List<Client> orderClientsByIdDesc() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.orderByIdDesc();
		clientDao.closeCurrentSession();
		return lista;
	}

	public List<Client> orderClientsByCityAsc() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.orderByCityAsc();
		clientDao.closeCurrentSession();
		return lista;
	}

	public List<Client> orderClientsByCityDesc() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.orderByCityDesc();
		clientDao.closeCurrentSession();
		return lista;
	}

	public List<Client> orderClientsByNoAsc() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.orderByNoAsc();
		clientDao.closeCurrentSession();
		return lista;
	}

	public List<Client> orderClientsByNoDesc() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.orderByNoDesc();
		clientDao.closeCurrentSession();
		return lista;
	}

	public void saveClient(Client client) {
		clientDao.openCurrentSessionwithTransaction();
		clientDao.persist(client);
		clientDao.closeCurrentSessionwithTransaction();
	}

	public List<Client> showAllClients() {
		clientDao.openCurrentSession();
		List<Client> lista = clientDao.showAll();
		clientDao.closeCurrentSession();
		return lista;
	}

	public void updateClientEmail(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		query = session.createNativeQuery("UPDATE CLIENT SET Email=?1 where Id=?2");
		System.out.print("Email: ");
		client.setEmail(scanner.next());
		System.out.print("ID: ");
		client.setId(scanner.next());
		
		query.setParameter(1, client.getEmail());
		query.setParameter(2, client.getId());
		System.err.println("Client successfully updated!");
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	public void updateClientPhoneNumber(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		query = session.createNativeQuery("UPDATE CLIENT SET PhoneNumber=?1 where Id=?2");
		System.out.print("Phoner number: ");
		client.setEmail(scanner.next());
		System.out.print("ID: ");
		client.setId(scanner.next());
		
		query.setParameter(1, client.getPhoneNumber());
		query.setParameter(2, client.getId());
		System.err.println("Client successfully updated!");
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	public void updateClientFirstName(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		query = session.createNativeQuery("UPDATE CLIENT SET FirstName=?1 where Id=?2");
		System.out.print("First name: ");
		client.setEmail(scanner.next());
		System.out.print("ID: ");
		client.setId(scanner.next());
		
		query.setParameter(1, client.getFirstName());
		query.setParameter(2, client.getId());
		System.err.println("Client successfully updated!");
		query.executeUpdate();
		session.getTransaction().commit();
	}
}
