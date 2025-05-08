package ch.fhnw.thrift.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.thrift.data.domain.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // finding category by name 
    Category findByCategoryName(String categoryName);

    // finding all categories where the category type contains specific string
    List<Category> findAllByCategoryTypeContainsIgnoreCase(String categoryType);

    // finding all categories associated with specific item ID 
    List<Category> findAllByItem_Id(Long itemID);
}
