package com.lucas.bright.controller;

import com.lucas.bright.model.User;
import com.lucas.bright.service.UserService;
import com.lucas.bright.util.ApiError;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas Daniel
 */
@RestController // For use restfull endpoints
@RequestMapping("/service/user/realm") // this is the endpoint
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(User.class);

    //dependency Injection
    @Autowired
    private UserService userService;

    @PostMapping(
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<?> addUserRealm(@Valid @RequestBody User user,
            BindingResult result) {
        
        log.info("Add User Realm: {}", user.toString());

        // verify if exist any error of the submit code (validate in the User Annotations)
        if (result.hasErrors()) {
            log.error("error - User{}", user.getName());
            //here i use the API error for the result 
            ApiError apiError = new ApiError("InvalidRealmName");
            //set return status CODE and body
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }

        Optional<User> userDb = userService.findUserByName(user);
        
        //if the database return any User(by existing name) then error is set
        if (userDb.isPresent()) {
            log.error("error - exist User{}", userDb.get().getName());
            ApiError apiError = new ApiError("DuplicateRealmName");
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }
        
        //set KEY
        user.setKey(methodEncrytPassword());

        //save the object in database
        User usersave = userService.saveUser(user);
        
        //set status code e body to return
        return ResponseEntity.status(HttpStatus.CREATED).body(usersave);
    }
    
    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> getUserRealmXml(@PathVariable("id") int id) {
        log.info(" Get UserRealm with ID : {}", id);
        
        Optional<User> user = userService.findUserById(id);

        if (!user.isPresent()) {
            log.info(" Error to find ID {}:", id);
            ApiError apiError = new ApiError("InvalidRealmID");
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(user.get());
    }

    private String methodEncrytPassword() {
        //code for Encrypt Key
        return "1400136ef3a6777174d76206faef38a3";
    }
}
