package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.Exceptions.CustomerException;
import com.example.cinemaapp.Exceptions.LoginException;
import com.example.cinemaapp.Model.Customer;
import com.example.cinemaapp.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException{

        Customer addedCustomer = customerService.addCustomer(customer);

        return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);

    }

    @PutMapping("/customers/{key}")
    public ResponseEntity<Customer> updateCustomerHandler(@PathVariable("key") String key,@RequestBody Customer customer) throws LoginException, CustomerException{

        Customer updatedCustomer = customerService.updateCustomer(customer, key);

        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);

    }

    @DeleteMapping("/customers/{key}")
    public ResponseEntity<Customer> removeCustomerHandler(@PathVariable("key") String key,@RequestBody Customer customer) throws CustomerException, LoginException{

        Customer deletedCustomer = customerService.removeCustomer(customer, key);

        return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);

    }

    @GetMapping("/customers/{customerid}")
    public ResponseEntity<Customer> getCustomerHandler(@PathVariable("customerid") Integer customerId) throws CustomerException{

        Customer existingCustomer = customerService.viewCustomer(customerId);

        return new ResponseEntity<Customer>(existingCustomer, HttpStatus.OK);

    }

    @GetMapping("/getallcustomers/{city}")
    public ResponseEntity<List<Customer>> getAllCustomersByLocation(@PathVariable("city") String city) throws CustomerException {

        List<Customer> customersByLocation = customerService.viewAllCustomer(city);

        return new ResponseEntity<List<Customer>>(customersByLocation, HttpStatus.OK);

    }


}
