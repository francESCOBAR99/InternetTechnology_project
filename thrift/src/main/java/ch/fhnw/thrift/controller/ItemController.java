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
@RequestMapping(path="/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path="/pizzas/{id}", produces = "application/json")
    public ResponseEntity getItem(@PathVariable Long id) {
        try{
            Item item = itemService.findItemById(id);
            return ResponseEntity.ok(item);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item found with given id");
        }
    }

    @GetMapping(path="/item", produces = "application/json")
    public List<Item> getItemList() {
        List<Item> itemList = itemService.getAllItems();

        return itemList;
    }

    @PostMapping(path="/item", consumes="application/json", produces = "application/json")
    public ResponseEntity addItem(@RequestBody Item item) {
        try{
            item = itemService.addItem(item);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Item already exists with given name");
        }
        return ResponseEntity.ok(item);
        
    }

    @PutMapping(path="/item/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody Item item) {
        try{
            item = itemService.updateItem(id, item);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No item found with given id");

        }
        return ResponseEntity.ok(item);
        
    }

    @DeleteMapping(path="/item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        try{
            itemService.deleteItem(id);
            return ResponseEntity.ok("Item with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }

//    @GetMapping(path="", produces = "application/json")
//    public ResponseEntity<Menu> getMenu(@RequestParam String location) {
//        Menu menu = menuService.getMenuByLocation(location);
//        return ResponseEntity.ok(menu);      
//    }
    
//}
