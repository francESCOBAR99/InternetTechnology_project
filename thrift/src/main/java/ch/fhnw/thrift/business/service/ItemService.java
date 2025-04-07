package ch.fhnw.thrift.business.service;

// still to do! 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.thrift.data.domain.Item;
import ch.fhnw.thrift.data.domain.Catgory;
import ch.fhnw.thrift.data.repository.ItemRepository;
import ch.fhnw.thrift.data.repository.CategoryRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item findItemaById(Long id) {
        try {
            Item item = itemRepository.findById(id).get();
            return item;
        } catch (Exception e) {
            throw new RuntimeException("Item with id " + id + " not found");
        }
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Item createItem(Item item) throws Exception {
        if(pizza.getItemName() != null) {
            if (itemRepository.findByItemaName(item.getItemName()) == null)
                return itemRepository.save(item);
            throw new Exception("Item " + item.getItemName() + " already exists");
        }
        throw new Exception("Invalid item name ");
    }


    // how to update the item? - still to do 
    public item updatePizza(Long id, Pizza pizza) throws Exception {
        Pizza pizzaToUpdate = pizzaRepository.findById(id).get();
        if(pizzaToUpdate != null) {
            if(pizza.getPizzaName() != null)
                pizzaToUpdate.setPizzaName(pizza.getPizzaName());
            if(pizza.getPizzaToppings() != null)
                pizzaToUpdate.setPizzaToppings(pizza.getPizzaToppings());
            return pizzaRepository.save(pizzaToUpdate);
        }
        throw new Exception("Pizza with id " + id + " does not exist");
    }

    public void deletePizza(Long id) throws Exception {
        if(pizzaRepository.existsById(id)) {
            pizzaRepository.deleteById(id);
        } else
            throw new Exception("Pizza with id " + id + " does not exist");
    }

    //Business Logic to get current offer according to the location of the user requesting the menu
    private String getCurrentOffer(String location) {
        String currentOffer = "No special offer for your location. Do check back again.";
        if("Basel".equalsIgnoreCase(location))
            currentOffer = "10% off on all large pizzas!!!";
        else if("Brugg".equalsIgnoreCase(location))
            currentOffer = "Two for the price of One on all small pizzas!!!";
        return currentOffer;
    }

    public Menu getMenuByLocation(String location) {
        String currentOffer = getCurrentOffer(location);
        List<Pizza> pizzaList = getAllPizzas();
        Menu menu = new Menu();
        menu.setPizzaList(pizzaList);
        menu.setCurrentOffer(currentOffer);
        return menu;
    }

        
}
