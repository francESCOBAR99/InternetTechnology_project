package ch.fhnw.thrift.controller;

import ch.fhnw.thrift.business.service.UserService; // Service layer to handle business logic
import ch.fhnw.thrift.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    // get user details by username
    @GetMapping(path = "/user/{username}", produces ="application/json")
    public ResponseEntity getUserByUsername(@PathVariable String username){
        try{
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(user);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //Return null if user not found
        }
    }

    // Register a new user
    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity registerUser(@RequestBody User user){
        try {
            User createdUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); //handle user creation conflict
        }
    }
        

    // Update user details
    @PutMapping(path = "/user/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateUser(@PathVariable String username, @RequestBody User user){
        try {
            User updatedUser = userService.updateUser(username, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return not found if user does not exist
        }
    }

    // Delete a user by username
    @DeleteMapping(path = "/user/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username){
        try {
            userService.deleteUser(username);
            return ResponseEntity.ok("User with username " + username + " deleted successfully");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

        }
    }

    // get all users (optional endpoint)
//@GetMapping(path = "", produces = "application/json")
//public ResponseEntity<User> getAllUsers(){
//    List<User> user = userService.getAllUsers();
//    return ResponseEntity.ok(user); //Return a list of all users
//}
}
