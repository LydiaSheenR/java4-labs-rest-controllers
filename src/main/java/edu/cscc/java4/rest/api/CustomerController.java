package edu.cscc.java4.rest.api;

import edu.cscc.java4.rest.data.CustomerRepository;
import edu.cscc.java4.rest.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/api/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return new ResponseEntity(customer, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/api/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            customerRepository.delete(customer.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/api/customers")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer,  UriComponentsBuilder b){
        Customer newCustomer = customerRepository.save(customer);
        UriComponents uriComponents = b.path("/api/customers/{id}").buildAndExpand(newCustomer.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    @PutMapping("/api/customers/{id}")
    public ResponseEntity<?> saveCustomer(@PathVariable Long id, @RequestBody Customer newCustomer){
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (customerRepository.existsById(id)){
            customerRepository.save(newCustomer);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
