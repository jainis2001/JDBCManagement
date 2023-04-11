package org.example.service;

import org.example.entity.Address;
import org.example.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepo addressRepo;
	@Override
	public Address insertAddress(Address address) {
		Address existAddress=addressRepo.findByLandmarkAndPincode(address.getLandmark(),address.getPincode());
		return (existAddress==null)?addressRepo.save(address):existAddress;
	}
}
