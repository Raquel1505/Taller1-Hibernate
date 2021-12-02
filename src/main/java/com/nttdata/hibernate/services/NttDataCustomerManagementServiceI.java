package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttDataCustomer;

/**
 * Interface de servicios de la tabla NTTDATA_HEX_CUSTOMER
 * 
 * @author dhraq
 *
 */
public interface NttDataCustomerManagementServiceI {

	/**
	 * Método para insertar clientes
	 * 
	 * @param newCustomer
	 * 
	 * @return Long
	 */
	public void insertNewCustomer(NttDataCustomer newCustomer);
	
	/**
	 * Método para borrar customer
	 * 
	 * @param deleteCustomer
	 * 
	 */
	public void deleteCustomer(NttDataCustomer deleteCustomer);
	
	/**
	 * Método para buscar por id
	 * 
	 * @param customerId
	 * 
	 */
	public NttDataCustomer searchById(Long customerId);
	
	/**
	 * Método para buscar por nombre y apellidos
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return List<customer>
	 */
	public List<NttDataCustomer> searchByName(String name, String surname, String secondSurname);

	/**
	 * Método para actualizar 
	 * 
	 * @param updateCustomer
	 */
	void updateCustomer(NttDataCustomer updateCustomer);

}
