package com.matheussilvestre.storage_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheussilvestre.storage_manager.domain.Category;
import com.matheussilvestre.storage_manager.repository.CategoryRepository;
import com.matheussilvestre.storage_manager.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(String id) {
		Optional<Category> category = repository.findById(id);
		return category.orElseThrow(() -> new ObjectNotFoundException("Object not found in database"));
	}
	
	public Category insert(Category obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Category update(Category obj) {
		Category attCat = findById(obj.getId());
		updateData(attCat, obj);
		return repository.save(attCat);
	}

	private void updateData(Category attCat, Category obj) {
		attCat.setCat_name(obj.getCat_name());
	}
	
}
