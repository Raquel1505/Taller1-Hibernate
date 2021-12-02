package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Dual - Hibernate - Taller1
 * 
 * @author dhraq
 * 
 *         DAOIMPLE de tabla NTTDATA_HEX_CUSTOMER
 *
 */

public interface NttCustomerDaoI {

	/**
	 * Método para insertar clientes
	 * 
	 * @param newCustomer
	 * 
	 * @return Long
	 */
	public void insert(final NttDataCustomer newCustomer);

	/**
	 * Método para borrar customer
	 * 
	 * @param deleteCustomer
	 * 
	 */
	public void delete(final NttDataCustomer deleteCustomer);

	/**
	 * Método para buscar por id
	 * 
	 * @param customerId
	 * 
	 */
	public NttDataCustomer searchById(final Long customerId);

	/**
	 * Método para buscar por nombre y apellidos
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return List<customer>
	 */
	public List<NttDataCustomer> searchByCustomerFullName(String name, String surname, String secondSurname);

	/**
	 * Método para actualizar customer
	 * 
	 * @param updateCustomer
	 */
	public void update(NttDataCustomer updateCustomer);
	
	/**
	 * Método para buscar todo
	 * 
	 * @return List<Customer>
	 */
	public List<NttDataCustomer> searchAll();

}
