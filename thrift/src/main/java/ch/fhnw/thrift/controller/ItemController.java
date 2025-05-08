package ch.fhnw.thrift.controller;

import ch.fhnw.thrift.business.service.ItemService;
import ch.fhnw.thrift.data.domain.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        try{
            Item item = itemService.findByItemId(id);
            return ResponseEntity.ok(item);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Item>> getItemList() {
        try {
            List<Item> itemList = itemService.getAllItems();
            return ResponseEntity.ok(itemList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        try {
            Item createdItem = itemService.createItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
        } catch (Exception e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody Item item) {
        try{
            Item updatedItem = itemService.updateItem(id, item);
            return ResponseEntity.ok(updatedItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        try{
            itemService.deleteItem(id);
            return ResponseEntity.ok("Item with id " + id + " deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }
}
//    @GetMapping(path="", produces = "application/json")
//    public ResponseEntity<Menu> getMenu(@RequestParam String location) {
//        Menu menu = menuService.getMenuByLocation(location);
//        return ResponseEntity.ok(menu);      
//    }
    
//}
