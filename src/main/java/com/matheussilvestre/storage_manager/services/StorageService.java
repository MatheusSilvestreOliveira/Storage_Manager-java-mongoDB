package com.matheussilvestre.storage_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheussilvestre.storage_manager.domain.Storage;
import com.matheussilvestre.storage_manager.repository.StorageRepository;
import com.matheussilvestre.storage_manager.services.exception.ObjectNotFoundException;

@Service
public class StorageService {

	@Autowired
	private StorageRepository repository;
	
	public List<Storage> findAll(){
		return repository.findAll();
	}
	
	public Storage findById(String id) {
		Optional<Storage> storage = repository.findById(id);
		return storage.orElseThrow(() -> new ObjectNotFoundException("Object not found in database"));
	}
	
	public Storage insert(Storage obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Storage update(Storage obj) {
		Storage attSto = findById(obj.getId());
		updateData(attSto, obj);
		return repository.save(attSto);
	}

	private void updateData(Storage attSto, Storage obj) {
		attSto.setStorage_unit(obj.getStorage_unit());
	}
	
}
