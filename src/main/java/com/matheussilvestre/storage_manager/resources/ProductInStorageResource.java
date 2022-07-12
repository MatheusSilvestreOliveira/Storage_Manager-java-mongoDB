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

import com.matheussilvestre.storage_manager.domain.ProductInStorage;
import com.matheussilvestre.storage_manager.services.ProductInStorageService;

@RestController
@RequestMapping(value="/productsInStorage")
public class ProductInStorageResource {

	@Autowired
	private ProductInStorageService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<ProductInStorage>> findAllProductInStorages(){
		List<ProductInStorage> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProductInStorage> findById(@PathVariable String id){
		ProductInStorage pis = service.findById(id);
		return ResponseEntity.ok().body(pis);
	}

	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ProductInStorage obj){
		ProductInStorage pis = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pis.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> insert(@PathVariable String id, @RequestBody ProductInStorage obj){
		ProductInStorage pis = obj;
		pis.setId(id);
		pis = service.update(pis);
		return ResponseEntity.noContent().build();
	}
	
}
