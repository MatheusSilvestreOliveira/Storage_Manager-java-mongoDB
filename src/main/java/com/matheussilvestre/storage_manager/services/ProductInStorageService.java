package com.matheussilvestre.storage_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheussilvestre.storage_manager.domain.ProductInStorage;
import com.matheussilvestre.storage_manager.repository.ProductInStorageRepository;
import com.matheussilvestre.storage_manager.services.exception.ObjectNotFoundException;

@Service
public class ProductInStorageService {

	@Autowired
	private ProductInStorageRepository repository;
	
	public List<ProductInStorage> findAll(){
		return repository.findAll();
	}
	
	public ProductInStorage findById(String id) {
		Optional<ProductInStorage> pis = repository.findById(id);
		return pis.orElseThrow(() -> new ObjectNotFoundException("Object not found in database"));
	}
	
	public ProductInStorage insert(ProductInStorage obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public ProductInStorage update(ProductInStorage obj) {
		ProductInStorage attPis = findById(obj.getId());
		updateData(attPis, obj);
		return repository.save(attPis);
	}

	private void updateData(ProductInStorage attPis, ProductInStorage obj) {
		attPis.setProduct_id(obj.getProduct_id());
		attPis.setStorage_id(obj.getStorage_id());
		attPis.setProduct_quantity(obj.getProduct_quantity());
		attPis.setProduct_value(obj.getProduct_value());
		attPis.setTotal_value(obj.getProduct_quantity()*obj.getProduct_value());
	}
	
}
