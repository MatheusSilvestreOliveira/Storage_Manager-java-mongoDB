package com.matheussilvestre.storage_manager.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheussilvestre.storage_manager.domain.Product;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts(){
		Product p1 = new Product("1", "Boneco", "Hasbro", 129.99);
		Product p2 = new Product("2", "CD Player", "Sony", 200);
		List<Product> list = new ArrayList<>();
		list.addAll(Arrays.asList(p1,p2));
		return ResponseEntity.ok().body(list);
	}
	
}
