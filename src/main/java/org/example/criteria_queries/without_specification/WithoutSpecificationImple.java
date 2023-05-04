package org.example.criteria_queries.without_specification;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class WithoutSpecificationImple {
	@Autowired
	private CustomeAddressRepository customeAddressRepository;
	private final EntityManager em;

	public WithoutSpecificationImple(EntityManager em) {
		this.em = em;
	}


	public List<Address> findByCityAndPincode(String city, int pincode) {
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Address> cq=cb.createQuery(Address.class);

		Root<Address> addressRoot=cq.from(Address.class);
		List<Predicate> predicates=new ArrayList<>();
		predicates.add(cb.equal(addressRoot.get("city"),city));
		predicates.add(cb.equal(addressRoot.get("pincode"),pincode));
		cq.where(predicates.toArray(new Predicate[0]));
		return em.createQuery(cq).getResultList();
	}


}
