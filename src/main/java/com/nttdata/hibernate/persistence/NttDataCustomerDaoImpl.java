package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

public class NttDataCustomerDaoImpl implements NttCustomerDaoI {

	/** Sesión de conexión */
	private Session session;

	/**
	 * Método constructor sobrecargado
	 * 
	 * @param session
	 */
	public NttDataCustomerDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void insert(NttDataCustomer newCustomer) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción
		final Long newCustomerId = (Long) session.save(newCustomer);

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void update(final NttDataCustomer updateCustomer) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción
		session.saveOrUpdate(updateCustomer);

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void delete(NttDataCustomer deleteCustomer) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción
		session.delete(deleteCustomer);

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public NttDataCustomer searchById(final Long customerId) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK
		NttDataCustomer result = session.get(NttDataCustomer.class, customerId);
		return result;
	}

	@Override
	public List<NttDataCustomer> searchAll() {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los clientes
		List<NttDataCustomer> list = session.createQuery("FROM NttDataCustomer").list();
		return list;
	}

	@Override
	public List<NttDataCustomer> searchByCustomerFullName(String name, String surname, String secondSurname) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localizar al cliente por nombre y apellidos
		final List<NttDataCustomer> customerList = session.createQuery("FROM NttDataCustomer WHERE name='" + name
				+ "' AND surname= '" + surname + "' AND secondsurname= '" + secondSurname + "'").list();
		return customerList;
	}

}
