package com.matheussilvestre.storage_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.repository.ProductRepository;
import com.matheussilvestre.storage_manager.services.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository reposiroty;
	
	public List<Product> findAll(){
		return reposiroty.findAll();
	}
	
	public Product findById(String id) {
		Optional<Product> product = reposiroty.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException("Object not found in database"));
	}
	
}
