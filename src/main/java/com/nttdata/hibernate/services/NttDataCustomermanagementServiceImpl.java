package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttCustomerDaoI;
import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.persistence.NttDataCustomerDaoImpl;

/**
 * Dao Implementado de la tabla NTTDATA_HEX_CUSTOMER
 * @author dhraq
 *
 */
public class NttDataCustomermanagementServiceImpl implements NttDataCustomerManagementServiceI{
	
	/** DAO: NTTDATA_CUSTOMER */
	private NttCustomerDaoI customerDao;
	
	/** Método constructor */
	public NttDataCustomermanagementServiceImpl(final Session session) {
		this.customerDao = new NttDataCustomerDaoImpl(session);
	}
	
	/**
	 * Insertar nuevo cliente
	 */
	@Override
	public void insertNewCustomer(final NttDataCustomer newCustomer) {
		
		//Verificación de null
		if(newCustomer != null && newCustomer.getCustomerId() == null) {
			//Insersión de nuevo cliente
			customerDao.insert(newCustomer);
		}
		
	}
	
	/**
	 * Método borrar cliente
	 */
	
	@Override
	public void deleteCustomer(final NttDataCustomer deleteCustomer) {
		
		//Verificación de null
		if(deleteCustomer !=null && deleteCustomer.getCustomerId() !=null) {
			//Eliminación del cliente
			customerDao.delete(deleteCustomer);
			
		}
	}
	
	/**
	 * Método buscar por Id
	 */
	
	@Override
	public NttDataCustomer searchById(final Long customerId) {
		
		//Resultado de la búsqueda
		NttDataCustomer customer = null;
		
		//Verificación de null
		if(customerId != null) {
			
			//Selección del cliente por su Id
			customer = customerDao.searchById(customerId);
		}
		return customer;
	}
	
	/**
	 * Método busqueda por nombre y apellidos
	 */
	
	@Override
	public List<NttDataCustomer> searchByName(final String name, final String surname, final String secondSurname){
		
		//Resultado consultar todos
		List<NttDataCustomer> customerList = new ArrayList<NttDataCustomer>();
		
		//Verificación de null
		if(StringUtils.isNoneBlank(name) && StringUtils.isNoneBlank(surname) && StringUtils.isNoneBlank(secondSurname)) {
			
			//Resultado consultar por nombre y apellidos
			customerList = customerDao.searchByCustomerFullName(name, surname, secondSurname);
		}
		return customerList;
	}
	
	@Override
	public void updateCustomer(final NttDataCustomer updateCustomer) {
		
		//Verificación de null
		if(updateCustomer != null && updateCustomer.getCustomerId() != null) {
			
			//Actualización del cliente
			customerDao.update(updateCustomer);
		}
	}

}
