package com.matheussilvestre.storage_manager.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheussilvestre.storage_manager.domain.Category;
import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.domain.Storage;
import com.matheussilvestre.storage_manager.repository.CategoryRepository;
import com.matheussilvestre.storage_manager.repository.ProductRepository;
import com.matheussilvestre.storage_manager.repository.StorageRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StorageRepository storageRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Delete everything and add them again for tests
		
		productRepository.deleteAll();
		categoryRepository.deleteAll();
		storageRepository.deleteAll();
		
		Storage s1 = new Storage(null, "Morumbi", "Brazil", "São Paulo", "Test Street ABC");
		Storage s2 = new Storage(null, "Osasco", "Brazil", "São Paulo", "Test Street DEFG");
		Storage s3 = new Storage(null, "Centro", "Brazil", "Curitiba", "Test Road HIJ");
		Storage s4 = new Storage(null, "Uptown", "United States", "New York", "Test Avenue KLMN");
		
		storageRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Clothes");
		Category c3 = new Category(null, "Toys");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Product p1 = new Product(null, "Television", "Samsung", 4000.00, c1);
		Product p2 = new Product(null, "CD Player", "Sony", 299.90, c1);
		Product p3 = new Product(null, "Shoes Red and Black", "Nike",359.90, c2);
		Product p4 = new Product(null, "Batman Action Figure", "Hasbro", 199.00, c3);
		Product p5 = new Product(null, "Iphone X", "Apple", 2700.00, c1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}

}
