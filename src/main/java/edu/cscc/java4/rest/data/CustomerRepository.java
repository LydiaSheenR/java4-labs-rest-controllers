package edu.cscc.java4.rest.data;

import edu.cscc.java4.rest.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

//  Customer save(Customer entity);
//  Optional<Customer> findById(long primaryKey);
//  Iterable<Customer> findAll();
//  long count();
//  void delete(Customer entity);
//  boolean existsById(long primaryKey);

}
