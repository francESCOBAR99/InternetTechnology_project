package ch.fhnw.thrift.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.thrift;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface UserRepository extends JpaRepository<User, Long> {
    Item findByUserId(String UserId);
}

