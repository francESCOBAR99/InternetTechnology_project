package ch.fhnw.thrift.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.thrift.data.domain.User;
import java.util.List;


@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    // finding user by username 
    User findByUsername(String username);

    // finding user by email
    User findByEmail(String email);

    // checking if user exists by username
    boolean existsByUsername(String username);

    // checking if user exists by email 
    boolean existsByEmail(String email);
}

