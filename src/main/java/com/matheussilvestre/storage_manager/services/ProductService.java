package com.matheussilvestre.storage_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.dto.ProductDTO;
import com.matheussilvestre.storage_manager.repository.ProductRepository;
import com.matheussilvestre.storage_manager.services.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(String id) {
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException("Object not found in database"));
	}
	
	public Product insert(Product obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Product update(Product obj) {
		Product attProd = findById(obj.getId());
		updateData(attProd, obj);
		return repository.save(attProd);
	}

	private void updateData(Product attProd, Product obj) {
		attProd.setProduct_name(obj.getProduct_name());
		attProd.setProduct_brand(obj.getProduct_brand());
		attProd.setValue(obj.getValue());
	}
	
	public Product fromDTO(ProductDTO objDto) {
		return new Product(objDto.getId(), objDto.getProduct_name(), objDto.getProduct_brand(), objDto.getValue());
	}
}
