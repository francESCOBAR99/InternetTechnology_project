package ch.fhnw.thrift.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.thrift.data.domain.Item;

@Repository

public interface ItemRepository extends JpaRepository<Item, Long> {
    
    // finding item by ID 
    Item findById(long id);

    // checking if item exists by name
    boolean existsByName(String name);
}

