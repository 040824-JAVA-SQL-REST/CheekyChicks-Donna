package com.revature.ecommerce.service;

import com.revature.ecommerce.dao.AddressDAO;
import com.revature.ecommerce.models.Address;

public class AddressService {
private final AddressDAO addDao;

public AddressService(AddressDAO addDao) {
	this.addDao = addDao;
}

 public void persistAddress(Address address) {
	 addDao.save(address);
 }

}
