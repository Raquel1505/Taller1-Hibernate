package com.nttdata.hibernate;


import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.services.NttDataCustomerManagementServiceI;
import com.nttdata.hibernate.services.NttDataCustomermanagementServiceImpl;

public class NttDataMain {

	/**
	 * Método Principal
	 * 
	 * @author dhraq
	 * 
	 * @param args
	 */

	public static void main(String[] args) {


			// Apertura de sesión.
			final Session session = nttDataHibernateUtil.getSessionFactory().openSession();

			// Inicialización de los servicios
			final NttDataCustomerManagementServiceI customerService = new NttDataCustomermanagementServiceImpl(session);

			// Creación de clientes

			final NttDataCustomer juan = new NttDataCustomer();
			juan.setName("Juan");
			juan.setSurname("Ramirez");
			juan.setSecondSurname("Fernández");
			juan.setDni("456987123");

			final NttDataCustomer lucia = new NttDataCustomer();
			lucia.setName("Lucía");
			lucia.setSurname("Pérez");
			lucia.setSecondSurname("Cuadrado");
			lucia.setDni("987654321");

			final NttDataCustomer pedro = new NttDataCustomer();
			pedro.setName("Pedro");
			pedro.setSurname("Benitez");
			pedro.setSecondSurname("Raso");
			pedro.setDni("123456789");

			customerService.insertNewCustomer(juan);
			customerService.insertNewCustomer(lucia);
			customerService.insertNewCustomer(pedro);

			List<NttDataCustomer> customers = customerService.searchByName("Pedro", "Benitez", "Raso");
	    	for(final NttDataCustomer customer : customers) {
	    		System.out.println("Nombre: " + customer.getName() + " | Primer Apellido: " + customer.getSurname() + " | Segundo Apellido: " + customer.getSecondSurname() + " | ID: " + customer.getCustomerId());
    	}
	    	
			// Cierre de conexión con BBDD.
			session.close();
	}
}
