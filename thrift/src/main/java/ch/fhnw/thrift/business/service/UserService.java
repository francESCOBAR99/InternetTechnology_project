package ch.fhnw.thrift.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.thrift.data.domain.User;
import ch.fhnw.thrift.data.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        try {
            User user = userRepository.findById(id).get();
            return user;
        } catch (Exception e) {
            throw new RuntimeException("User with id " + id + " not found");
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User findByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("User with username " + username + " not found");
        }
    }

    public User addUser(User user) throws Exception {
        if(user.getUsername() != null && user.getPassword() != null) {
            if (userRepository.findByUsername(user.getUsername()) == null)
                return userRepository.save(user);
            throw new Exception("User " + user.getUsername() + " already exists");
        }
        throw new Exception("Invalid username or password");
    }

    public User updateUser(Long id, User user) throws Exception {
        User userToUpdate = userRepository.findById(id).get();
        if(userToUpdate != null) {
            if(user.getUsername() != null)
                userToUpdate.setUsername(user.getUsername());
            if(user.getPassword() != null)
                userToUpdate.setPassword(user.getPassword());
            if(user.getRole() != null)
                userToUpdate.setRole(user.getRole());
            return userRepository.save(userToUpdate);
        } throw new Exception("No user found with id " + id);
}

    public void deleteUser(Long id) throws Exception {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else 
            throw new Exception("No user found with id " + id);
        }
    }
