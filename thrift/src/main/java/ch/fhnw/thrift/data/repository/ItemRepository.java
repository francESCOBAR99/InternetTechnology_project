package ch.fhnw.thrift.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Item;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByItemName(String itemName);
    List<Item> findAllByItemDescriptionContainsIgnoreCase(String description);
    List<Item> findBySuspiciousTrue();
}
