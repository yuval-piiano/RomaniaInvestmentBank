package rib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rib.entity.Client;
import rib.util.HibernateUtils;

public class ClientDao implements EntityDao<Client, Integer> {

	private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

	private Transaction transaction;

	public ClientDao() {
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

	public Client findByCnp(long cnp) {
		return session.get(Client.class, cnp);
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> findClientById(String id) throws Exception{
		List<Client> clients=session.createQuery("from Client where ID=:id").setParameter("id", id).list();
		if (clients.isEmpty())
			throw new Exception("There is not client with the ID: " + id);
		return clients;
	}

	@SuppressWarnings("unchecked")
	public List<Client> findClientByName(String firstName) throws Exception {
		List<Client> clients = session.createQuery("from Client where FirstName=:firstName")
				.setParameter("firstName", firstName).list();
		if (clients.isEmpty())
			throw new Exception("There is not client with first name: " + firstName);
		return clients;
	}
//TODO trebuie refacuta
	public void delete(Client id) {
		session.delete(id);
	}

	@Override
	public void deleteAll() {
		session.createQuery("delete from Client").executeUpdate();
	}

	public List<Client> orderByIdAsc() {
		return session.createQuery("FROM Client order by id asc", Client.class).list();
	}

	public List<Client> orderByIdDesc() {
		return session.createQuery("FROM Client order by id desc", Client.class).list();
	}

	public List<Client> orderByFirstNameAsc() {
		return session.createQuery("FROM Client order by FirstName ASC", Client.class).list();
	//FROM Client INNER JOIN Address on Client.address_No=Address.no order by Address.city asc
	}

	public List<Client> orderByFirstNameDesc() {
		return session.createQuery("FROM Client order by FirstName DESC", Client.class).list();
	}
	
	public List<Client> orderByLastNameAsc() {
		return session.createQuery("FROM Client order by LastName ASC", Client.class).list();
	}

	public List<Client> orderByLastNameDesc() {
		return session.createQuery("FROM Client order by LastName DESC", Client.class).list();
	}

	@Override
	public List<Client> orderByNoAsc() {
		return session.createQuery("FROM Client Order by NO asc", Client.class).list();
	}

	@Override
	public List<Client> orderByNoDesc() {
		return session.createQuery("FROM Client order by no desc", Client.class).list();
	}

	@Override
	public void persist(Client entity) {
		session.save(entity);
	}

	@Override
	public List<Client> showAll() {
		return session.createQuery("from Client", Client.class).list();
	}
}
