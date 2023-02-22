package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.Exceptions.CustomerException;
import com.example.cinemaapp.Exceptions.LoginException;
import com.example.cinemaapp.Exceptions.UserException;
import com.example.cinemaapp.Model.CurrentUserSession;
import com.example.cinemaapp.Model.User;
import com.example.cinemaapp.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<CurrentUserSession> addUser(@Valid @RequestBody User user) throws UserException, CustomerException {

        CurrentUserSession currentSession = loginService.addUser(user);

        return new ResponseEntity<CurrentUserSession>(currentSession, HttpStatus.CREATED) ;
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestParam String key) throws UserException, LoginException {
        String response = loginService.signOut(key);
        return new ResponseEntity<String>(response,HttpStatus.OK) ;
    }
}
