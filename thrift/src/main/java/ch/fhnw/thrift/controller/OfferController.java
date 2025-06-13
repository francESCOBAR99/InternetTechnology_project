package ch.fhnw.thrift.controller;

import ch.fhnw.thrift.business.service.OfferService;
import ch.fhnw.thrift.data.domain.Offer;
import ch.fhnw.thrift.data.domain.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping(path="/item/{id}", produces = "application/json")
    public ResponseEntity getItem(@PathVariable Long id) {
        try{
            Item item = offerService.findItemById(id);
            return ResponseEntity.ok(item);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item found with given id");
        }
    }

    @GetMapping(path="/item", produces = "application/json")
    public List<Item> getItemList() {
        List<Item> itemList = offerService.getAllItems();

        return itemList;
    }

    @PostMapping(path="/item", consumes="application/json", produces = "application/json")
    public ResponseEntity addItem(@RequestBody Item item) {
        try{
            item = offerService.addItem(item);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Item already exists with given name");
        }
        return ResponseEntity.ok(item);
        
    }

    @PutMapping(path="/item/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody Item item) {
        try{
            item = offerService.updateItem(id, item);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No item found with id " + id);

        }
        return ResponseEntity.ok(item);
        
    }

    @DeleteMapping(path="/item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        try{
            offerService.deleteItem(id);
            return ResponseEntity.ok("Item with id " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }

    @GetMapping(path="", produces = "application/json")
    public ResponseEntity<Offer> getOffer(@RequestParam String location) {
        Offer offer = offerService.getOfferByLocation(location);
        return ResponseEntity.ok(offer);      
    }

            @GetMapping(path="/user", produces = "application/json")
    public String getOffer() {
        return "logged in as user";

    }

            @GetMapping(path="/admin", produces = "application/json")
    public String getItems() {
        return "logged in as admin";
    }

    
}

