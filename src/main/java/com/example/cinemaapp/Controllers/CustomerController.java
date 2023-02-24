package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.Exceptions.CustomerException;
import com.example.cinemaapp.Exceptions.LoginException;
import com.example.cinemaapp.Model.Customer;
import com.example.cinemaapp.Service.CustomerService;
import com.example.cinemaapp.ServiceImpl.EmailSenderServiceImpl;
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

    @Autowired
    private EmailSenderServiceImpl emailSenderService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException{
        Customer addedCustomer = customerService.addCustomer(customer);
        emailSenderService.sendEmail(customer.getEmail(),"Registry confirmation","Dear "+customer.getUsername() +
                                                                                                    " \n  We are very happy for your registration to our Cinema application for your bookings \n" +
                "   Enjoy your time." );
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

    @GetMapping("/getallcustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerException {
        List<Customer> customers = customerService.viewAllCustomer();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }


}
