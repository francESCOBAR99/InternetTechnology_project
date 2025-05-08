package ch.fhnw.thrift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.thrift.business.service.ItemService;
import ch.fhnw.thrift.data.domain.Item;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class ThriftApplication {

	@Autowired
	private ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(ThriftApplication.class, args);
	}
	

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		Item item1 = new Item();
		item1.setName("FHNW Tote Bag");
		item1.setDescription("Official FHNW merch");
		item1.setPrice(15.0);
		itemService.createItem(item1);

		Item item2 = new Item();
		item2.setName("Business Maths Book");
		item2.setDescription("Barely used Business Maths 1 Book for BIT students");
		item2.setPrice(25.0);
		itemService.createItem(item2);
		
	}

}
