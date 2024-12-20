package com.promineotech.pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import com.promineotech.pet.store.entity.Customer;
import com.promineotech.pet.store.entity.Employee;
import com.promineotech.pet.store.entity.PetStore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor 
public class PetStoreData {
	private Long petStoreId;	
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	private Set<PetStoreEmployee> employees = new HashSet<>();
	private Set<PetStoreCustomer> customers = new HashSet<>();
	
	public PetStoreData(PetStore petStore) {
		this.petStoreId = petStore.getPetStoreId();
		this.petStoreName = petStore.getPetStoreName();
		this.petStoreAddress = petStore.getPetStoreAddress();
		this.petStoreCity = petStore.getPetStoreCity();
		this.petStoreState = petStore.getPetStoreState();
		this.petStoreZip = petStore.getPetStoreZip();
		this.petStorePhone = petStore.getPetStorePhone();
		
		for(Employee employee : petStore.getEmployees()) {
			this.employees.add(new PetStoreEmployee(employee));
		}
		
		for(Customer customer : petStore.getCustomers()) {
			this.customers.add(new PetStoreCustomer(customer));
		}
		
	}
	
	
}
