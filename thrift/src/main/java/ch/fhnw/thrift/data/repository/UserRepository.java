package ch.fhnw.thrift.data.repository;

import ch.fhnw.thrift.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username (for authentication)

    Optional<User> findByUsername(String username);

}
