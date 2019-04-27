package edu.cscc.java4.rest.api;

import edu.cscc.java4.rest.data.CustomerRepository;
import edu.cscc.java4.rest.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/api/customers")
    public Map<String, Iterable<Customer>> getAllCustomers(){
        Map<String, Iterable<Customer>> response = new HashMap<>();
        response.put("customers", customerRepository.findAll());
        return response;
    }

//    public ResponseEntity getCustomer(Long){
//        return null;
//
//    }
//
//    public ResponseEntity deleteCustomer(Long){
//        return null;
//    }
//
//    public ResponseEntity createCustomer(Customer, UriComponentsBuilder){
//        return null;
//    }
//
//    public ResponseEntity saveCustomer(Long, Customer){
//        return null;
//    }

}
