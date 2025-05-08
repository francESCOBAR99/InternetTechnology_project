package ch.fhnw.thrift.business.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.thrift.data.domain.Item;
import ch.fhnw.thrift.data.domain.Category;
import ch.fhnw.thrift.data.repository.ItemRepository;
import ch.fhnw.thrift.data.repository.CategoryRepository;

@Service
public class ItemService {

    private final CategoryRepository categoryRepository = null;

    @Autowired
    private ItemRepository itemRepository;

    public Item findByItemId(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException("Item with id" + id + " not found");
        }
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Item createItem(Item item) throws Exception {
        if(item.getName() != null) {
            if (!itemRepository.existsById(item.getId())) {
                return itemRepository.save(item);
        }
            throw new Exception("Item " + item.getName() + " already exists");
        }
        throw new Exception("Invalid item name ");
    }

    public Item updateItem(Long id, Item updatedItem) throws Exception {
        Optional<Item> itemToUpdate = itemRepository.findById(id);
        if (itemToUpdate.isPresent()) {
            Item existingItem = itemToUpdate.get();
            if (updatedItem.getName() != null) {
            existingItem.setName(updatedItem.getName());
            }
            if (updatedItem.getDescription() != null) {
            existingItem.setDescription(updatedItem.getDescription());
            }
            if (updatedItem.getPrice() != null) {
            existingItem.setPrice(updatedItem.getPrice());
            }
            return itemRepository.save(existingItem);
        } 
        throw new Exception("Item with id " + id + " not found");

    }

    public void deleteItem(Long id) throws Exception {
        if(itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else { 
            throw new Exception("Pizza with id " + id + " does not exist");
        }
    }
        
}
