package org.example.repo;


import org.example.entity.Address;

import java.util.List;

public interface AddressDao {
	String findByAddress(Address address);

	boolean insertAddress(Address address);

	boolean updateAddress(Address address);

	Address getByAddressId(String addressId);

	List<Address> getAllAddressRecords();
}