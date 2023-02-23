package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Exceptions.CustomerException;
import com.example.cinemaapp.Exceptions.LoginException;
import com.example.cinemaapp.Exceptions.UserException;
import com.example.cinemaapp.Model.CurrentUserSession;
import com.example.cinemaapp.Model.Customer;
import com.example.cinemaapp.Model.User;
import com.example.cinemaapp.Repository.CurrentUserSessionRepo;
import com.example.cinemaapp.Repository.CustomerRepo;
import com.example.cinemaapp.Service.CurrentCustomerService;
import com.example.cinemaapp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CurrentUserSessionRepo currentUserSessionRepo;

    @Autowired
    CurrentCustomerService currentCustomerService;

    @Override
    public CurrentUserSession addUser(User user) throws UserException, CustomerException {
        Optional<Customer> opt = customerRepo.findByUsername(user.getUserId()) ;

        if(opt.isEmpty()) {
            throw new CustomerException("User not found with Mobile number : "+user.getUserId());
        }

        Customer currentCustomer = opt.get();

        Integer customerId = currentCustomer.getCustomerId();

        Optional<CurrentUserSession> currentUserOptional = currentUserSessionRepo.findByCustomerId(customerId);

        if(currentUserOptional.isPresent()) {
            throw new UserException("User has already logged in with userId : " + user.getUserId());
        }
        if(currentCustomer.getMobile_number().equals(user.getUserId()) && currentCustomer.getPassword().equals(user.getPassword())) {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String key = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            CurrentUserSession currentUserSession = new CurrentUserSession(customerId, key, LocalDateTime.now()) ;
            return  currentUserSessionRepo.save(currentUserSession) ;
        }
        else {
            throw new UserException("Invalid UserId OR Password");
        }
    }



    @Override
    public String signOut(String key) throws UserException, LoginException {
        CurrentUserSession userSession = currentCustomerService.getCurrentCustomerSession(key);

        if(userSession != null) {

            currentUserSessionRepo.delete(userSession);


            return "Logged out...";
        }
        else {
            throw new UserException("Having some problem to logout");
        }
    }

    @Override
    public User removeUser(User user, String key) throws UserException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User validateUser(User user, String key) throws UserException {

        Optional<CurrentUserSession> opt = currentUserSessionRepo.findByUuid(key) ;

        if(opt.isEmpty()) {
            throw new UserException("Invalid Key");
        }

        CurrentUserSession currentUserSession = opt.get();

        Optional<Customer> currentCustomerOpt = customerRepo.findById(currentUserSession.getCustomerId()) ;

        Customer currentCustomer = currentCustomerOpt.get();

        if(user.getUserId().equals(currentCustomer.getMobile_number()) && user.getPassword().equals(currentCustomer.getPassword())) {
            return user;
        }
        else {
            throw new UserException("Invalid Mobile Number or Password");
        }


    }

}

