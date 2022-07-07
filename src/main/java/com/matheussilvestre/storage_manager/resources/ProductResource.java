package com.matheussilvestre.storage_manager.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.dto.ProductDTO;
import com.matheussilvestre.storage_manager.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAllProducts(){
		List<Product> list = service.findAll();
		List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProductDTO> findById(@PathVariable String id){
		Product product = service.findById(id);
		return ResponseEntity.ok().body(new ProductDTO(product));
	}

	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ProductDTO objDto){
		Product product = service.fromDTO(objDto);
		product = service.insert(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> insert(@PathVariable String id, @RequestBody ProductDTO objDto){
		Product product = service.fromDTO(objDto);
		product.setId(id);
		product = service.update(product);
		return ResponseEntity.noContent().build();
	}
	
}
