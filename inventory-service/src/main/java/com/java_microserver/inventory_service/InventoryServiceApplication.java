package com.java_microserver.inventory_service;

import com.java_microserver.inventory_service.Repository.InventoryRepository;
import com.java_microserver.inventory_service.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {

		return args -> {
			Inventory inventory = new Inventory();
			Inventory inventory2 = new Inventory();

			inventory.setSkuCode("iphone_19");
			inventory.setQuantity(100);

			inventory2.setSkuCode("iphone_20");
			inventory2.setQuantity(200);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};

	}
}
