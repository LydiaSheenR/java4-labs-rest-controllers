package edu.cscc.java4.rest.data;

import edu.cscc.java4.rest.domain.Customer;
import org.springframework.data.repository.CrudRepository;



public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
