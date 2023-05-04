package org.example.criteria_queries.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.example.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class AddressSpecification {

	@Autowired
	private AddressRepositorySpecification addressRepository;

	public static Specification<Address> byPincode(){
		return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("pincode"), 1234));
	}

	public static Specification<Address> byCity(){
		return ((root,query,cb)->cb.equal(root.get("city"),"amd"));
	}

	public void getAddress(){
		Specification<Address> spec=byCity().and(byPincode());
		addressRepository.findAll(spec).forEach(System.out::println);
	}
}
