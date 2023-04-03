package org.example.service;

import org.example.entity.Address;
import org.example.repo.*;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
	private final AddressDao addressDao=new AddressDaoImpl();
	@Override
	public void insertAddress(Address address) {
		try{
				String addressId=addressDao.findByAddress(address);

				if(addressId==null)
				{
					if(!addressDao.insertAddress(address)){
						System.err.println("Address Could Not Inserted");
					}
				}else{
					address.setAddressId(addressId);
				}
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}

	}




}
