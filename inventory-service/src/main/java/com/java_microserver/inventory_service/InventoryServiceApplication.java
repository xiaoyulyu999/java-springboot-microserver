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
			inventory.setSkuCode("iphone_19");
			inventory.setQuantity(100);
			inventoryRepository.save(inventory);
		};

	}

}
