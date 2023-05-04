package org.example.criteria_queries.without_specification;

import org.example.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomeAddressRepository extends JpaRepository<Address,String > {
	List<Address> findByCityAndPincode(String city, int pincode);

}
