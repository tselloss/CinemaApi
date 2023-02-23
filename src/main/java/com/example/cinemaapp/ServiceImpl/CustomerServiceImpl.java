package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Exceptions.CustomerException;
import com.example.cinemaapp.Exceptions.LoginException;
import com.example.cinemaapp.Model.Customer;
import com.example.cinemaapp.Repository.CurrentUserSessionRepo;
import com.example.cinemaapp.Repository.CustomerRepo;
import com.example.cinemaapp.Service.CurrentCustomerService;
import com.example.cinemaapp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CurrentCustomerService currentCustomerService;


    //todo
    @Autowired
    CurrentUserSessionRepo currentUserSessionRepo;

    @Override
    public Customer addCustomer(Customer cust) throws CustomerException {
       Optional<Customer> opt = customerRepo.findByUsername(cust.getUsername()) ;
        if(opt.isPresent()) {
            throw new CustomerException("Customer already Exist With this Username");
        }
        return customerRepo.save(cust);
    }

    @Override
    public Customer updateCustomer(Customer cust, String key) throws CustomerException, LoginException {

        Customer customerDetails = currentCustomerService.getCustomerDetails(key) ;

        if(customerDetails == null) {
            throw new LoginException("No user Found | Login first");
        }else if( cust.getMobile_number().toCharArray().length != 10 ){

            throw new CustomerException("Mobile Number can only be of 10 digit");
        }

        if(cust.getCustomerId() == customerDetails.getCustomerId()) {
            return customerRepo.save(cust) ;
        }
        else {
            throw new CustomerException("Can't change UserID!") ;
        }


    }
    @Override
    public Customer getCustomerDetailsByUsername(String username) throws Exception {
        return customerRepo.findByUsername(username)
                .orElseThrow(
                        () -> new Exception("Customer not found with username: " + username)
                );
    }

    @Override
    public Customer removeCustomer(Customer cust, String key) throws CustomerException, LoginException {

//		Optional<Customer> opt = customerDao.findById(cust.getCustomerId());
//
//		if(opt.isEmpty()) {
//			throw new CustomerException("Customer is not registered");
//		}

//        Customer currentCustomer = currentUserSessionService.getCustomerDetails(key);
//
//        if(currentCustomer != null) {
//
//            if(cust.getCustomerId() == currentCustomer.getCustomerId()) {
//
//                customerRepo.delete(cust);
//
//                Optional<CurrentUserSession> opt = currentUserSessionDao.findByUuid(key) ;
//
//                CurrentUserSession currentSession = opt.get();
//
//                currentUserSessionDao.delete(currentSession);
//                return cust;
//
//
//            }
//            else {
//                throw new CustomerException("Invalid Customer ID") ;
//            }
//
//        }
//        else {
//            throw new CustomerException("Invalid UUID key");
//        }
//


        return null;
    }

    @Override
    public Customer viewCustomer(Integer customerId) throws CustomerException {
        Optional<Customer> cust = customerRepo.findById(customerId);
        cust.orElseThrow(()-> new CustomerException("Customer doesn't found..."));
        return cust.get();

    }

    @Override
    public List<Customer> viewAllCustomer() throws CustomerException {
        return customerRepo.findAll();
    }

}
