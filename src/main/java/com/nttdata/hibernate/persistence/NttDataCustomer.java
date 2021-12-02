package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
	 * Dual - Hibernate - Taller1
	 * 
	 * @author dhraq
	 * 
	 * Entidad de tabla NTTDATA_HEX_CUSTOMER
	 */
	
	@Entity
	@Table(name="NTTDATA_CUSTOMER")
	public class NttDataCustomer implements Serializable{
	
		/** Serial Version */
		private static final long serialVersionUID = 1L;
		
		/** Identificador numérico (PK) */
		private Long customerId;
		
		/** Nombre del cliente */
		private String name;
		
		/** Primer apellido del cliente */
		private String surname;
		
		/** Segundo apellido del cliente */
		private String secondSurname;
		
		/** DNI del cliente (FK) */
		private String dni;
		
		/**
		 * @return customerId
		 * 
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long getCustomerId() {
			return customerId;
		}
		
		/**
		 * @param setCustomerId
		 */
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		
		/**
		 * @return name
		 */
		@Column(name = "NAME")
		public String getName() {
			return name;
		}
		
		/**
		 * @param setName
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * @return surname
		 */
		@Column(name = "SURNAME")
		public String getSurname() {
			return surname;
		}
		
		/**
		 * @param setSurname
		 */
		public void setSurname(String surname) {
			this.surname = surname;
		}
		
		/**
		 * @return secondSurname
		 */
		@Column(name = "SECONDSURNAME")
		public String getSecondSurname() {
			return secondSurname;
		}
		
		/**
		 * @param setSecondSurname
		 */
		public void setSecondSurname(String secondSurname) {
			this.secondSurname = secondSurname;
		}
		
		/**
		 * @return secondSurname
		 */
		
		@Column(name = "DNI", nullable = false, unique = true)
		public String getDni() {
			return dni;
		}
		
		/**
		 * @param setSecondSurname
		 */
		public void setDni(String dni) {
			this.dni = dni;
		}
		
		@Override
		public String toString() {
			return "NttDataCustomer [customerId=" + customerId + ", name" + name +", surname=" + surname + "secondSurname=" + secondSurname + "dni=" + dni + "]";
		}


}
