package com.matheussilvestre.storage_manager.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.repository.ProductRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Delete everything and add them again for tests
		
		productRepository.deleteAll();
		
		Product p1 = new Product(null, "Television", "Samsung", 4000.00);
		Product p2 = new Product(null, "CD Player", "Sony", 299.90);
		Product p3 = new Product(null, "Shoes Red and Black", "Nike", 359.90);
		Product p4 = new Product(null, "Batman Action Figure", "Hasbro", 199.00);
		Product p5 = new Product(null, "Iphone X", "Apple", 2700.00);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}

}
