package com.matheussilvestre.storage_manager.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheussilvestre.storage_manager.domain.Category;
import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.domain.ProductInStorage;
import com.matheussilvestre.storage_manager.domain.Storage;
import com.matheussilvestre.storage_manager.repository.CategoryRepository;
import com.matheussilvestre.storage_manager.repository.ProductInStorageRepository;
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
	
	@Autowired
	private ProductInStorageRepository productInStorageRepository;
	
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
		
		ProductInStorage ps1 = new ProductInStorage(null, s1, p1, 15);
		ProductInStorage ps2 = new ProductInStorage(null, s1, p2, 32);
		ProductInStorage ps3 = new ProductInStorage(null, s1, p5, 13);
		
		ProductInStorage ps4 = new ProductInStorage(null, s2, p1, 23);
		ProductInStorage ps5 = new ProductInStorage(null, s2, p2, 8);
		ProductInStorage ps6 = new ProductInStorage(null, s2, p3, 18);
		ProductInStorage ps7 = new ProductInStorage(null, s2, p4, 27);
		ProductInStorage ps8 = new ProductInStorage(null, s2, p5, 3);

		ProductInStorage ps9 = new ProductInStorage(null, s3, p3, 54);
		ProductInStorage ps10 = new ProductInStorage(null, s3, p4, 42);
		
		ProductInStorage ps11 = new ProductInStorage(null, s2, p1, 7);
		ProductInStorage ps12 = new ProductInStorage(null, s2, p2, 19);
		ProductInStorage ps13 = new ProductInStorage(null, s2, p3, 4);
		ProductInStorage ps14 = new ProductInStorage(null, s2, p5, 14);
		
		productInStorageRepository.saveAll(Arrays.asList(ps1, ps2, ps3, ps4, ps5, ps6, ps7, ps8, ps9, ps10, ps11, ps12, ps13, ps14));
	}

}
