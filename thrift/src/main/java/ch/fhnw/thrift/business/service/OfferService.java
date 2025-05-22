package ch.fhnw.thrift.business.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Offer;
import ch.fhnw.pizza.data.domain.SuspiciousItemReport;
import ch.fhnw.pizza.data.domain.Item;
import ch.fhnw.pizza.data.repository.ItemRepository;
import ch.fhnw.pizza.data.repository.SuspiciousItemReportRepository;

@Service
public class OfferService {

    @Autowired
    private ItemRepository itemRepository;

    public Item findItemById(Long id) {
        try {
            Item item = itemRepository.findById(id).get();
            return item;
        } catch (Exception e) {
            throw new RuntimeException("Item with id " + id + " not found");
        }
    }

    public List<Item> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }

    public Item addItem(Item item) throws Exception {
        if(item.getItemName() != null) {
            if (itemRepository.findByItemName(item.getItemName()) == null)
                return itemRepository.save(item);
            throw new Exception("Item " + item.getItemName() + " already exists");
        }
        throw new Exception("Invalid item name ");
    }

    public Item updateItem(Long id, Item item) throws Exception {
        Item itemToUpdate = itemRepository.findById(id).get();
        if(itemToUpdate != null) {
            if(item.getItemName() != null)
                itemToUpdate.setItemName(item.getItemName());
            if(item.getItemDescription() != null)
                itemToUpdate.setItemDescription(item.getItemDescription());
            if(item.getItemPrice() != null)
                itemToUpdate.setItemPrice(item.getItemPrice());
            if(item.getItemCondition() != null)
                itemToUpdate.setItemCondition(item.getItemCondition());
            if(item.getItemLocation() != null)
                itemToUpdate.setItemLocation(item.getItemLocation());
            if(item.getItemDateCreated() != null)
                itemToUpdate.setItemDateCreated(item.getItemDateCreated());
            if(item.getItemImage() != null)
                itemToUpdate.setItemImage(item.getItemImage()); 
            if(item.isSuspicious() != false)
                itemToUpdate.setSuspicious(item.isSuspicious());
            return itemRepository.save(itemToUpdate);
        }
        throw new Exception("Item with id " + id + " does not exist");
    }

    public void deleteItem(Long id) throws Exception {
        if(itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else
            throw new Exception("Item with id " + id + " does not exist");
    }

    //Business Logic to get current offer according to the location of the user requesting the menu
    private String getCurrentOffer(String location) {
        String currentOffer = "No offers in your location. Do check back again.";
        if("Basel".equalsIgnoreCase(location))
            currentOffer = "Basel offers are listed below";
        else if("Brugg".equalsIgnoreCase(location))
            currentOffer = "Brugg offers are listed below";
        return currentOffer;
    }

    public Offer getOfferByLocation(String location) {
        String currentOffer = getCurrentOffer(location);
        List<Item> itemList = getAllItems();
        Offer offer = new Offer();
        offer.setItemList(itemList);
        offer.setCurrentOffer(currentOffer);
        return offer;
    }

    public void reportSuspiciousItem(Long itemId) throws Exception {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new Exception("Item with id " +itemId + " note found"));
        item.setSuspicious(true);
        itemRepository.save(item);
    }

    @Autowired
private SuspiciousItemReportRepository suspiciousItemReportRepository;

public SuspiciousItemReport reportSuspiciousItem(Long itemId, String reportedBy, String reason) throws Exception {
    Item item = itemRepository.findById(itemId)
        .orElseThrow(() -> new Exception("Item with id " + itemId + " does not exist"));
    item.setSuspicious(false);
    itemRepository.save(item);

    SuspiciousItemReport report = new SuspiciousItemReport();
    report.setItem(item);
    report.setReportedBy(reportedBy);
    report.setReason(reason);
    return suspiciousItemReportRepository.save(report);
}

public List<SuspiciousItemReport> getReportsForItem(Long itemId) {
    return suspiciousItemReportRepository.findByItemId(itemId);
}
        
}


