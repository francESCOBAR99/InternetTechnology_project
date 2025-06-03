// filepath: /workspaces/InternetTechnology_project/thrift/src/main/java/ch/fhnw/thrift/ThriftApplication.java
package ch.fhnw.thrift;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.thrift.business.service.OfferService;
import ch.fhnw.thrift.data.domain.Item;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class ThriftApplication {

	@Autowired
	private OfferService offerService;

	public static void main(String[] args) {
		SpringApplication.run(ThriftApplication.class, args);
	}
	

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		Item item = new Item();
		item.setItemName("Business Maths");
		item.setItemDescription("Business Maths book for sem. 1");
		item.setItemPrice(20.0);
		item.setItemCondition("New");
		item.setItemLocation("Basel");
		item.setItemDateCreated(LocalDateTime.now());
		item.setItemImage("https://placehold.co/400");
		offerService.addItem(item);

		item = new Item();
		item.setItemName("FHNW Tote Bag");
		item.setItemDescription("Used FHNW Tote Bag");
		item.setItemPrice(5.0);
		item.setItemCondition("Used");
		item.setItemLocation("Brugg");
		item.setItemDateCreated(LocalDateTime.now());
		item.setItemImage("https://placehold.co/400");
		offerService.addItem(item);

		item = new Item();
		item.setItemName("FHNW Hoodie");
		item.setItemDescription("Barely used FHNW Hoodie");
		item.setItemPrice(10.0);
		item.setItemCondition("Barely Used");
		item.setItemLocation("Olten");
		item.setItemDateCreated(LocalDateTime.now());
		item.setItemImage("https://placehold.co/400");
		offerService.addItem(item);
		
	}

}
