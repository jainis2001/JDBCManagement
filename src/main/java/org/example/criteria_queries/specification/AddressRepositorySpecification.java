package org.example.criteria_queries.specification;

import org.example.entity.Address;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepositorySpecification  extends JpaRepository<Address,String>, JpaSpecificationExecutor<Address> {
//	List<Address> findAll(Specification<Address> specification);

}
