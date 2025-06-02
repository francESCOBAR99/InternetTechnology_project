package ch.fhnw.thrift.business.service;

import ch.fhnw.thrift.data.domain.User;
import ch.fhnw.thrift.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(String username, User user) {
        User existingUser = getUserByUsername(username);
        existingUser.setPassword(user.getPassword()); // Assuming password is updated
        existingUser.setRole(user.getRole()); // Assuming role is updated
        return userRepository.save(existingUser);
    }

    public void deleteUser(String username) {
        User user = getUserByUsername(username);
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
