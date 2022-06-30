package com.matheussilvestre.storage_manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository reposiroty;
	
	public List<Product> findAll(){
		return reposiroty.findAll();
	}
	
}
