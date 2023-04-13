package org.example.repo;

import org.example.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, String> {

	Address findByLandmarkAndPincode(String landmark,int pincode);

}
