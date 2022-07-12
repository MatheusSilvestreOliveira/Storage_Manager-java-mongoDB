package com.matheussilvestre.storage_manager.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheussilvestre.storage_manager.domain.Storage;
import com.matheussilvestre.storage_manager.services.StorageService;

@RestController
@RequestMapping(value="/storages")
public class StorageResource {

	@Autowired
	private StorageService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<Storage>> findAllProducts(){
		List<Storage> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Storage> findById(@PathVariable String id){
		Storage storage = service.findById(id);
		return ResponseEntity.ok().body(storage);
	}

	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Storage obj){
		Storage storage = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(storage.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> insert(@PathVariable String id, @RequestBody Storage obj){
		Storage storage = obj;
		storage.setId(id);
		storage = service.update(storage);
		return ResponseEntity.noContent().build();
	}
	
}
