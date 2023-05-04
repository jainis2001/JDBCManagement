package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.criteria_queries.specification.AddressSpecification;
import org.example.dto.AddressDTO;
import org.example.entity.Address;
import org.example.repo.AddressRepo;
import org.example.criteria_queries.without_specification.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
	private static final Logger LOGGER= LogManager.getLogger(AddressServiceImpl.class);

	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private WithoutSpecificationImple spec;

	@Autowired
	private AddressSpecification addressSpecification;
	@Autowired
	private Mapper mapper;
	@Override
	public Address insertAddress(AddressDTO addressDTO) {
		LOGGER.trace("Entered to process the address-insert");
		Address address=mapper.mapToAddressEntity(addressDTO);
		Address existAddress=addressRepo.findByLandmarkAndPincode(address.getLandmark(),address.getPincode());
		LOGGER.info("Address proceed successfully");
		LOGGER.trace("Exited to process the address-insert");
		return (existAddress==null)?addressRepo.save(address):existAddress;

	}
}
