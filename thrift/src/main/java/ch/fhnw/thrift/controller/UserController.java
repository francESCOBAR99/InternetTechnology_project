package ch.fhnw.thrift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.thrift.business.service.UserService;
import ch.fhnw.thrift.data.domain.User;

@RestController
@RequestMapping(path="users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/{id}", produces = "application/json")
    public ResponseEntity getUserById(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with given id");
        }
    }

    @GetMapping(path = "/user", produces = "application/json")
    public List<User> getAtllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user) {
        try {
            user = userService.addUser(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Item already exists with given name");

        } return ResponseEntity.ok(user);
        }

    @PutMapping(path="/user/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            user = userService.updateUser(id, user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No user found with id " + id);
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path="/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try { 
            userService.deleteUser(id);
            return ResponseEntity.ok("User with id " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with id " + id);
        }
    }

}
