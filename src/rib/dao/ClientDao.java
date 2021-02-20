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

	@Override
	public Client findByNo(int No) {
		return session.get(Client.class, No);
	}

	@SuppressWarnings("unchecked")
	public List<Client> findClientByName(String firstName) throws Exception {
		List<Client> clients = session.createQuery("from Client where FirstName=:firstName")
				.setParameter("firstName", firstName).list();
		if (clients.isEmpty())
			throw new Exception("There are not client: " + firstName);
		return clients;
	}

	@Override
	public void delete(Client entity) {
		session.delete(entity);
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

	@Override
	public List<Client> orderByCityAsc() {
		return session.createQuery("FROM Client order by city asc", Client.class).list();
	}

	@Override
	public List<Client> orderByCityDesc() {
		return session.createQuery("FROM Client order by City desc", Client.class).list();
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

	@Override
	public void update(Client entity) {
		session.saveOrUpdate(entity);
	}
}

